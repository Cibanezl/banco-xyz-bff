package com.duoc.banco.bff.atm.controller;

import com.duoc.banco.bff.atm.dto.AtmResponseDTO;
import com.duoc.banco.service.BancoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bff/atm")
public class AtmBffController {

    private final BancoService bancoService;

    public AtmBffController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping("/saldo/{numeroCuenta}")
    public AtmResponseDTO getSaldo(@PathVariable String numeroCuenta) {
        return bancoService.obtenerSaldoAtm(numeroCuenta);
    }
}
