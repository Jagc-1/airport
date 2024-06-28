package com.campuslands.modules.employees.infrastructure.out;

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
import com.campuslands.modules.employees.domain.models.Employee;
import com.campuslands.modules.employees.domain.repository.EmployeesRepository;

public class EmployeesMySQL extends MySQL implements EmployeesRepository {

    public EmployeesMySQL() {
        super();
    }

    @Override
    public void save(Employee employees) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO users ( name, email, ingressdate, idairline, idairport, password, idrol) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, employees.getName());
                statement.setString(2, employees.getEmail());
                statement.setInt(2, employees.getId());
                statement.setInt(3, employees.getIdrol());
                statement.setString(4, employees.getIngressdate());
                statement.setInt(5, employees.getIdairline());
                statement.setString(7, employees.getPassword());
                statement.setInt(8, employees.getIdairport());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado creado exitosamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Employee employees) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employees SET name = ?, email = ?, password = ?, idrol = ?, idairline = ?, idairport = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, employees.getName());
                statement.setInt(2, employees.getId());
                statement.setInt(3, employees.getIdrol());
                statement.setString(4, employees.getIngressdate());
                statement.setInt(5, employees.getIdairline());
                statement.setString(6, employees.getEmail());
                statement.setString(7, employees.getPassword());
                statement.setInt(8, employees.getIdairport());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente", "UPDATE", 0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, email, password, idrol,  ingressdate, idairline, idairport FROM employees WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Employee employees = new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("ingressdate"),
                                resultSet.getInt("idairline"),
                                resultSet.getInt("idairport"),
                                resultSet.getString("password"),
                                resultSet.getInt("idrol"));
                        return Optional.of(employees);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM employees WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado borrado exitosamente", "DELETE", 0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, email, paassword, idrol, ingressdate, idairline, idairport FROM employees";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employees = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("ingressdate"),
                            resultSet.getInt("idairline"),
                            resultSet.getInt("idairport"),
                            resultSet.getString("password"),
                            resultSet.getInt("idrol"));
                    employee.add(employees);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", 0);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        return employee;
    }
}
