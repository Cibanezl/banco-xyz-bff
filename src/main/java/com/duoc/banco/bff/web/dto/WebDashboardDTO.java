package com.duoc.banco.bff.web.dto;

import java.util.List;

import com.duoc.banco.model.Transaccion;

public class WebDashboardDTO {
    private String numeroCuenta;
    private Double saldoActual;
    private List<Transaccion> historialTransacciones;

    public WebDashboardDTO(String numeroCuenta, Double saldoActual, List<Transaccion> historialTransacciones) {
        this.numeroCuenta = numeroCuenta;
        this.saldoActual = saldoActual;
        this.historialTransacciones = historialTransacciones;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public Double getSaldoActual() { return saldoActual; }
    public List<Transaccion> getHistorialTransacciones() { return historialTransacciones; }
}