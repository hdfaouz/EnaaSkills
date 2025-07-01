package com.enaa.enaaskills.Dto;

public class SousCompetenceDto {
    private String nom;
    private boolean statutValidation;

    public SousCompetenceDto() {
    }

    public SousCompetenceDto(String nom, boolean statutValidation) {
        this.nom = nom;
        this.statutValidation = statutValidation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(boolean statutValidation) {
        this.statutValidation = statutValidation;
    }
}
