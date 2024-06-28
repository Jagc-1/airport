package com.campuslands.modules.flightconnections.infrastructure.out;

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
import com.campuslands.modules.flightconnections.domain.models.FlightConnection;
import com.campuslands.modules.flightconnections.domain.repository.FlightConnectionsRepository;

public class FlightConnectionsMySqlRespository extends MySQL implements FlightConnectionsRepository {

    public FlightConnectionsMySqlRespository() {
        super();
    }

    @Override
    public void save(FlightConnection flightConnections) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flight_connections (id, connection_number, id_trip, id_plane, type_fright, last_scale) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, flightConnections.getId());
                statement.setString(2, flightConnections.getConnection_number());
                statement.setInt(3, flightConnections.getId_trip());
                statement.setInt(4, flightConnections.getId_plane());
                statement.setString(5, flightConnections.getType_flight());
                statement.setString(6, flightConnections.getLast_Scale());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Conexion creada  exitosamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(FlightConnection flightConnections) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE flight_connections SET id = ?, connection_number = ?, id_trip = ?, id_plane = ?, type_fright = ?, last_scale = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, flightConnections.getId());
                statement.setString(2, flightConnections.getConnection_number());
                statement.setInt(3, flightConnections.getId_trip());
                statement.setInt(4, flightConnections.getId_plane());
                statement.setString(5, flightConnections.getType_flight());
                statement.setString(6, flightConnections.getLast_Scale());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<FlightConnection> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, connection_number, id_trip, id_plane, id_airport, type_flight, last_scale FROM flight_connections WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FlightConnection flightConnections = new FlightConnection(
                                resultSet.getInt("id"),
                                resultSet.getString("connection_number"),
                                resultSet.getInt("id_trip"),
                                resultSet.getInt("id_plane"),
                                resultSet.getString("id_airport"),
                                resultSet.getString("type_flight"),
                                resultSet.getString("last_scale"));
                        return Optional.of(flightConnections);
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
            String query = "DELETE FROM flight_connections WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Conexion borrada exitosamente", "DELTE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<FlightConnection> findAll() {
        List<FlightConnection> flightConnections = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, connection_number, id_trip, id_plane, type_fright, last_sacaleFROM flight_connections";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    FlightConnection flightConnection = new FlightConnection(
                            resultSet.getInt("id"),
                            resultSet.getString("connection_number"),
                            resultSet.getInt("id_trip"),
                            resultSet.getInt("id_plane"),
                            resultSet.getString("id_airport"),
                            resultSet.getString("type_flight"),
                            resultSet.getString("last_scale"));
                    flightConnections.add(flightConnection);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return flightConnections;
    }
}
