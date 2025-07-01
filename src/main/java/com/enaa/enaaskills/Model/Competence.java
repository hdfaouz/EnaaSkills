package com.enaa.enaaskills.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nom;
    private boolean statutAcquise;

    @OneToMany(mappedBy = "competence")
    private List<SousCompetence> sousCompetences = new ArrayList<>();

    public Competence() {
    }

    public Competence(Long id, String nom, boolean statutAcquise, List<SousCompetence> sousCompetences) {
        this.id = id;
        this.nom = nom;
        this.statutAcquise = statutAcquise;
        this.sousCompetences = sousCompetences;
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
