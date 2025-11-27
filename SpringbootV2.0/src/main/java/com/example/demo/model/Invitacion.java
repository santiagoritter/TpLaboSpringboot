package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Invitacion")
public class Invitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emailInvitado;
    private String codigo;
    private LocalDate fechaVencimiento;
    private int idInvitante;
    @Column(name = "id_invitado")
    private Integer idInvitado;
    private String estado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEmailInvitado() { return emailInvitado; }
    public void setEmailInvitado(String emailInvitado) { this.emailInvitado = emailInvitado; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public int getIdInvitante() { return idInvitante; }
    public void setIdInvitante(int idInvitante) { this.idInvitante = idInvitante; }
    public Integer getIdInvitado() { return idInvitado; }
    public void setIdInvitado(Integer idInvitado) { this.idInvitado = idInvitado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}