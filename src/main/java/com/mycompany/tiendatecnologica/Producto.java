
package com.mycompany.tiendatecnologica;

import java.util.ArrayList;

public class Producto {
    private int id;
    private int categoria_id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String caracteristicas;
    private int inventario;
    private ArrayList<String> imagenes;

    public Producto(int id, int categoria_id, String nombre, Double precio, String descripcion, String caracteristicas, int inventario,ArrayList<String> imagenes) {
        this.id = id;
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.inventario = inventario;
        this.imagenes = imagenes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", categoria_id=" + categoria_id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", caracteristicas=" + caracteristicas + ", inventario=" + inventario + ", imagenes=" + imagenes + '}';
    }

}
