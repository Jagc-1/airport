package com.campuslands.modules.trips.infrastructure.out;

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
import com.campuslands.modules.trips.domain.models.Trips;
import com.campuslands.modules.trips.domain.repository.TripsRepository;

public class TripsMySqlRepository extends MySQL implements TripsRepository {

    public TripsMySqlRepository() {
        super();
    }

    @Override
    public void save(Trips trips) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO trips (trip_date, price_tripe, departure_airport, arrival_airport) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, trips.getDate());
                statement.setDouble(2, trips.getPrice());
                statement.setString(3, trips.getDeparture_airport());
                statement.setString(4, trips.getArrival_airport());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Viaje creado correctamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Trips trips) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE trips SET trip_date = ?, price_tripe = ?, departure_airport = ?, arrival_airport = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, trips.getDate());
                statement.setDouble(2, trips.getPrice());
                statement.setString(3, trips.getDeparture_airport());
                statement.setString(4, trips.getArrival_airport());
                statement.setInt(5, trips.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Viaje actualizado correctamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Trips> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT is,trip_date,price_tripe,depar,arrival_airport FROM trips WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Trips trips = new Trips(
                                resultSet.getInt("id"),
                                resultSet.getDate("trip_date"),
                                resultSet.getDouble("price_tripe"),
                                resultSet.getString("departure_airport"),
                                resultSet.getString("arrival_airport"));
                        return Optional.of(trips);
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
            String query = "DELETE FROM trips WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Viaje eliminado correctamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Trips> findAll() {
        List<Trips> trips = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, trip_date, price_tripe, departure_airport, arrival_airport FROM trips";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Trips trip = new Trips(
                            resultSet.getInt("id"),
                            resultSet.getDate("trip_date"),
                            resultSet.getDouble("price_tripe"),
                            resultSet.getString("departure_airport"),
                            resultSet.getString("arrival_airport"));
                    trips.add(trip);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return trips;
    }
}
