package com.uade.cuentas.dao;

import com.uade.cuentas.modelo.CuentaCorriente;
import com.uade.cuentas.repository.CuentaCorrienteRepository;

import java.util.List;
import java.util.Optional;

public class CuentaCorrienteDAO {
    private static CuentaCorrienteDAO instance;

    private CuentaCorrienteDAO(){

    }
    public CuentaCorrienteDAO getInstance(){
        if(instance == null){
            instance = new CuentaCorrienteDAO();
        }
        return instance;
    }

    public List<CuentaCorriente> findAll(CuentaCorrienteRepository cuentaCorrienteRepository){
        return  cuentaCorrienteRepository.findAll();
    }
    public Optional<CuentaCorriente> findById(int id, CuentaCorrienteRepository cuentaCorrienteRepository){
        return cuentaCorrienteRepository.findById(id);
    }
    public CuentaCorriente save(CuentaCorriente cuentaCorriente, CuentaCorrienteRepository cuentaCorrienteRepository){
        return cuentaCorrienteRepository.save(cuentaCorriente);
    }
    public String deleteById(int id,CuentaCorrienteRepository cuentaCorrienteRepository){
         cuentaCorrienteRepository.deleteById(id);
         return "Cuenta corriente eliminada";
    }

}
