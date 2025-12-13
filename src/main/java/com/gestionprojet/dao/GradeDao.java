package com.gestionprojet.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionprojet.config.DatabaseConnection;
import com.gestionprojet.models.GradeModel;

public class GradeDao {
    private static final String INSERT_GRADE_SQL = "INSERT INTO GRADE (nom_grade) VALUES (?)";
    private static final String SELECT_GRADE_BY_ID = "SELECT id_grade, nom_grade FROM GRADE WHERE id_grade = ?";
    private static final String SELECT_ALL_GRADES = "SELECT id_grade, nom_grade FROM GRADE ORDER BY id_grade";
    private static final String DELETE_GRADE_SQL = "DELETE FROM GRADE WHERE id_grade = ?";
    private static final String UPDATE_GRADE_SQL = "UPDATE GRADE SET nom_grade = ? WHERE id_grade = ?";

    public GradeModel insert(GradeModel grade) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GRADE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, grade.getNom_grade());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        grade.setId_grade(rs.getInt(1));
                        return grade;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public GradeModel selectById(int id) {
        GradeModel grade = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_BY_ID)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String nom_grade = rs.getString("nom_grade");
                    grade = new GradeModel(id, nom_grade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    public List<GradeModel> selectAll() {
        List<GradeModel> grades = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GRADES);
             ResultSet rs = preparedStatement.executeQuery()) { 

            while (rs.next()) {
                int id_grade = rs.getInt("id_grade");
                String nom_grade = rs.getString("nom_grade");
                grades.add(new GradeModel(id_grade, nom_grade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public boolean update(GradeModel grade) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GRADE_SQL)) {

            preparedStatement.setString(1, grade.getNom_grade());
            preparedStatement.setInt(2, grade.getId_grade());

            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GRADE_SQL)) {

            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}