package com.campuslands.modules.cities.infrastructure.out;

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
import com.campuslands.modules.cities.domain.models.Cities;
import com.campuslands.modules.cities.domain.repository.CitiesRepository;

public class CitiesMySQL extends MySQL implements CitiesRepository {

    public CitiesMySQL() {
        super();
    }

    @Override
    public void save(Cities cities) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO cities (id, name, idcountry) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, cities.getId());
                statement.setString(2, cities.getName());
                statement.setInt(3, cities.getIdCountry());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ciudad Creada Correctamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Cities cities) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE cities SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, cities.getName());
                statement.setInt(2, cities.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ciudad Actualizada Correctamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Cities> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, idcountry FROM cities WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Cities cities = new Cities(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("id_country"));
                        return Optional.of(cities);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM cities WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ciudad eliminada correctamente", "DELETLE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public List<Cities> findAll() {
        List<Cities> cities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, idcountry FROM cities";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Cities city = new Cities(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("id_country")

                    );
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
        return cities;
    }
}
