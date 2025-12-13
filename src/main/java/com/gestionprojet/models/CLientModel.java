package com.gestionprojet.models;

public class CLientModel {
    private int code_client;
    private String nom_entreprise;
    private String adresse_entreprise;
    private String secteur;
    private String contact;

    public CLientModel(int code_client, String nom_entreprise, String adresse_entreprise, String secteur,
            String contact) {
        this.code_client = code_client;
        this.nom_entreprise = nom_entreprise;
        this.adresse_entreprise = adresse_entreprise;
        this.secteur = secteur;
        this.contact = contact;
    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getAdresse_entreprise() {
        return adresse_entreprise;
    }

    public void setAdresse_entreprise(String adresse_entreprise) {
        this.adresse_entreprise = adresse_entreprise;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}