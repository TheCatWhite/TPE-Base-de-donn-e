package com.gestionprojet.models;

import java.util.Date;

public class ProjetModel {
    private int code_projet;
    private String nom_projet;
    private Date date_debut;
    private Date date_fin;
    private double budget;
    private int id_statut;
    private int code_client;
    private int matricule;


    public ProjetModel(int code_projet, String nom_projet, Date date_debut, Date date_fin, double budget, int id_statut,
            int code_client, int matricule) {
        this.code_projet = code_projet;
        this.nom_projet = nom_projet;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.budget = budget;
        this.id_statut = id_statut;
        this.code_client = code_client;
        this.matricule = matricule;
    }

    public int getCode_projet() {
        return code_projet;
    }
    public void setCode_projet(int code_projet) {
        this.code_projet = code_projet;
    }

    public String getNom_projet() {
        return nom_projet;
    }

    public void setNom_projet(String nom_projet) {
        this.nom_projet = nom_projet;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
    
}
