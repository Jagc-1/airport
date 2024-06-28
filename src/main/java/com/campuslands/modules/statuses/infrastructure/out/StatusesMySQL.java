package com.campuslands.modules.statuses.infrastructure.out;

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
import com.campuslands.modules.statuses.domain.models.Statuses;
import com.campuslands.modules.statuses.domain.repository.StatusesRepository;

public class StatusesMySQL extends MySQL implements StatusesRepository {

    public StatusesMySQL() {
        super();
    }

    @Override
    public void save(Statuses statuses) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO statuses (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, statuses.getName());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Agrego Correctamente", "INSERT", 1);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Statuses statuses) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE statuses SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, statuses.getName());
                statement.setInt(2, statuses.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Actualizo  correctamente", "UPDATE", 2);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Statuses> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name FROM statuses WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Statuses statuses = new Statuses(
                                resultSet.getInt("id"),
                                resultSet.getString("name"));
                        return Optional.of(statuses);
                    }
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM statuses WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Elimino correctamente ", "DELETE", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Statuses> findAll() {
        List<Statuses> statuses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM statuses";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Statuses status = new Statuses(
                            resultSet.getInt("id"),
                            resultSet.getString("name"));
                    statuses.add(status);
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return statuses;
    }
}
