package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario", schema = "BDD_PaginaWeb")
public class Usuario {

    @Id

    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "mail")
    private String mail;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "edad")
    private int edad;


    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String mail, String contrasenia, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.edad = edad;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}