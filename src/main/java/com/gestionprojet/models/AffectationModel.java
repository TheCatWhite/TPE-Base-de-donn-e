package com.gestionprojet.models;

import java.sql.Time;

public class AffectationModel {
    private int matricule_Developpeur;
    private int code_projet_Projet;
    private int id_technologie_Affectation;
    private Time nombre_heure_revue;
    private String role;

    public AffectationModel(int matricule_Developpeur, int code_projet_Projet, int id_technologie_Affectation,
            Time nombre_heure_revue, String role) {
        this.matricule_Developpeur = matricule_Developpeur;
        this.code_projet_Projet = code_projet_Projet;
        this.id_technologie_Affectation = id_technologie_Affectation;
        this.nombre_heure_revue = nombre_heure_revue;
        this.role = role;
    }

    public int getMatricule_Developpeur() {
        return matricule_Developpeur;
    }

    public void setMatricule_Developpeur(int matricule_Developpeur) {
        this.matricule_Developpeur = matricule_Developpeur;
    }

    public int getCode_projet_Projet() {
        return code_projet_Projet;
    }

    public void setCode_projet_Projet(int code_projet_Projet) {
        this.code_projet_Projet = code_projet_Projet;
    }

    public int getId_technologie_Affectation() {
        return id_technologie_Affectation;
    }

    public void setId_technologie_Affectation(int id_technologie_Affectation) {
        this.id_technologie_Affectation = id_technologie_Affectation;
    }

    public Time getNombre_heure_revue() {
        return nombre_heure_revue;
    }

    public void setNombre_heure_revue(Time nombre_heure_revue) {
        this.nombre_heure_revue = nombre_heure_revue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}   