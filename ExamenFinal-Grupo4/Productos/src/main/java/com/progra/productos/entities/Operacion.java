package com.progra.productos.entities;

public class Operacion {
    int id;
    String operacion;
    int cantidad;

    public Operacion() {
    }

    public Operacion(int id, String operacion, int cantidad) {
        this.id = id;
        this.operacion = operacion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Operacion{" + "id=" + id + "operacion=" + operacion + ", cantidad=" + cantidad + '}';
    }

}



