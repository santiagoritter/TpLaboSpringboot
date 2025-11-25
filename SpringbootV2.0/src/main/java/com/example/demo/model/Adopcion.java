package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Adopcion")
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idUsuario;
    private int idMascota;
    private LocalDate fecha;
    private String estado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}