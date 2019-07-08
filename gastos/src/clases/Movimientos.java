/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Michele
 */
public class Movimientos {
    private String tipo;
    private float cantidad;
    private String descrpicion;
    private String categoria;
    private String mes;
   private float real;

    public Movimientos(String tipo, float cantidad, String descrpicion, String categoria, String mes, float real) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descrpicion = descrpicion;
        this.categoria = categoria;
        this.mes = mes;
        this.real = real;
    }


    public Movimientos(String tipo, float cantidad, String categoria, String mes) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.mes = mes;
    }

    public Movimientos(String tipo, float cantidad, String descrpicion, String categoria, String mes) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descrpicion = descrpicion;
        this.categoria = categoria;
        this.mes = mes;

    }

    public Movimientos(float real) {
        this.real = real;
    }

    public float getReal() {
        return real;
    }

    public void setReal(float real) {
        this.real = real;
    }
    

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescrpicion() {
        return descrpicion;
    }

    public void setDescrpicion(String descrpicion) {
        this.descrpicion = descrpicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }            
}

