package com.campuslands.modules.employees.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.employees.domain.models.Employee;

public interface EmployeesRepository {
    void save(Employee employees);
    void update(Employee employees);
    Optional<Employee> findById(int id);
    void delete(int id);
    List<Employee> findAll();
}