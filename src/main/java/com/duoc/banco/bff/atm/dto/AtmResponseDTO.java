package com.duoc.banco.bff.atm.dto;

public class AtmResponseDTO {
    private String numeroCuenta;
    private Double saldoRestante;
    private String estadoOperacion;

    public AtmResponseDTO(String numeroCuenta, Double saldoRestante, String estadoOperacion) {
        this.numeroCuenta = numeroCuenta;
        this.saldoRestante = saldoRestante;
        this.estadoOperacion = estadoOperacion;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public Double getSaldoRestante() { return saldoRestante; }
    public String getEstadoOperacion() { return estadoOperacion; }
}
