package com.tecnologiajo.virtualmenu;

/**
 * Created by Admin on 23/05/2016.
 */
public class Producto {
    private int id;
    private String nombdre;
    private String marca;
    private int tipo;
    private float precio;
    private int cantida;

    public Producto(int id, String nombdre, String marca, int tipo, float precio) {
        this.id = id;
        this.nombdre = nombdre;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombdre() {
        return nombdre;
    }

    public void setNombdre(String nombdre) {
        this.nombdre = nombdre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantida() {
        return cantida;
    }

    public void setCantida(int cantida) {
        this.cantida = cantida;
    }
}
