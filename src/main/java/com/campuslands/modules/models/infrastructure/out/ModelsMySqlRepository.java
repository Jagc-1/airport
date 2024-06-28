package com.campuslands.modules.models.infrastructure.out;

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
import com.campuslands.modules.models.domain.models.Models;
import com.campuslands.modules.models.domain.repository.ModelsRepository;

public class ModelsMySqlRepository extends MySQL implements ModelsRepository {

    public ModelsMySqlRepository() {
        super();
    }

    @Override
    public void save(Models models) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO models (name,manufacturerid) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, models.getName());
                statement.setInt(1, models.getManuFactureId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Modelos agregados correctamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Models models) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE models SET name = ? manufacturerid = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, models.getName());
                statement.setInt(2, models.getManuFactureId());
                statement.setInt(3, models.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
    }

    @Override
    public Optional<Models> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name,manufacturerid FROM models WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Models models = new Models(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("manuFactureId"));
                        return Optional.of(models);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM models WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
    }

    @Override
    public List<Models> findAll() {
        List<Models> models = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name,manufacturerid FROM models";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Models model = new Models(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("manuFactureId"));
                    models.add(model);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
        return models;
    }
}
