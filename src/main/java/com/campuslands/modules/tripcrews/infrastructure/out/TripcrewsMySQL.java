package com.campuslands.modules.tripcrews.infrastructure.out;

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
import com.campuslands.modules.tripcrews.domain.models.Tripcrews;
import com.campuslands.modules.tripcrews.domain.repository.TripcrewsRepository;

public class TripcrewsMySQL extends MySQL implements TripcrewsRepository {
    public TripcrewsMySQL() {
        super();
    }

    @Override
    public void save(Tripcrews tripcrews) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO tripcrews (idemployees, idconection) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripcrews.getIdemployees());
                statement.setInt(2, tripcrews.getIdconection());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Agrego Tripulacion", "INSERT", 1);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Tripcrews tripcrews) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE tripcrews SET idemployees = ?, idconection = ? WHERE idemployees = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripcrews.getIdemployees());
                statement.setInt(2, tripcrews.getIdconection());
                statement.setInt(3, tripcrews.getIdemployees());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Actualizo Tripulacion", "INSERT", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Tripcrews> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT idemployees, idconection FROM tripcrews WHERE idemployees = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Tripcrews tripBookingDetails = new Tripcrews(
                                resultSet.getInt("idemployees"),
                                resultSet.getInt("idconection"));
                        JOptionPane.showMessageDialog(null, "Se Econtro el ID de la  Tripulacion", "INSERT", 0);
                        return Optional.of(tripBookingDetails);
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
            String query = "DELETE FROM tripcrews WHERE idemployees = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Elimino Tripulacion", "INSERT", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Tripcrews> findAll() {
        List<Tripcrews> tripBookingDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT idemployees, idconection FROM tripcrews";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tripcrews details = new Tripcrews(
                            resultSet.getInt("idemployees"),
                            resultSet.getInt("idconection"));

                    tripBookingDetails.add(details);
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return tripBookingDetails;
    }
}
