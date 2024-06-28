package com.campuslands.modules.manufacturers.infrastructure.out;

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
import com.campuslands.modules.manufacturers.domain.models.Manufacturers;
import com.campuslands.modules.manufacturers.domain.repository.ManufacturersRepository;

public class ManufacturersMySqlRepository extends MySQL implements ManufacturersRepository {

    public ManufacturersMySqlRepository() {
        super();
    }

    @Override
    public void save(Manufacturers manufacturers) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO manufacturers (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, manufacturers.getName());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Manufactura  cereada exitosamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Manufacturers manufacturers) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE manufacturers SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, manufacturers.getName());
                statement.setInt(2, manufacturers.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Manufactura actualizada correctamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Manufacturers> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name FROM manufacturers WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Manufacturers manufacturers = new Manufacturers(
                                resultSet.getInt("id"),
                                resultSet.getString("name"));
                        return Optional.of(manufacturers);
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
            String query = "DELETE FROM manufacturers WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Manufactura  eliminada exitosamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Manufacturers> findAll() {
        List<Manufacturers> manufacturers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name FROM manufacturers";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Manufacturers manufacturer = new Manufacturers(
                            resultSet.getInt("id"),
                            resultSet.getString("name"));
                    manufacturers.add(manufacturer);
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return manufacturers;
    }
}
