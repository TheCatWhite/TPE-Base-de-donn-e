package com.gestionprojet;
import java.sql.Connection;
import java.util.List;

import com.gestionprojet.config.DatabaseConnection;
import com.gestionprojet.dao.ClientDao;
import com.gestionprojet.dao.DeveloppeurDao;
import com.gestionprojet.dao.GradeDao;
import com.gestionprojet.dao.StatutDao;
import com.gestionprojet.models.CLientModel;
import com.gestionprojet.models.DeveloppeurModel;
import com.gestionprojet.models.GradeModel;
import com.gestionprojet.models.StatutProjectModel;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DatabaseConnection.getConnection()) {

            System.out.println(" Connexion PostgreSQL réussie");

        } catch (Exception e) {
            System.out.println(" Erreur de connexion");
            e.printStackTrace();
        }
        GradeDao gradeDao = new GradeDao();
        
        System.out.println("--- Démarrage des tests CRUD pour Grade ---");

        System.out.println("\n[1. Insertion d'un Grade]");
        GradeModel nouvgrade1 = new GradeModel(0, "Stagiaire"); 
        GradeModel gradeInsere = gradeDao.insert(nouvgrade1);

        if (gradeInsere != null) {
            System.out.println("Insertion réussie. Grade : ID=" + gradeInsere.getId_grade() + ", Nom='" + gradeInsere.getNom_grade() + "'");
        } else {
            System.out.println("Échec de l'insertion.");
            return; 
        }
        
        int idGradeTest = gradeInsere.getId_grade();

        System.out.println("\n[2. Sélection par ID]");
        GradeModel gradeRecupere = gradeDao.selectById(idGradeTest);

        if (gradeRecupere != null) {
            System.out.println("Sélection réussie. Grade : ID=" + gradeRecupere.getId_grade() + ", Nom='" + gradeRecupere.getNom_grade() + "'");
        } else {
            System.out.println("Échec de la sélection pour l'ID : " + idGradeTest);
        }
        
        System.out.println("\n[3. Mise à jour du Grade]");
        gradeRecupere.setNom_grade("CDI"); 
        boolean estMisAJour = gradeDao.update(gradeRecupere);

        if (estMisAJour) {
            System.out.println("Mise à jour réussie. Nouveau nom : " + gradeRecupere.getNom_grade());

            GradeModel gradeVerifie = gradeDao.selectById(idGradeTest);
            System.out.println("Vérification BD : Nom actuel : " + gradeVerifie.getNom_grade());
        } else {
            System.out.println("Échec de la mise à jour.");
        }

        System.out.println("\n[4. Sélection de tous les Grades]");
        List<GradeModel> tousLesGrades = gradeDao.selectAll();

        if (tousLesGrades.isEmpty()) {
            System.out.println("Aucun grade trouvé.");
        } else {
            System.out.println("Liste des Grades (Total : " + tousLesGrades.size() + ") :");
            for (GradeModel grade : tousLesGrades) {
                System.out.println(" -> ID=" + grade.getId_grade() + ", Nom='" + grade.getNom_grade() + "'");
            }
        }

        System.out.println("\n[5. Suppression du Grade de test]");
        boolean estSupprime = gradeDao.delete(idGradeTest);

        if (estSupprime) {
            System.out.println("Suppression réussie pour l'ID : " + idGradeTest);
        } else {
            System.out.println("Échec de la suppression pour l'ID : " + idGradeTest);
        }
        
        System.out.println("\n[6. Vérification après suppression]");
        GradeModel gradeApresSuppression = gradeDao.selectById(idGradeTest);
        if (gradeApresSuppression == null) {
            System.out.println("Vérification réussie : Le grade n'existe plus dans la BD.");
        } else {
            System.out.println("Erreur : Le grade existe toujours !");
        }

        System.out.println("\n--- Fin des tests CRUD ---");


        StatutDao statutDao = new StatutDao();

        System.out.println("\n[1. Insertion d'un Statut]");
        StatutProjectModel nouvstatut1 = new StatutProjectModel(0, "presque fini"); 
        StatutProjectModel statutInsere = statutDao.Insert(nouvstatut1);

        if (statutInsere != null) {
            System.out.println("Insertion réussie. Statut : ID=" + statutInsere.getId_statut() + ", Libellé='" + statutInsere.getLibelle_statut() + "'");
        } else {
            System.out.println("Échec de l'insertion.");
            return; 
        }

        int idstatutTest = statutInsere.getId_statut();







        /*Client */
        ClientDao clientDao = new ClientDao();

        System.out.println("\n[1. Insertion d'un Client]");
        CLientModel nouvclient1 = new CLientModel(0, "Entreprise Test", "Adresse Test", "Secteur Test", "Contact Test");
        CLientModel clientInsere = clientDao.insert(nouvclient1);

        if (clientInsere != null) {
            System.out.println("Insertion réussie. Client : ID=" + clientInsere.getCode_client() + ", Nom='" + clientInsere.getNom_entreprise() + "'");
        } else {
            System.out.println("Échec de l'insertion.");
            return; 
        }

        int idClientTest = clientInsere.getCode_client();


        System.out.println("\n[3. Suppression du Client de test]");
        boolean estSupprimeClient = clientDao.delete(3);
        if (estSupprimeClient) {
            System.out.println("Suppression réussie pour l'ID : " + idClientTest);
        } else {
            System.out.println("Échec de la suppression pour l'ID : " + idClientTest);
        }

        System.out.println("\n[2. Sélection de tous les Clients]");
        List<CLientModel> tousLesClients = clientDao.selectAll();
        if (tousLesClients.isEmpty()) {
            System.out.println("Aucun client trouvé.");
        } else {
            System.out.println("Liste des Clients (Total : " + tousLesClients.size() + ") :");
            for (CLientModel client : tousLesClients) {
                System.out.println(" -> ID=" + client.getCode_client() + ", Nom='" + client.getNom_entreprise() + "'");
            }
        }



        System.out.println("Ajout developpeur");

        DeveloppeurDao developpeurDao = new DeveloppeurDao();
        DeveloppeurModel nouvdeveloppeur = new DeveloppeurModel(0, "Eric", "Kindy", "tikoenao@gmail.com", "Développeur web", new java.util.Date(), 3000, 2);

        DeveloppeurModel developpeurInsere = developpeurDao.insert(nouvdeveloppeur);

        if (developpeurInsere != null) {
            System.out.println("Insertion réussie. Developpeur : ID=" + developpeurInsere.getMatricule() + ", Nom='" + developpeurInsere.getNom() + "', Prénom='" + developpeurInsere.getPrenom() + "'");
        } else {
            System.out.println("Échec de l'insertion.");
            return;
        }


        System.out.println("\n[2. Sélection de tous les Developpeurs]");
        List<DeveloppeurModel> tousLesDeveloppeurs = developpeurDao.selectAll();
        if (tousLesDeveloppeurs.isEmpty()) {
            System.out.println("Aucun développeur trouvé.");
        } else {
            System.out.println("Liste des Développeurs (Total : " + tousLesDeveloppeurs.size() + ") :");
            for (DeveloppeurModel dev : tousLesDeveloppeurs) {
                System.out.println(" -> ID=" + dev.getMatricule() + ", Nom='" + dev.getNom() + "', Prénom='"
                        + dev.getPrenom() + "'");
            }
        }

    }
}


