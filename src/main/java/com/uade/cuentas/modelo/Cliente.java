package com.uade.cuentas.modelo;

import com.uade.cuentas.exceptions.CuentaException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    private static int numerador = 0;
    @Id
    private int numero;
    private String nombre;
    private String documento;
    @ManyToMany(mappedBy = "clientes")
    private List<Cuenta> cuentas;

    public Cliente() {}
    public Cliente(String nombre, String documento) {
        this.numero = numerador++;
        this.nombre = nombre;
        this.documento = documento;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public float saldoEnCuenta(String nroCuenta) throws CuentaException {
        for(Cuenta c : cuentas)
            if(c.soyLaCuenta(nroCuenta))
                return c.obtenerSaldo();
        throw new CuentaException("No existe esa cuenta para ese cliente");
    }

    public float posicion() {
        float resultado = 0;
        for(Cuenta c : cuentas)
            resultado += c.obtenerSaldo();
        return resultado;
    }

    public List<Movimiento> movimientosMes(int mes, String nroCuenta) throws CuentaException{
        for(Cuenta c : cuentas)
            if(c.soyLaCuenta(nroCuenta)) {
                return c.movimientosDelMes(mes);
            }
        throw new CuentaException("No existe esa cuenta para ese cliente");
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean tieneDocumento(String documento) {
        return this.documento.equalsIgnoreCase(documento);
    }

    public boolean tieneNumero(int numero) {
        return this.numero == numero;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        cuenta.agregarClienteCuenta(this);
    }
}
