package com.campuslands.modules.airports.infrastructure.out;

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
import com.campuslands.modules.airports.domain.models.Airport;
import com.campuslands.modules.airports.domain.repository.AirportsRepository;

/**
 * AirportsMySQL
 */
public class AirportsMySQL extends MySQL implements AirportsRepository {

    public AirportsMySQL() {
        super();
    }

    @Override
    public void save(Airport airports) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO airports (id, name, idcity) VALUES (?,?,?);";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, airports.getId());
                statement.setString(2, airports.getName());
                statement.setInt(3, airports.getIdCity());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Aeropuerto creado correctamente", "INSERT", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public void update(Airport airports) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE airports SET name = ?, idcity = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airports.getName());
                statement.setInt(2, airports.getIdCity());
                statement.setInt(3, airports.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Aeropuerto Actualizado correctamente", "INSERT", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public Optional<Airport> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, idcity FROM airports WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Airport airport = new Airport(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("idcity"));
                        return Optional.of(airport);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM airports WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Aeropuerto Borrado correctamente", "INSERT", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, idcity FROM airports";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Airport airport = new Airport(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("idcity"));
                    airports.add(airport);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
        return airports;
    }

}