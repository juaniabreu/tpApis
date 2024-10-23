package com.uade.cuentas;

import com.uade.cuentas.dao.CajaAhorroDAO;
import com.uade.cuentas.dao.ClienteDAO;
import com.uade.cuentas.dao.CuentaCorrienteDAO;
import com.uade.cuentas.modelo.CajaAhorro;
import com.uade.cuentas.modelo.Cliente;
import com.uade.cuentas.repository.CajaAhorroRepository;
import com.uade.cuentas.repository.ClienteRepository;
import com.uade.cuentas.repository.CuentaCorrienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Optional;

@SpringBootApplication
public class CuentasApplication implements CommandLineRunner {

    @Autowired
    private CuentaCorrienteRepository cuentaCorrienteRepository;
    @Autowired
    private CajaAhorroRepository cajaAhorroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(CuentasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*CREAR
        Cliente cliente = new Cliente("juancito","2313123123");
       ClienteDAO.getInstance().save(cliente,clienteRepository);
        */

        //LEER
       //Optional<Cliente> findCliente  = ClienteDAO.getInstance().findById(0,clienteRepository);

       /*if(findCliente.isPresent()){
           Cliente client = findCliente.get();
           System.out.println(client.toString());
           }
*/
       //ELIMINAR
       //ClienteDAO.getInstance().deleteById(1,clienteRepository);

        Optional<Cliente> findCliente = ClienteDAO.getInstance().findById(2,clienteRepository);

        if(findCliente.isPresent()) {

            Cliente cliente = findCliente.get();
            CajaAhorro caja = new CajaAhorro(cliente);
            CajaAhorroDAO.getInstance().save(caja, cajaAhorroRepository);

        }
    }

}
