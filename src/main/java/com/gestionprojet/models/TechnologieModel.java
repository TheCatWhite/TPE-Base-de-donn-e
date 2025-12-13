package com.gestionprojet.models;

public class TechnologieModel {
    private int id_technologie;
    private String nom_technologie;
    private String categorie;

    public TechnologieModel(int id_technologie, String nom_technologie, String categorie) {
        this.id_technologie = id_technologie;
        this.nom_technologie = nom_technologie;
        this.categorie = categorie;
    }

    public int getId_technologie() {
        return id_technologie;
    }

    public void setId_technologie(int id_technologie) {
        this.id_technologie = id_technologie;
    }


    public String getNom_technologie() {
        return nom_technologie;
    }

    public void setNom_technologie(String nom_technologie) {
        this.nom_technologie = nom_technologie;
    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
