package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_Mascota", schema = "BDD_PaginaWeb")
public class Tipo_Mascota {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_tipo")
    private String nombre_tipo;


    public Tipo_Mascota() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre_tipo() { return nombre_tipo; }
    public void setNombre_tipo(String nombre_tipo) { this.nombre_tipo = nombre_tipo; }
}