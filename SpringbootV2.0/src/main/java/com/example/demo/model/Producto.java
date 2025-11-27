package com.example.demo.model;

public class Producto {
    private int id;
    private int precio;
    private String descripcion;
    private String nombre;
    private String categoria;
    private boolean descuento;
    private String mascota_que_lo_consume;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public String getMascota_que_lo_consume() {
        return mascota_que_lo_consume;
    }

    public void setMascota_que_lo_consume(String mascota_que_lo_consume) {
        this.mascota_que_lo_consume = mascota_que_lo_consume;
    }
}
