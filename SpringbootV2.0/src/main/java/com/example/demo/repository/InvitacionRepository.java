package com.example.demo.repository;
import com.example.demo.model.Invitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InvitacionRepository extends JpaRepository<Invitacion, Integer> {
    Optional<Invitacion> findByEmailInvitadoAndEstado(String email, String estado);
}