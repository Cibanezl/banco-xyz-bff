CREATE DATABASE IF NOT EXISTS banco_xyz;
USE banco_xyz;

CREATE TABLE IF NOT EXISTS cuentas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE,
    saldo_actual DOUBLE,
    saldo_original DOUBLE,
    saldo_final DOUBLE,
    interes_generado DOUBLE
);

CREATE TABLE IF NOT EXISTS transacciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(255) NOT NULL,
    monto DOUBLE,
    tipo VARCHAR(255),
    fecha VARCHAR(255)
);

INSERT INTO cuentas (numero_cuenta, saldo_actual, saldo_original, saldo_final, interes_generado) 
VALUES ('123456', 500000.0, 500000.0, 500000.0, 0.0);

INSERT INTO transacciones (numero_cuenta, monto, tipo, fecha) 
VALUES ('123456', 15000.0, 'DEBITO', '2026-09-06');