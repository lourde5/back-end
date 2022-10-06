package com.portfolio.jlm.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String aniosE;
    private String descripcionE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String aniosE, String descripcionE) {
        this.nombreE = nombreE;
        this.aniosE = aniosE;
        this.descripcionE = descripcionE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
