package com.gestionprojet.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gestionprojet.config.DatabaseConnection;
import com.gestionprojet.models.DeveloppeurModel;

public class DeveloppeurDao {
    private static final String INSERT_DEVELOPPEUR = "INSERT INTO DEVELOPPEUR (nom , prenom, email, specialite, date_embauche, salaire, id_grade) VALUES (?, ?, ?, ?, ?, ?, ?) ";

    public DeveloppeurModel insert(DeveloppeurModel developpeur) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEVELOPPEUR, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, developpeur.getNom());
            preparedStatement.setString(2, developpeur.getPrenom());
            preparedStatement.setString(3, developpeur.getEmail());
            preparedStatement.setString(4, developpeur.getSpecialite());
            preparedStatement.setDate(5, new java.sql.Date(developpeur.getDate_embauche().getTime()));
            preparedStatement.setDouble(6, developpeur.getSalaire());
            preparedStatement.setInt(7, developpeur.getId_grade());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        developpeur.setMatricule(rs.getInt(1));
                        return developpeur;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    
    private static final String READ_ALL_DEVELOPPEURS = "SELECT * FROM DEVELOPPEUR";

    public List<DeveloppeurModel> selectAll() {
        List<DeveloppeurModel> developpeurs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_DEVELOPPEURS);
                ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int matricule = rs.getInt("matricule");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String specialite = rs.getString("specialite");
                Date date_embauche = rs.getDate("date_embauche");
                double salaire = rs.getDouble("salaire");
                int id_grade = rs.getInt("id_grade");

                developpeurs.add(new DeveloppeurModel(matricule, nom, prenom, email, specialite, date_embauche, salaire,id_grade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developpeurs;
    }

    private static final String DELETE_DEVELOPPEUR = "DELETE FROM DEVELOPPEUR WHERE matricule = ?";
    public boolean delete(int matricule) {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEVELOPPEUR)) {

            preparedStatement.setInt(1, matricule);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true; 
    }
}
