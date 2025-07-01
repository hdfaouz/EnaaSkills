package com.enaa.enaaskills.Dto;

public class CompetenceDto {

    private String nom;
    private boolean statutAcquise;

    public CompetenceDto() {
    }

    public CompetenceDto(String nom, boolean statutAcquise) {
        this.nom = nom;
        this.statutAcquise = statutAcquise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isStatutAcquise() {
        return statutAcquise;
    }

    public void setStatutAcquise(boolean statutAcquise) {
        this.statutAcquise = statutAcquise;
    }
}
