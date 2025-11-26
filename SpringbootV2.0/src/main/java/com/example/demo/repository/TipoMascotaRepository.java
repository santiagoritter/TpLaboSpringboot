package com.example.demo.repository;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tipo_Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMascotaRepository extends JpaRepository<Tipo_Mascota, Integer>   {

}
