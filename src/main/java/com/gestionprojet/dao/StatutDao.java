package com.gestionprojet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionprojet.config.DatabaseConnection;
import com.gestionprojet.models.StatutProjectModel;

public class StatutDao {
    private static final String INSERER_STATUT = "INSERT INTO STATUT_PROJET (libelle_statut) VALUES (?)";
    private static final String SELECTIONNER_STATUT_PAR_ID = "SELECT id_statut, libelle_statut FROM STATUT_PROJET WHERE id_statut = ?";
    private static final String SELECTIONNER_TOUS_LES_STATUTS = "SELECT id_statut, libelle_statut FROM STATUT_PROJET ORDER BY id_statut";
    private static final String METTRE_A_JOUR_STATUT = "UPDATE STATUT_PROJET SET libelle_statut = ? WHERE id_statut = ?";
    private static final String SUPPRIMER_STATUT = "DELETE FROM STATUT_PROJET WHERE id_statut = ?";

    public StatutProjectModel Insert(StatutProjectModel statut) {
            try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERER_STATUT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, statut.getLibelle_statut());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        statut.setId_statut(rs.getInt(1));
                        return statut;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    

    public StatutProjectModel selectById(int id) {
        StatutProjectModel statut = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECTIONNER_STATUT_PAR_ID)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String libelle = rs.getString("libelle_statut");
                    // Assurez-vous que votre StatutProjectModel a un constructeur approprié
                    statut = new StatutProjectModel(id, libelle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statut;
    }


    public List<StatutProjectModel> selectAll() {
        List<StatutProjectModel> statuts = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECTIONNER_TOUS_LES_STATUTS);
             ResultSet rs = preparedStatement.executeQuery()) { 

            while (rs.next()) {
                int id = rs.getInt("id_statut");
                String libelle = rs.getString("libelle_statut");
                statuts.add(new StatutProjectModel(id, libelle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuts;
    }


    public boolean update(StatutProjectModel statut) {
        boolean estMisAJour = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(METTRE_A_JOUR_STATUT)) {

            preparedStatement.setString(1, statut.getLibelle_statut());
            preparedStatement.setInt(2, statut.getId_statut());

            estMisAJour = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estMisAJour;
    }


    public boolean delete(int id) {
        boolean estSupprime = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUPPRIMER_STATUT)) {

            preparedStatement.setInt(1, id);
            estSupprime = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estSupprime;
    }
}