
package com.jomc.jomc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conocimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloC;
    private String centroC;
    private int anios;
    
    //Constructores

    public Conocimientos() {
    }

    public Conocimientos(String tituloC, String centroC, int anios) {
        this.tituloC = tituloC;
        this.centroC = centroC;
        this.anios = anios;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloC() {
        return tituloC;
    }

    public void setTituloC(String tituloC) {
        this.tituloC = tituloC;
    }

    public String getCentroC() {
        return centroC;
    }

    public void setCentroC(String centroC) {
        this.centroC = centroC;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }
    
    
    
    
}
