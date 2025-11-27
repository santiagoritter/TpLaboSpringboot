package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacuna_stock", schema = "BDD_PaginaWeb")
public class VacunaStock {
    @Id
    @Column(name = "tipo", length = 45)
    private String tipo;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stock_minimo")
    private int stockMinimo;

    @Column(name = "duracion_meses")
    private int duracionMeses;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }
    public int getDuracionMeses() { return duracionMeses; }
    public void setDuracionMeses(int duracionMeses) { this.duracionMeses = duracionMeses; }
}