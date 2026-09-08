package com.duoc.banco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "saldo_actual")
    private Double saldoActual;

    public Cuenta() {}

    public Cuenta(String numeroCuenta, Double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.saldoActual = saldoActual;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public Double getSaldoActual() { return saldoActual; }
    public void setSaldoActual(Double saldoActual) { this.saldoActual = saldoActual; }
}
