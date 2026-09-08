package com.duoc.banco.bff.mobile.controller;

import com.duoc.banco.bff.mobile.dto.MobileSummaryDTO;
import com.duoc.banco.service.BancoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bff/mobile")
public class MobileBffController {

    private final BancoService bancoService;

    public MobileBffController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping("/summary/{numeroCuenta}")
    public MobileSummaryDTO getSummary(@PathVariable String numeroCuenta) {
        return bancoService.obtenerResumenMobile(numeroCuenta);
    }
}