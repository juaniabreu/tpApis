package com.uade.cuentas;

import com.uade.cuentas.dao.ClienteDAO;
import com.uade.cuentas.modelo.Cliente;
import com.uade.cuentas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Optional;

@SpringBootApplication
public class CuentasApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(CuentasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Cliente cliente = new Cliente("juani","43818902");
       // ClienteDAO.getInstance().save(cliente,clienteRepository);

       Optional<Cliente> findCliente  = ClienteDAO.getInstance().findById(Long.valueOf(0),clienteRepository);
       if(findCliente.isPresent()){
           System.out.println(findCliente.toString());
       }

    }

}
