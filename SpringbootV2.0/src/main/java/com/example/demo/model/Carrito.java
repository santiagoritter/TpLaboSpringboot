package com.example.demo.model;

public class Carrito {
    private int id;
    private int idUsuario;
    private int montoTotal;
    private boolean estado;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}