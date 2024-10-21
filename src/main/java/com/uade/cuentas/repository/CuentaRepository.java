package com.uade.cuentas.repository;

import com.uade.cuentas.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
