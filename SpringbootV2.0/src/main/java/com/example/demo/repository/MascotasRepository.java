package com.example.demo.repository;
import com.example.demo.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotasRepository extends JpaRepository<Mascota, Integer> {
    boolean existsByNombre(String nombre);
    List<Mascota> findByIdDuenioIsNull();
    List<Mascota> findTop10ByOrderByVisitasDesc(); // Ranking
    int countByIdDuenio(int idDuenio);
}