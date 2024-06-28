package com.campuslands.modules.tripbooking.infrastructure.out;

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
import com.campuslands.modules.tripbooking.domain.models.TripBooking;
import com.campuslands.modules.tripbooking.domain.repository.TripBookingRepository;

public class TripbookingMySQL extends MySQL implements TripBookingRepository {

    public TripbookingMySQL() {
        super();
    }

    @Override
    public void save(TripBooking tripBooking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO trip_bookings (date, idtrips) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, new java.sql.Date(tripBooking.getDate().getTime()));
                statement.setInt(2, tripBooking.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Agrego Correctamente", "INSERT", 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(TripBooking tripBooking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE trip_bookings SET date = ?, trip_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, new java.sql.Date(tripBooking.getDate().getTime()));
                statement.setInt(2, tripBooking.getIdtrips());
                statement.setInt(3, tripBooking.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se actualizo Correctamente", "UPDATE", 2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<TripBooking> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,date,idtrips FROM trip_bookings WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        TripBooking tripBooking = new TripBooking(
                                resultSet.getInt("id"),
                                resultSet.getDate("date"),
                                resultSet.getInt("trip_id"));
                        return Optional.of(tripBooking);
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
            String query = "DELETE FROM trip_bookings WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<TripBooking> findAll() {
        List<TripBooking> tripBookings = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, date, trip_id FROM trip_bookings";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TripBooking tripBooking = new TripBooking(
                            resultSet.getInt("id"),
                            resultSet.getDate("date"),
                            resultSet.getInt("trip_id"));
                    tripBookings.add(tripBooking);
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return tripBookings;
    }
}
