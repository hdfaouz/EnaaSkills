package com.enaa.enaaskills.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean statutAcquise;

    @OneToMany(mappedBy = "competence")
    private List<SousCompetence> sousCompetences = new ArrayList<>();

     public boolean SimpleIsAcquired(){
        if(sousCompetences  == null || sousCompetences .isEmpty()){
            return false;
        }
        for (SousCompetence  sc: sousCompetences ){
            if (!sc.isStatutValidation()){
                return false;
            }
        }
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<SousCompetence> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetence> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}
