package com.campuslands.modules.employees.application;


import java.util.List;
import java.util.Optional;
import com.campuslands.modules.employees.domain.models.Employee;
import com.campuslands.modules.employees.domain.repository.EmployeesRepository;

public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public void createEmployee(Employee employee) {
        employeesRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeesRepository.update(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeesRepository.findById(id);
    }

    public void deleteEmployee(int id) {
        employeesRepository.delete(id);
    }

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }
}
