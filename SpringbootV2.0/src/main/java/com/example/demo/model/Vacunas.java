package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Vacunas", schema = "BDD_PaginaWeb")
public class Vacunas {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", length = 45) // Ajustado a tu BDD
    private String tipo;

    @Column(name = "vencimiento")
    private LocalDate vencimiento;

    @Column(name = "id_Mascota")
    private int idMascota;


    public Vacunas() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getVencimiento() { return vencimiento; }
    public void setVencimiento(LocalDate vencimiento) { this.vencimiento = vencimiento; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
}