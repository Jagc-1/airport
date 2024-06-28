package com.campuslands.modules.revemployee.infrastructure.out;

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
import com.campuslands.modules.revemployee.domain.models.Revemployee;
import com.campuslands.modules.revemployee.domain.repository.RevEmployeeRepository;

public class RevEmployeeMySqlRepository extends MySQL implements RevEmployeeRepository {

    public RevEmployeeMySqlRepository() {
        super();
    }

    @Override
    public void save(Revemployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revemployee (idemployee,idrevision) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, revEmployee.getIdEmployee());
                statement.setInt(2, revEmployee.getIdRevision());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Revicion de empleados agregados correctamente", "INSERT", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    @Override
    public void update(Revemployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE revemployee SET idrevision = ? WHERE idemployee = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, revEmployee.getIdEmployee());
                statement.setInt(2, revEmployee.getIdRevision());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se actulizo la revicion de empleados", "UPDATE", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
    }

    @Override
    public Optional<Revemployee> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT idemployee,idrevision FROM revemployee WHERE idemployee = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Revemployee revEmployee = new Revemployee(
                                resultSet.getInt("idemployee"),
                                resultSet.getInt("idRevision"));
                        return Optional.of(revEmployee);
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
            String query = "DELETE FROM revemployee WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
    }

    @Override
    public List<Revemployee> findAll() {
        List<Revemployee> revEmployees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT idemployee,idrevision FROM revemployee";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Revemployee revEmployee = new Revemployee(
                            resultSet.getInt("id"),
                            resultSet.getInt("idRevision"));
                    revEmployees.add(revEmployee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);

        }
        return revEmployees;
    }
}
