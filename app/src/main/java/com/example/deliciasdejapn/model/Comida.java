package com.example.deliciasdejapn.model;

public class Comida {
    private int id_comida;
    private String nombre;
    private String precio;
    private String cantidad;
    private String descrpicion;
    private int estado;

    public Comida(){
        this.id_comida=0;
        this.nombre="";
        this.precio="";
        this.cantidad="";
        this.descrpicion="";
        this.estado=0;
    }

    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescrpicion() {
        return descrpicion;
    }

    public void setDescrpicion(String descrpicion) {
        this.descrpicion = descrpicion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "id_comida=" + id_comida +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", descrpicion='" + descrpicion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
