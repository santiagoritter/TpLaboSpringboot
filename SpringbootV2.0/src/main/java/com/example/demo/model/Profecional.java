package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Profecional", schema = "BDD_PaginaWeb")
public class Profecional {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anios_experencia")
    private int aniosExperencia;


    public Profecional() {
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAniosExperencia() { return aniosExperencia; }
    public void setAniosExperencia(int aniosExperencia) { this.aniosExperencia = aniosExperencia; }
}