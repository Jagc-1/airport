package com.campuslands.modules.tripulationroles.infrastructure.in;

import com.campuslands.modules.tripulationroles.application.TripulationrolesService;
import com.campuslands.modules.tripulationroles.domain.models.Tripulationroles;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TripulationrolesAdapter {

    private final TripulationrolesService tripulationrolesService;

    public TripulationrolesAdapter(TripulationrolesService tripulationrolesService) {
        this.tripulationrolesService = tripulationrolesService;
    }

     public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de TripulationRoles");
            System.out.println("1. Registrar TripulationRole");
            System.out.println("2. Actualizar TripulationRole");
            System.out.println("3. Buscar TripulationRole por ID");
            System.out.println("4. Eliminar TripulationRole");
            System.out.println("5. Listar todos los TripulationRoles");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del rol de tripulación: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nombre del rol de tripulación: ");
                    String name = scanner.nextLine();

                    Tripulationroles newTripulationRole = new Tripulationroles(id, name);
                    tripulationrolesService.createTripulationroles(newTripulationRole);
                    System.out.println("TripulationRole registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del TripulationRole a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo nombre del rol de tripulación: ");
                    String updateName = scanner.nextLine();

                    Tripulationroles tripulationRoleToUpdate = new Tripulationroles(updateId, updateName);
                    tripulationrolesService.updateTripulationroles(tripulationRoleToUpdate);
                    System.out.println("TripulationRole actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del TripulationRole a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Tripulationroles> tripulationRole = tripulationrolesService.getTripulationrolesById(findId);
                    tripulationRole.ifPresentOrElse(
                            tr -> System.out.println("ID: " + tr.getId() + ", Nombre: " + tr.getName()),
                            () -> System.out.println("TripulationRole no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del TripulationRole a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    tripulationrolesService.deleteTripulationroles(deleteId);
                    System.out.println("TripulationRole eliminado correctamente.");
                    break;

                case 5:
                    List<Tripulationroles> allTripulationRoles = tripulationrolesService.getAllTripulationroles();
                    allTripulationRoles.forEach(tr -> {
                        System.out.println("ID: " + tr.getId() + ", Nombre: " + tr.getName());
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
