package com.holamundo.tallercarrosclase;

public class Carros {

    private int placa;
    private String color;
    private String marca;
    private int precio;
    private int foto;

    public Carros(int placa, String color, String marca, int precio, int foto) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
        this.foto = foto;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.agregar(this);
    }
}
