package com.campuslands.modules.countries.infrastructure.out;

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
import com.campuslands.modules.countries.domain.models.Country;
import com.campuslands.modules.countries.domain.repository.CountriesRepository;

public class CountriesMySQL extends MySQL implements CountriesRepository {

    public CountriesMySQL() {
        super();
    }

    @Override
    public void save(Country countries) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO countries (id, name) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, countries.getId());
                statement.setString(2, countries.getName());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pais Creado Correctamente", "INSERT", 0);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Country countries) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE countries SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, countries.getName());
                statement.setInt(2, countries.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pais actualizado exitosamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public Optional<Country> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM countries WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Country countries = new Country(
                                resultSet.getInt("id"),
                                resultSet.getString("name"));
                        return Optional.of(countries);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM countries WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pais eleiminado exitosamente ", "DELETE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name FROM countries";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country country = new Country(
                            resultSet.getInt("id"),
                            resultSet.getString("name"));
                    countries.add(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e, "Error", 0);
        }
        return countries;
    }
}
