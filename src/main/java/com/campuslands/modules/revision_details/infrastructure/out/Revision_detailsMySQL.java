package com.campuslands.modules.revision_details.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.campuslands.core.MySQL;
import com.campuslands.modules.revision_details.domain.models.RevisionDetails;
import com.campuslands.modules.revision_details.domain.repository.RevisionDetailsRepository;

public class Revision_detailsMySQL extends MySQL implements RevisionDetailsRepository {

    public Revision_detailsMySQL() {
        super();
    }

    @Override
    public void save(RevisionDetails revisionDetails) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revision_details (id,description,id_employee) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, revisionDetails.getId());
                statement.setString(1, revisionDetails.getDescription());
                statement.setInt(2, revisionDetails.getId_employee());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Revicion creada exitosa mente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(RevisionDetails revisionDetails) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE revision_details SET description = ? id_employee = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, revisionDetails.getDescription());
                statement.setInt(2, revisionDetails.getId_employee());
                statement.setInt(3, revisionDetails.getId());
                statement.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Revicion actualizada correctamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<RevisionDetails> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,description,id_employee FROM revision_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        RevisionDetails revisionDetails = new RevisionDetails(
                                resultSet.getInt("id"),
                                resultSet.getString("description"),
                                resultSet.getInt("id_employee"));
                        return Optional.of(revisionDetails);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM revision_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Revicion eliminada correctamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<RevisionDetails> findAll() {
        List<RevisionDetails> revisionDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,description,id_employee FROM revision_details";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RevisionDetails details = new RevisionDetails(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            resultSet.getInt("id_employee"));
                    revisionDetails.add(details);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return revisionDetails;
    }
}
