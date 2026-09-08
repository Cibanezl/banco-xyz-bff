package com.duoc.banco.bff.mobile.dto;

import java.util.List;

import com.duoc.banco.model.Transaccion;

public class MobileSummaryDTO {
    private String numeroCuenta;
    private Double saldoDisponible;
    private List<Transaccion> ultimas5Transacciones;

    public MobileSummaryDTO(String numeroCuenta, Double saldoDisponible, List<Transaccion> ultimas5Transacciones) {
        this.numeroCuenta = numeroCuenta;
        this.saldoDisponible = saldoDisponible;
        this.ultimas5Transacciones = ultimas5Transacciones;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public Double getSaldoDisponible() { return saldoDisponible; }
    public List<Transaccion> getUltimas5Transacciones() { return ultimas5Transacciones; }
}