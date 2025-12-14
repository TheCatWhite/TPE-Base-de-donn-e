package com.gestionprojet.dao;

import java.sql.Connection;

import com.gestionprojet.models.TechnologieModel;

public class TechnologieDao {
    private static final String INSERT_TECHNOLOGIE = "INSERT INTO TECHNOLOGIE (nom_technologie,categorie) VALUES (?, ?)";
    public void InsertTechnologie(TechnologieModel technologie) {
        try(Connection connection = com.gestionprojet.config.DatabaseConnection.getConnection();
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TECHNOLOGIE, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            preparedStatement.setString(1, technologie.getNom_technologie());
            preparedStatement.setString(2, technologie.getCategorie());
            
            int affectedRows = preparedStatement.executeUpdate();
            
            if (affectedRows > 0) {
                try (java.sql.ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        technologie.setId_technologie(rs.getInt(1));
                    }
                }
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        System.err.println("Technologie insérée avec succès.");
    }   


    private static final String Delete_Technologie = "DELETE FROM TECHNOLOGIE WHERE id_technologie = ?";

    public void DeleteTechnologie(int id_technologie) {
        try (Connection connection = com.gestionprojet.config.DatabaseConnection.getConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(Delete_Technologie)) {

            preparedStatement.setInt(1, id_technologie);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Technologie supprimée avec succès.");
            } else {
                System.out.println("Aucune technologie trouvée avec l'ID spécifié.");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }


    private static final String READ_ALL_TECHNOLOGIES = "SELECT * FROM TECHNOLOGIE";

    public java.util.List<TechnologieModel> selectAll() {
        java.util.List<TechnologieModel> technologies = new java.util.ArrayList<>();
        try (Connection connection = com.gestionprojet.config.DatabaseConnection.getConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_TECHNOLOGIES);
                java.sql.ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id_technologie = rs.getInt("id_technologie");
                String nom_technologie = rs.getString("nom_technologie");
                String categorie = rs.getString("categorie");
                technologies.add(new TechnologieModel(id_technologie, nom_technologie, categorie));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return technologies;
    }

}
