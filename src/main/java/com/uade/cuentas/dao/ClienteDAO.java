package com.uade.cuentas.dao;

import com.uade.cuentas.modelo.Cliente;
import com.uade.cuentas.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    private static ClienteDAO instance;

    private ClienteDAO(){

    }
    public static ClienteDAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }

    public Cliente save(Cliente cliente, ClienteRepository clienteRepository) {
        return clienteRepository.save(cliente);
    }
    public void deleteById(int id, ClienteRepository clienteRepository) {
        clienteRepository.deleteById(id);
    }
    public Optional<Cliente> findById(int id, ClienteRepository clienteRepository) {
        return clienteRepository.findById(id);
    }
    public List<Cliente> findAll(ClienteRepository clienteRepository) {
        return clienteRepository.findAll();
    }



}
