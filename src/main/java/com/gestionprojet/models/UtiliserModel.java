package com.gestionprojet.models;

public class UtiliserModel {
    private int code_projet_Projet;
    private int id_technologie;

    public UtiliserModel(int code_projet_Projet, int id_technologie) {
        this.code_projet_Projet = code_projet_Projet;
        this.id_technologie = id_technologie;
    }

    public int getCode_projet_Projet() {
        return code_projet_Projet;
    }

    public void setCode_projet_Projet(int code_projet_Projet) {
        this.code_projet_Projet = code_projet_Projet;
    }

    public int getId_technologie() {
        return id_technologie;
    }
    public void setId_technologie(int id_technologie) {
        this.id_technologie = id_technologie;
    }

}
