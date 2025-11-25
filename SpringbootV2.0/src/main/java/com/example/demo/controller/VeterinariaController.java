package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.services.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VeterinariaController {

    @Autowired private VeterinariaService service;

    @PostMapping("/adopciones")
    public ResponseEntity<?> registrarAdopcion(@RequestParam int idMascota, @RequestParam int idUsuario) {
        try {
            service.registrarAdopcion(idMascota, idUsuario);
            return ResponseEntity.ok("Adopción registrada con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mascotas/{id}/historial")
    public ResponseEntity<Map<String, Object>> historialMedico(@PathVariable int id) {
        return ResponseEntity.ok(service.obtenerHistorial(id));
    }

    @PostMapping("/turnos")
    public ResponseEntity<?> reservarTurno(@RequestBody Turno turno) {
        try {
            service.reservarTurno(turno);
            return ResponseEntity.ok("Turno reservado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> turnosPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return ResponseEntity.ok(service.consultarTurnos(desde, hasta));
    }

    @PostMapping("/vacunas/aplicar")
    public ResponseEntity<?> aplicarVacuna(@RequestParam int idMascota, @RequestParam String tipo) {
        try {
            service.aplicarVacuna(idMascota, tipo);
            return ResponseEntity.ok("Vacuna aplicada y stock actualizado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mascotas/disponibles")
    public ResponseEntity<List<Mascota>> mascotasDisponibles() {
        return ResponseEntity.ok(service.mascotasDisponibles());
    }

    @GetMapping("/mascotas/ranking-visitas")
    public ResponseEntity<List<Mascota>> rankingVisitas() {
        return ResponseEntity.ok(service.rankingVisitas());
    }

    @PostMapping("/invitaciones")
    public ResponseEntity<Invitacion> crearInvitacion(@RequestParam int idInvitante, @RequestParam String email) {
        return ResponseEntity.ok(service.crearInvitacion(idInvitante, email));
    }
}