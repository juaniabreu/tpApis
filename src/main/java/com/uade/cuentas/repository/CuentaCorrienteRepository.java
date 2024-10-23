package com.uade.cuentas.repository;

import com.uade.cuentas.modelo.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Integer> {
}
