package com.duoc.banco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.banco.bff.atm.dto.AtmResponseDTO;
import com.duoc.banco.bff.mobile.dto.MobileSummaryDTO;
import com.duoc.banco.bff.web.dto.WebDashboardDTO;
import com.duoc.banco.exception.CuentaNotFoundException;
import com.duoc.banco.model.Cuenta;
import com.duoc.banco.model.Transaccion;
import com.duoc.banco.repository.CuentaRepository;
import com.duoc.banco.repository.TransaccionRepository;

@Service
public class BancoService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public BancoService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public WebDashboardDTO obtenerDashboardWeb(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new CuentaNotFoundException("La cuenta " + numeroCuenta + " no existe"));
        List<Transaccion> historial = transaccionRepository.findByNumeroCuenta(numeroCuenta);
        return new WebDashboardDTO(cuenta.getNumeroCuenta(), cuenta.getSaldoActual(), historial);
    }

    public MobileSummaryDTO obtenerResumenMobile(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new CuentaNotFoundException("La cuenta " + numeroCuenta + " no existe"));
        List<Transaccion> ultimas5 = transaccionRepository.findTop5ByNumeroCuentaOrderByIdDesc(numeroCuenta);
        return new MobileSummaryDTO(cuenta.getNumeroCuenta(), cuenta.getSaldoActual(), ultimas5);
    }

    public AtmResponseDTO obtenerSaldoAtm(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new CuentaNotFoundException("La cuenta " + numeroCuenta + " no existe"));
        return new AtmResponseDTO(cuenta.getNumeroCuenta(), cuenta.getSaldoActual(), "CONSULTA_EXITOSA");
    }
}