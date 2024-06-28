package com.campuslands.modules.revemployee.infrastructure.in;

import com.campuslands.modules.revemployee.domain.models.Revemployee;
import com.campuslands.modules.revemployee.application.RevemployeeService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RevemployeeAdapter {

    private final RevemployeeService revemployeeService;

    public RevemployeeAdapter(RevemployeeService revemployeeService) {
        this.revemployeeService = revemployeeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Revemployee");
            System.out.println("1. Registrar Revemployee");
            System.out.println("2. Actualizar Revemployee");
            System.out.println("3. Buscar Revemployee por ID");
            System.out.println("4. Eliminar Revemployee");
            System.out.println("5. Listar todos los Revemployee");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    int idEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID de la revisión: ");
                    int idRevision = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Revemployee newRevemployee = new Revemployee(idEmployee, idRevision);
                    revemployeeService.createRevemployee(newRevemployee);
                    System.out.println("Revemployee registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int updateIdEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID de la revisión: ");
                    int updateIdRevision = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Revemployee revemployeeToUpdate = new Revemployee(updateIdEmployee, updateIdRevision);
                    revemployeeService.updateRevemployee(revemployeeToUpdate);
                    System.out.println("Revemployee actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    int findIdEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Revemployee> revemployee = revemployeeService.getRevemployeeById(findIdEmployee);
                    revemployee.ifPresentOrElse(
                            r -> System.out.println("ID Empleado: " + r.getIdEmployee() + ", ID Revisión: " + r.getIdRevision()),
                            () -> System.out.println("Revemployee no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int deleteIdEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    revemployeeService.deleteRevemployee(deleteIdEmployee);
                    System.out.println("Revemployee eliminado correctamente.");
                    break;

                case 5:
                    List<Revemployee> revemployees = revemployeeService.getAllRevemployees();
                    revemployees.forEach(r -> {
                        System.out.println("ID Empleado: " + r.getIdEmployee() + ", ID Revisión: " + r.getIdRevision());
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


