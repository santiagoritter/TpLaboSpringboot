package com.example.demo.services;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VeterinariaService {

    @Autowired private AdopcionRepository adopcionRepo;
    @Autowired private MascotasRepository mascotaRepo;
    @Autowired private TurnoRepository turnoRepo;
    @Autowired private VacunasRepository vacunasRepo;
    @Autowired private VacunaStockRepository stockRepo;
    @Autowired private AlertaStockRepository alertaRepo;
    @Autowired private InvitacionRepository invitacionRepo;
    @Autowired private UsuarioRepository usuarioRepo;


    @Transactional
    public void registrarAdopcion(int idMascota, int idUsuario) throws Exception {
        Mascota mascota = mascotaRepo.findById(idMascota).orElseThrow(() -> new Exception("Mascota no existe"));
        Usuario usuario = usuarioRepo.findById(idUsuario).orElseThrow(() -> new Exception("Usuario no existe"));

        if (mascota.getIdDuenio() != null) throw new Exception("El animal ya tiene dueño.");
        if (adopcionRepo.existsByIdUsuarioAndEstado(idUsuario, "RECHAZADA")) throw new Exception("El adoptante tiene antecedentes negativos.");
        if (mascotaRepo.countByIdDuenio(idUsuario) >= 3) throw new Exception("Límite de mascotas excedido.");


        Optional<Invitacion> invitacion = invitacionRepo.findByEmailInvitadoAndEstado(usuario.getMail(), "PENDIENTE");
        if (invitacion.isPresent()) {
            Invitacion inv = invitacion.get();
            inv.setEstado("CONCRETADA");
            inv.setIdInvitado(idUsuario);
            invitacionRepo.save(inv);
        }

        mascota.setIdDuenio(idUsuario);
        mascotaRepo.save(mascota);

        Adopcion adopcion = new Adopcion();
        adopcion.setIdMascota(idMascota);
        adopcion.setIdUsuario(idUsuario);
        adopcion.setFecha(LocalDate.now());
        adopcion.setEstado("APROBADA");
        adopcionRepo.save(adopcion);
    }


    public Map<String, Object> obtenerHistorial(int idMascota) {
        Map<String, Object> historial = new HashMap<>();
        historial.put("vacunas", vacunasRepo.findByIdMascota(idMascota));
        historial.put("turnos", turnoRepo.findByIdMascota(idMascota));
        return historial;
    }


    public void reservarTurno(Turno turno) throws Exception {
        if (turnoRepo.existsByIdProfecionalAndFecha(turno.getIdProfecional(), turno.getFecha())) {
            throw new Exception("El profesional ya tiene un turno en esa fecha.");
        }

        Mascota mascota = mascotaRepo.findById(turno.getIdMascota()).orElseThrow(() -> new Exception("Mascota no encontrada"));
        if (mascota.getEdad() > 0) {
            List<Vacunas> vacunas = vacunasRepo.findByIdMascota(turno.getIdMascota());
            if (vacunas.isEmpty()) {
                throw new Exception("La mascota no tiene vacunas registradas.");
            }
        }
        turnoRepo.save(turno);
    }


    public List<Turno> consultarTurnos(LocalDate desde, LocalDate hasta) {
        return turnoRepo.findByFechaBetween(desde, hasta);
    }


    @Transactional
    public void aplicarVacuna(int idMascota, String tipoVacuna) throws Exception {
        VacunaStock stock = stockRepo.findById(tipoVacuna).orElseThrow(() -> new Exception("Tipo de vacuna no existe"));

        if (stock.getStock() <= 0) throw new Exception("No hay stock disponible.");


        stock.setStock(stock.getStock() - 1);
        stockRepo.save(stock);


        Vacunas vacuna = new Vacunas();

        vacuna.setId((int) (System.currentTimeMillis() & 0xfffffff));

        vacuna.setIdMascota(idMascota);
        vacuna.setTipo(tipoVacuna);
        vacuna.setVencimiento(LocalDate.now().plusMonths(stock.getDuracionMeses()));
        vacunasRepo.save(vacuna);


        if (stock.getStock() <= stock.getStockMinimo()) {
            AlertaStock alerta = new AlertaStock();
            alerta.setTipoVacuna(tipoVacuna);
            alerta.setMensaje("Alerta: Stock bajo para " + tipoVacuna);
            alerta.setFechaAlerta(LocalDateTime.now());
            alertaRepo.save(alerta);
        }
    }


    public List<Mascota> mascotasDisponibles() {
        return mascotaRepo.findByIdDuenioIsNull();
    }


    public List<Mascota> rankingVisitas() {
        return mascotaRepo.findTop10ByOrderByVisitasDesc();
    }

    public Invitacion crearInvitacion(int idInvitante, String email) {
        Invitacion inv = new Invitacion();
        inv.setIdInvitante(idInvitante);
        inv.setEmailInvitado(email);
        inv.setCodigo(UUID.randomUUID().toString());
        inv.setFechaVencimiento(LocalDate.now().plusDays(7));
        inv.setEstado("PENDIENTE");
        return invitacionRepo.save(inv);
    }
}
