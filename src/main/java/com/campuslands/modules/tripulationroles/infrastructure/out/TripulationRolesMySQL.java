package com.campuslands.modules.tripulationroles.infrastructure.out;

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
import com.campuslands.modules.tripulationroles.domain.models.Tripulationroles;
import com.campuslands.modules.tripulationroles.domain.repository.TripulationRolesRepository;

public class TripulationRolesMySQL extends MySQL implements TripulationRolesRepository {

    public TripulationRolesMySQL() {
        super();
    }

    @Override
    public void save(Tripulationroles tripulationRoles) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO tripulationroles (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tripulationRoles.getName());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Agrego  el rol de la Tripulacion", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Tripulationroles tripulationRoles) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE tripulationroles SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tripulationRoles.getName());
                statement.setInt(2, tripulationRoles.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Actualizo  el rol de la Tripulacion", "INSERT", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Tripulationroles> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name FROM tripulationroles WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Tripulationroles tripulationRoles = new Tripulationroles(
                                resultSet.getInt("id"),
                                resultSet.getString("name")

                        );
                        JOptionPane.showMessageDialog(null, "Se Encontro el Id del rol de la Tripulacion", "INSERT", 0);
                        return Optional.of(tripulationRoles);
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
            String query = "DELETE FROM tripulationroles WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Elimino  el rol de la Tripulacion", "INSERT", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Tripulationroles> findAll() {
        List<Tripulationroles> trips = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name FROM trips";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tripulationroles trip = new Tripulationroles(
                            resultSet.getInt("id"),
                            resultSet.getString("trip_name"));
                    trips.add(trip);
                    JOptionPane.showMessageDialog(null, "Se Encontro todos los roles de la Tripulacion", "INSERT", 0);
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return trips;
    }
}