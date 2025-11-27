package com.example.demo.repository;
import com.example.demo.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    List<Turno> findByIdMascota(int idMascota);
    boolean existsByIdProfecionalAndFecha(int idProfecional, LocalDate fecha);
    List<Turno> findByFechaBetween(LocalDate desde, LocalDate hasta);
}