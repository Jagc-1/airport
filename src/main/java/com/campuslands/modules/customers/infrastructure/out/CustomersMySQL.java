package com.campuslands.modules.customers.infrastructure.out;

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
import com.campuslands.modules.customers.domain.models.Customer;
import com.campuslands.modules.customers.domain.repository.CustomersRepository;

public class CustomersMySQL extends MySQL implements CustomersRepository {

    public CustomersMySQL() {
        super();
    }

    @Override
    public void save(Customer customers) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO customers (name, email, password, age, id_document, id_document_type) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // statement.setInt(1, customers.getId());
                statement.setString(1, customers.getName());
                statement.setString(2, customers.getEmail());
                statement.setString(3, customers.getPassword());
                statement.setInt(4, customers.getAge());
                statement.setString(5, customers.getId_document());
                statement.setInt(6, customers.getId_document_type());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente creado exitosa mente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Customer customers) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE customers SET name = ?, email = ?, password = ?, age = ?, id_document = ?, id_document_type = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, customers.getName());
                statement.setString(2, customers.getEmail());
                statement.setString(3, customers.getPassword());
                statement.setInt(4, customers.getAge());
                statement.setString(5, customers.getId_document());
                statement.setInt(6, customers.getId_document_type());
                statement.setInt(7, customers.getId());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Customer> findById(int id) {
        String query = "SELECT id, name, email, password, age, id_document, id_document_type FROM customers WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Customer customer = new Customer(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getInt("id_document_type"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("id_document")

                    );
                    return Optional.of(customer);
                } else {
                    return Optional.empty(); // No customer found with the given id
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return Optional.empty(); // Exception occurred or no customer found
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM customers WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente borrado exitosamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, email, password, age, id_document, id_document_type FROM customers";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Customer customer = new Customer(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getInt("id_document_type"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("id_document"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        }
        return customers;
    }
}
