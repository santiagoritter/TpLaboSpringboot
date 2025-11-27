package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Turno", schema = "BDD_PaginaWeb")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_Usuario")
    private int idUsuario;

    @Column(name = "id_Mascota")
    private int idMascota;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "id_Profecional")
    private int idProfecional;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_Vacunas")
    private Integer idVacunas; // Puede ser null


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public int getIdProfecional() { return idProfecional; }
    public void setIdProfecional(int idProfecional) { this.idProfecional = idProfecional; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getIdVacunas() { return idVacunas; }
    public void setIdVacunas(Integer idVacunas) { this.idVacunas = idVacunas; }
}