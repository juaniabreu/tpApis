package com.uade.cuentas;

import com.uade.cuentas.dao.ClienteDAO;
import com.uade.cuentas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CuentasApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(CuentasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
