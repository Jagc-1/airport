package com.campuslands.modules.employees.infrastructure.in;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.employees.application.EmployeesService;
import com.campuslands.modules.employees.domain.models.Employee;

public class EmployeesAdapter {

    private final EmployeesService employeesService;

    public EmployeesAdapter(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Menú de Gestión de Empleados");
            System.out.println("1. Crear Empleado");
            System.out.println("2. Actualizar Empleado");
            System.out.println("3. Buscar Empleado por ID");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Listar todos los Empleados");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    int createId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del empleado: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico del empleado: ");
                    String createEmail = scanner.nextLine();
                    System.out.print("Ingrese la fecha de ingreso del empleado (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();

                    System.out.print("Ingrese el ID de la aerolínea del empleado: ");
                    int createAirlineId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID del aeropuerto del empleado: ");
                    int createAirportId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la contraseña del empleado: ");
                    String createPassword = scanner.nextLine();
                    System.out.print("Ingrese el ID del rol del empleado: ");
                    int createRoleId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Employee newEmployee = new Employee(createId, createName, createEmail, dateStr,
                            createAirlineId, createAirportId, createPassword, createRoleId);
                    employeesService.createEmployee(newEmployee);
                    System.out.println("Empleado creado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo nombre del empleado: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo correo electrónico del empleado: ");
                    String updateEmail = scanner.nextLine();
                    System.out.print("Ingrese la nueva fecha de ingreso del empleado (YYYY-MM-DD): ");
                    String updateDateStr = scanner.nextLine();

                    System.out.print("Ingrese el nuevo ID de la aerolínea del empleado: ");
                    int updateAirlineId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID del aeropuerto del empleado: ");
                    int updateAirportId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la nueva contraseña del empleado: ");
                    String updatePassword = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del rol del empleado: ");
                    int updateRoleId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Employee updatedEmployee = new Employee(updateId, updateName, updateEmail,
                            updateDateStr, updateAirlineId, updateAirportId, updatePassword, updateRoleId);
                    employeesService.updateEmployee(updatedEmployee);
                    System.out.println("Empleado actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Employee> employee = employeesService.getEmployeeById(findId);
                    employee.ifPresentOrElse(
                            e -> System.out.println("ID: " + e.getId() + ", Nombre: " + e.getName() + ", Email: "
                                    + e.getEmail() + ", Fecha de Ingreso: " + dateFormat.format(e.getIngressdate())
                                    + ", ID Aerolínea: " + e.getIdairline() + ", ID Aeropuerto: " + e.getIdairport()
                                    + ", ID Rol: " + e.getIdrol()),
                            () -> System.out.println("Empleado no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    employeesService.deleteEmployee(deleteId);
                    break;

                case 5:
                    List<Employee> employees = employeesService.getAllEmployees();
                    employees.forEach(e -> {
                        System.out.println("ID: " + e.getId() + ", Nombre: " + e.getName() + ", Email: " + e.getEmail()
                                + ", Fecha de Ingreso: " + dateFormat.format(e.getIngressdate()) + ", ID Aerolínea: "
                                + e.getIdairline() + ", ID Aeropuerto: " + e.getIdairport() + ", ID Rol: "
                                + e.getIdrol());
                    });
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

}
