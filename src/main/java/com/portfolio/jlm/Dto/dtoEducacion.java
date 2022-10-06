package com.portfolio.jlm.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String aniosE;
    @NotBlank
    private String descripcionE;  

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String aniosE, String descripcionE) {
        this.nombreE = nombreE;
        this.aniosE = aniosE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getAniosE() {
        return aniosE;
    }

    public void setAniosE(String aniosE) {
        this.aniosE = aniosE;
    }
    
    
}
