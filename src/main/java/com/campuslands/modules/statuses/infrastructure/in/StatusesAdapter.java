package com.campuslands.modules.statuses.infrastructure.in;
import com.campuslands.modules.statuses.domain.models.Statuses;
import com.campuslands.modules.statuses.application.StatusesService; 


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StatusesAdapter {
    private final StatusesService statusesService;

    public StatusesAdapter(StatusesService statusesService) {
        this.statusesService = statusesService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Statuses");
            System.out.println("1. Registrar Status");
            System.out.println("2. Actualizar Status");
            System.out.println("3. Buscar Status por ID");
            System.out.println("4. Eliminar Status");
            System.out.println("5. Listar todos los Statuses");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del status: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nombre del status: ");
                    String name = scanner.nextLine();

                    Statuses newStatus = new Statuses(id, name);
                    statusesService.createStatus(newStatus);
                    System.out.println("Status registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del status a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo nombre del status: ");
                    String updateName = scanner.nextLine();

                    Statuses statusToUpdate = new Statuses(updateId, updateName);
                    statusesService.updateStatus(statusToUpdate);
                    System.out.println("Status actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del status a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Statuses> status = statusesService.getStatusById(findId);
                    status.ifPresentOrElse(
                            s -> System.out.println("ID: " + s.getId() + ", Nombre: " + s.getName()),
                            () -> System.out.println("Status no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del status a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    statusesService.deleteStatus(deleteId);
                    System.out.println("Status eliminado correctamente.");
                    break;

                case 5:
                    List<Statuses> allStatuses = statusesService.getAllStatuses();
                    allStatuses.forEach(s -> {
                        System.out.println("ID: " + s.getId() + ", Nombre: " + s.getName());
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
