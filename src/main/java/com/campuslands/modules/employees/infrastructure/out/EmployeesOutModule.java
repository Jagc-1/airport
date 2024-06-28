package com.campuslands.modules.employees.infrastructure.out;
import com.campuslands.modules.employees.application.EmployeesService;
import com.campuslands.modules.employees.infrastructure.in.EmployeesAdapter;

public class EmployeesOutModule {

    protected EmployeesMySQL employeesMySQL;
    protected EmployeesService employeesService;
    protected EmployeesAdapter employeesAdapter;

    public EmployeesOutModule() {
        employeesMySQL = new EmployeesMySQL(); // Initialize EmployeesMySQL instance
        employeesService = new EmployeesService(employeesMySQL); // Initialize EmployeesService with EmployeesMySQL
        employeesAdapter = new EmployeesAdapter(employeesService); // Initialize EmployeesAdapter with EmployeesService
    }

    public EmployeesAdapter module() {
        return employeesAdapter; // Return the EmployeesAdapter instance
    }


}
