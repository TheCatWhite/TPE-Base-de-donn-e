package com.gestionprojet.models;

import java.util.Date;

public class LogicielModel {
    private int code_logiciel;
    private String nom_logiciel;
    private String version_logiciel;
    private String type_logiciel;
    private Date date_livraison;
    private String description;
    private int code_projet;

    public LogicielModel(int code_logiciel, String nom_logiciel, String version_logiciel, String type_logiciel,
            Date date_livraison, String description, int code_projet) {
        this.code_logiciel = code_logiciel;
        this.nom_logiciel = nom_logiciel;
        this.version_logiciel = version_logiciel;
        this.type_logiciel = type_logiciel;
        this.date_livraison = date_livraison;
        this.description = description;
        this.code_projet = code_projet;
    }

    public int getCode_logiciel() {
        return code_logiciel;
    }

    public void setCode_logiciel(int code_logiciel) {
        this.code_logiciel = code_logiciel;
    }

    public String getNom_logiciel() {
        return nom_logiciel;
    }

    public void setNom_logiciel(String nom_logiciel) {
        this.nom_logiciel = nom_logiciel;
    }

    public String getVersion_logiciel() {
        return version_logiciel;
    }

    public void setVersion_logiciel(String version_logiciel) {
        this.version_logiciel = version_logiciel;
    }

    public String getType_logiciel() {
        return type_logiciel;
    }

    public void setType_logiciel(String type_logiciel) {
        this.type_logiciel = type_logiciel;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode_projet() {
        return code_projet;
    }

    public void setCode_projet(int code_projet) {
        this.code_projet = code_projet;
    }

}
