package com.uade.cuentas.modelo;

import com.uade.cuentas.exceptions.CuentaException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_cuenta")
    protected String nroCuenta;
    protected float saldo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_cuenta",
               joinColumns = @JoinColumn(name = "cuenta_nroCuenta"),
                inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    protected List<Cliente> clientes;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "nro_movimiento")
    protected List<Movimiento> movimientos;

    public Cuenta() {}

    public Cuenta(Cliente cliente) {
        this.nroCuenta = null;
        this.saldo = 0;
        this.clientes = new ArrayList<Cliente>();
        this.clientes.add(cliente);
        this.movimientos = new ArrayList<Movimiento>();
    }

    public void agregarClienteCuenta(Cliente cliente){
        this.clientes.add(cliente);
    }

    public int depositar(float importe) {
        if(importe > 0) {
            this.saldo += importe;
            Movimiento movimiento = new Movimiento(Calendar.getInstance().getTime(), "Deposito", importe);
            movimientos.add(movimiento);
            return movimiento.getNroMovimiento();
        }
        return 0;
    }

    public float obtenerSaldo() {
        return this.saldo;
    }

    public abstract int extraer(float importe) throws CuentaException;

    public abstract float disponible();

    public List<Movimiento> verDepositosEntreFechas(Date fechaDesde, Date fechaHasta){
        List<Movimiento> resultado = new ArrayList<Movimiento>();
        for(Movimiento m : movimientos)
            if(m.soyDeposito())
                resultado.add(m);
        return resultado;
    }

    public List<Movimiento> verExtraccionesEntreFechas(Date fechaDesde, Date fechaHasta){
        List<Movimiento> resultado = new ArrayList<Movimiento>();
        for(Movimiento m : movimientos)
            if(!m.soyDeposito())
                resultado.add(m);
        return resultado;
    }

    public boolean soyLaCuenta(String nroCuenta) {
        return this.nroCuenta.equalsIgnoreCase(nroCuenta);
    }

    public List<Movimiento> movimientosDelMes(int mes) {
        List<Movimiento> resultado = new ArrayList<Movimiento>();
        for(Movimiento m : movimientos)
            if(m.soyDeEseMes(mes))
                resultado.add(m);
        return resultado;
    }

    public boolean tieneNumero(String nroCuenta) {
        return this.nroCuenta.equalsIgnoreCase(nroCuenta);
    }
}
