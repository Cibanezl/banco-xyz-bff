package com.duoc.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.banco.model.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByNumeroCuenta(String numeroCuenta);
    
    // Método especializado para la App Móvil (solo las últimas 5 transacciones)
    List<Transaccion> findTop5ByNumeroCuentaOrderByIdDesc(String numeroCuenta);
}
