package com.campuslands.modules.tripcrews.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.tripcrews.application.TripcrewsService;
import com.campuslands.modules.tripcrews.domain.models.Tripcrews;

public class TripcrewsAdapter {

    private final TripcrewsService tripcrewsService;

    public TripcrewsAdapter(TripcrewsService tripcrewsService) {
        this.tripcrewsService = tripcrewsService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Tripcrews");
            System.out.println("1. Registrar Tripcrews");
            System.out.println("2. Actualizar Tripcrews");
            System.out.println("3. Buscar Tripcrews por ID");
            System.out.println("4. Eliminar Tripcrews");
            System.out.println("5. Listar todos los Tripcrews");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    int idEmployees = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID de la conexión: ");
                    int idConnection = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Tripcrews newTripCrews = new Tripcrews(idEmployees, idConnection);
                    tripcrewsService.createTripcrew(newTripCrews);
                    System.out.println("Tripcrews registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo ID del empleado: ");
                    int updateIdEmployees = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID de la conexión: ");
                    int updateIdConnection = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Tripcrews tripCrewsToUpdate = new Tripcrews(updateIdEmployees, updateIdConnection);

                    tripcrewsService.updateTripcrew(tripCrewsToUpdate);
                    System.out.println("Tripcrews actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del Tripcrews a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Tripcrews> tripCrews = tripcrewsService.getTripcrewById(findId);
                    tripCrews.ifPresentOrElse(
                            t -> System.out.println(
                                    "ID Empleado: " + t.getIdemployees() + ", ID Conexión: " + t.getIdconection()),
                            () -> System.out.println("Tripcrews no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del Tripcrews a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    tripcrewsService.deleteTripcrew(deleteId);
                    System.out.println("Tripcrews eliminado correctamente.");
                    break;

                case 5:
                    List<Tripcrews> allTripCrews = tripcrewsService.getAllTripcrews();
                    allTripCrews.forEach(t -> {
                        System.out
                                .println("ID Empleado: " + t.getIdemployees() + ", ID Conexión: " + t.getIdconection());
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
