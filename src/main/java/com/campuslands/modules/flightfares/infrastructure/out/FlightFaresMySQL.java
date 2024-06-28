package com.campuslands.modules.flightfares.infrastructure.out;

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
import com.campuslands.modules.flightfares.domain.models.Flightfares;
import com.campuslands.modules.flightfares.domain.repository.FlightfaresRepository;

public class FlightFaresMySQL extends MySQL implements FlightfaresRepository {

    public FlightFaresMySQL() {
        super();
    }

    @Override
    public void save(Flightfares flightFares) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flightfares (id, description, details, price) VALUES (?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, flightFares.getId());
                statement.setString(2, flightFares.getDescription());
                statement.setString(3, flightFares.getDetails());
                statement.setInt(4, flightFares.getValue());
                JOptionPane.showMessageDialog(null, "Tarifa creada exitosamente ", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Flightfares flightFares) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE flightfares SET id = ?, description = ?, details = ?, price = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, flightFares.getId());
                statement.setString(2, flightFares.getDescription());
                statement.setString(3, flightFares.getDetails());
                statement.setInt(4, flightFares.getValue());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarifa actualizada exitosamente ", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Flightfares> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, description, details, value FROM flightfares WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Flightfares flightFares = new Flightfares(
                                resultSet.getInt("id"),
                                resultSet.getString("description"),
                                resultSet.getString("details"),
                                resultSet.getInt("value"));
                        return Optional.of(flightFares);
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
            String query = "DELETE FROM flightfares WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarifa eliminada exitosamente ", "DELETE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Flightfares> findAll() {
        List<Flightfares> flightFares = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, description, details, value FROM flightfares";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Flightfares fare = new Flightfares(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            resultSet.getString("details"),
                            resultSet.getInt("value"));
                    flightFares.add(fare);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return flightFares;
    }
}
