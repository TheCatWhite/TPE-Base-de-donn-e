package com.gestionprojet.models;

import java.util.Date;

public class DeveloppeurModel {
    private int matricule;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private Date date_embauche;
    private double salaire;
    private int id_grade;

    public DeveloppeurModel(int matricule, String nom, String prenom, String email, String specialite,
            Date date_embauche, double salaire, int id_grade) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.date_embauche = date_embauche;
        this.salaire = salaire;
        this.id_grade = id_grade;
    }
    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public double getSalaire() {
        return salaire;
    }

    public int getId_grade() {
        return id_grade;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }
    
}