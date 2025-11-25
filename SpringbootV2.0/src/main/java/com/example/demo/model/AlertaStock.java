package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas_stock", schema = "BDD_PaginaWeb")
public class AlertaStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_vacuna", length = 45)
    private String tipoVacuna;

    private String mensaje;

    @Column(name = "fecha_alerta")
    private LocalDateTime fechaAlerta;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTipoVacuna() { return tipoVacuna; }
    public void setTipoVacuna(String tipoVacuna) { this.tipoVacuna = tipoVacuna; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFechaAlerta() { return fechaAlerta; }
    public void setFechaAlerta(LocalDateTime fechaAlerta) { this.fechaAlerta = fechaAlerta; }
}