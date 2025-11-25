package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Mascota", schema = "BDD_PaginaWeb")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int edad;
    @Column(name = "id_Duenio")
    private Integer idDuenio;
    private int peso;
    @Column(name = "id_Tipo")
    private int idTipo;
    private String raza;
    private int visitas;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public Integer getIdDuenio() { return idDuenio; }
    public void setIdDuenio(Integer idDuenio) { this.idDuenio = idDuenio; }
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public int getIdTipo() { return idTipo; }
    public void setIdTipo(int idTipo) { this.idTipo = idTipo; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public int getVisitas() { return visitas; }
    public void setVisitas(int visitas) { this.visitas = visitas; }
}