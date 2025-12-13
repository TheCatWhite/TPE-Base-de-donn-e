package com.gestionprojet.models;

public class StatutProjectModel {
    private int id_statut;
    private String libelle_statut;

    public StatutProjectModel(int id_statut, String libelle_statut) {
        this.id_statut = id_statut;
        this.libelle_statut = libelle_statut;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public String getLibelle_statut() {
        return libelle_statut;
    }
    public void setLibelle_statut(String libelle_statut) {
        this.libelle_statut = libelle_statut;
    }
    
}
