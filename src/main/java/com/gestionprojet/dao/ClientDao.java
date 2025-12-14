package com.gestionprojet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionprojet.config.DatabaseConnection;
import com.gestionprojet.models.CLientModel;

public class ClientDao {
    private static final String Insert_Client = "INSERT INTO CLIENT (nom_entreprise, adresse_entreprise, secteur, contact_entreprise) VALUES (?, ?, ?, ?)";

    public CLientModel insert(CLientModel client) {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Insert_Client,
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, client.getNom_entreprise());
            preparedStatement.setString(2, client.getAdresse_entreprise());
            preparedStatement.setString(3, client.getSecteur());
            preparedStatement.setString(4, client.getContact());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        client.setCode_client(rs.getInt(1));
                        return client;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    private static final String read_all_client = "SELECT * FROM CLIENT";

    public List<CLientModel> selectAll() {
        List<CLientModel> clients = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(read_all_client);
                ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int code_client = rs.getInt("code_client");
                String nom_entreprise = rs.getString("nom_entreprise");
                String adresse_entreprise = rs.getString("adresse_entreprise");
                String secteur = rs.getString("secteur");
                String contact = rs.getString("contact_entreprise");
                clients.add(new CLientModel(code_client, nom_entreprise, adresse_entreprise, secteur, contact));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    

    private static final String Delete_Client = "DELETE FROM CLIENT WHERE code_client = ?";

    public boolean delete(int code_client) {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Delete_Client)) {

            preparedStatement.setInt(1, code_client);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return true;
    }   
}
