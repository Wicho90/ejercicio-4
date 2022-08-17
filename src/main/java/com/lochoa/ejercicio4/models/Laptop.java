package com.lochoa.ejercicio4.models;

import javax.persistence.*;

@Entity
@Table(name = "laptos")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private Double precio;
    private Boolean disponible;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, Double precio, Boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
