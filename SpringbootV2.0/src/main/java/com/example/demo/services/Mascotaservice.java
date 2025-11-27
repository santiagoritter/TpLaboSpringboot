package com.example.demo.services;

import com.example.demo.model.Mascota;
import com.example.demo.model.Turno;
import com.example.demo.repository.MascotasRepository;
import com.example.demo.repository.TurnoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.TipoMascotaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Mascotaservice {

    private MascotasRepository mascoRepo;
    private TurnoRepository turnoRepo;
    private UsuarioRepository usuarioRepo;
    private TipoMascotaRepository tipoMascotaRepo;

    public Mascotaservice(MascotasRepository mascoRepo, TurnoRepository turnoRepo, UsuarioRepository usuarioRepo, TipoMascotaRepository tipoMascotaRepo) {
        this.mascoRepo = mascoRepo;
        this.turnoRepo = turnoRepo;
        this.usuarioRepo = usuarioRepo;
        this.tipoMascotaRepo = tipoMascotaRepo;
    }

    public List<Turno> getHistorialPorMascota(int id_mascota) throws Exception {
        if (!mascoRepo.existsById(id_mascota)) {
            throw new Exception("No se encontró la mascota con ID " + id_mascota);
        }
        return turnoRepo.findByIdMascota(id_mascota);
    }

    public Mascota crear(Mascota nueva) throws Exception {
        if (nueva.getNombre() == null || nueva.getNombre().isBlank()) {
            throw new Exception("El nombre no puede estar vacío.");
        }
        if (nueva.getIdDuenio() != null && (nueva.getIdDuenio() == 0 || !usuarioRepo.existsById(nueva.getIdDuenio()))) {
            throw new Exception("El dueño especificado no existe.");
        }
        if (nueva.getIdTipo() == 0 || !tipoMascotaRepo.existsById(nueva.getIdTipo())) {
            throw new Exception("El tipo de mascota no existe.");
        }
        if (mascoRepo.existsByNombre(nueva.getNombre())) {
            throw new Exception("Ya existe una mascota con ese nombre.");
        }
        return mascoRepo.save(nueva);
    }
}