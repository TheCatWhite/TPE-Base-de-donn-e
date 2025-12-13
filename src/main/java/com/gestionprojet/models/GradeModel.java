package com.gestionprojet.models;

public class GradeModel {
    private int id_grade;
    private String nom_grade;

    public GradeModel(int id_grade, String nom_grade) {
        this.id_grade = id_grade;
        this.nom_grade = nom_grade;
    }

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }

    public String getNom_grade() {
        return nom_grade;
    }

    public void setNom_grade(String nom_grade) {
        this.nom_grade = nom_grade;
    }
}