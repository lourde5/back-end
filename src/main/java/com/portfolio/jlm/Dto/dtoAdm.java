package com.portfolio.jlm.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAdm {
    @NotBlank
    private String nombreE; 

    public dtoAdm() {
    }

    public dtoAdm(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    
}


