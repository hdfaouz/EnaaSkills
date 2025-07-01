package com.enaa.enaaskills.Dto;



public class SousCompetenceDto {

    private String nom;
    private boolean statutValidation;
    private Long competenceId;



    public SousCompetenceDto() {
    }

    public SousCompetenceDto(String nom, boolean statutValidation, Long competenceId) {
        this.nom = nom;
        this.statutValidation = statutValidation;
        this.competenceId = competenceId;
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

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
}
