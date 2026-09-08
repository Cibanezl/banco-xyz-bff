package com.duoc.banco.bff.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.banco.bff.web.dto.WebDashboardDTO;
import com.duoc.banco.service.BancoService;

@RestController
@RequestMapping("/api/v1/bff/web")
public class WebBffController {

    private final BancoService bancoService;

    public WebBffController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping("/dashboard/{numeroCuenta}")
    public WebDashboardDTO getDashboard(@PathVariable String numeroCuenta) {
        return bancoService.obtenerDashboardWeb(numeroCuenta);
    }
}
