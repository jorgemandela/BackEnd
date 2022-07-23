
package com.jomc.jomc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoConocimientos {
    @NotBlank
    private String tituloC;
    @NotBlank
    private String centroC;
    @NotBlank
    private int anios;
    
    //Contructor

    public dtoConocimientos() {
    }

    public dtoConocimientos(String tituloC, String centroC, int anios) {
        this.tituloC = tituloC;
        this.centroC = centroC;
        this.anios = anios;
    }
    
    //Getters y setters

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
