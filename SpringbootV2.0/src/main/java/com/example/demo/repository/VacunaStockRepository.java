package com.example.demo.repository;
import com.example.demo.model.VacunaStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaStockRepository extends JpaRepository<VacunaStock, String> {}