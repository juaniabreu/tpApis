package com.uade.cuentas.modelo;

import java.util.Date;

import com.uade.cuentas.views.MovimientoView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movimiento {

    private static int numerador = 0;
    @Id
    @Column(name = "nro_movimiento")
    private int nroMovimiento;
    private Date fecha;
    private String tipoMovimiento;
    private float importe;

    public Movimiento() {}
    public Movimiento(Date fecha, String tipoMovimiento, float importe) {
        this.nroMovimiento = numerador++;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
    }

    public int getNroMovimiento() {
        return this.nroMovimiento;
    }
    public boolean soyDeEseMes(int mes) {
        return this.fecha.getMonth() == mes;
    }

    public boolean soyDeposito() {
        return this.tipoMovimiento.equalsIgnoreCase("Deposito");
    }

    public float obtenerImporte() {
        return this.importe;
    }

    public MovimientoView toView() {
        return new MovimientoView(nroMovimiento,fecha, tipoMovimiento, importe);
    }

}
