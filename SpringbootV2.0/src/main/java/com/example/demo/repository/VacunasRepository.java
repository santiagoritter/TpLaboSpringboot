package com.example.demo.repository;
import com.example.demo.model.Vacunas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VacunasRepository extends JpaRepository<Vacunas, Integer> {
    List<Vacunas> findByIdMascota(int idMascota);
}