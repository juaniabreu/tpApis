package com.uade.cuentas.dao;

import com.uade.cuentas.modelo.CajaAhorro;
import com.uade.cuentas.modelo.CuentaCorriente;
import com.uade.cuentas.repository.CajaAhorroRepository;
import com.uade.cuentas.repository.CuentaCorrienteRepository;

import java.util.List;
import java.util.Optional;

public class CajaAhorroDAO {
    private static CajaAhorroDAO instance;

    private CajaAhorroDAO (){

    }
    public static CajaAhorroDAO getInstance() {
        if(instance == null){
            instance = new CajaAhorroDAO();
        }
        return instance;
    }


    public List<CajaAhorro> findAll(CajaAhorroRepository cajaAhorroRepository){
        return  cajaAhorroRepository.findAll();
    }
    public Optional<CajaAhorro> findById(int id, CajaAhorroRepository cajaAhorroRepository){
        return cajaAhorroRepository.findById(id);
    }
    public CajaAhorro save(CajaAhorro cajaAhorro, CajaAhorroRepository cajaAhorroRepository){
        return cajaAhorroRepository.save(cajaAhorro);
    }
    public String deleteById(int id,CajaAhorroRepository cajaAhorroRepository){
        cajaAhorroRepository.deleteById(id);
        return "Caja de ahorro eliminada";
    }

}
