package com.example.demo.repository;
import com.example.demo.model.Adopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Integer> {
    boolean existsByIdUsuarioAndEstado(int idUsuario, String estado);
}