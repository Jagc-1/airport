package com.campuslands.modules.planes.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.planes.application.PlanesService;
import com.campuslands.modules.planes.domain.models.Planes;

public class PlanesAdapter {

    private final PlanesService planesService;

    public PlanesAdapter(PlanesService planesService) {
        this.planesService = planesService;
    }

    public void start(int rol) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Menú de Gestión de Aviones");
            System.out.println("1. Registrar Avión");
            System.out.println("2. Actualizar Avión");
            System.out.println("3. Buscar Avión por ID");
            System.out.println("4. Eliminar Avión");
            System.out.println("5. Listar todos los Aviones");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1 -> { 
                    if (rol!=1){break;}
                    System.out.print("Ingrese el número de matrícula del avión: ");
                    String createPlateNumber = scanner.nextLine();
                    System.out.print("Ingrese la capacidad del avión: ");
                    int createCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la fecha de fabricación del avión (YYYY-MM-DD): ");
                    String fabricationDateStr = scanner.nextLine();

                    System.out.print("Ingrese el ID del estado del avión: ");
                    int createStatusId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID del modelo del avión: ");
                    int createModelId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Planes newPlane = new Planes(createPlateNumber, createCapacity, fabricationDateStr,
                            createStatusId, createModelId);
                    planesService.createPlane(newPlane);
                    break;
                }

                case 2 -> {
                    System.out.print("Ingrese el ID del avión a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingrese el nuevo número de matrícula del avión: ");
                    String updatePlateNumber = scanner.nextLine();
                    System.out.print("Ingrese la nueva capacidad del avión: ");
                    int updateCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la nueva fecha de fabricación del avión (YYYY-MM-DD): ");
                    String updateFabricationDateStr = scanner.nextLine();
                    // LocalDate updateFabricationDate = LocalDate.parse(updateFabricationDateStr);
                    // // Convertir a Date
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del estado del avión: ");
                    int updateStatusId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID del modelo del avión: ");
                    int updateModelId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Planes updatedPlane = new Planes(updateId, updatePlateNumber, updateCapacity,
                            updateFabricationDateStr,
                            updateStatusId, updateModelId);
                    planesService.updatePlane(updatedPlane);
                }

                case 3 -> {
                    System.out.print("Ingrese el ID del avión a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Planes> plane = planesService.getPlaneById(findId);
                    plane.ifPresentOrElse(
                            p -> System.out.println("ID: " + p.getId() + ", Matrícula: " + p.getPlateNumber()
                                    + ", Capacidad: " + p.getCapacity()
                                    + ", Fabricación: " + p.getFabrication_date() + ", ID Estado: " + p.getId_status()
                                    + ", ID Modelo: " + p.getId_model()),
                            () -> System.out.println("Avión no encontrado"));
                }

                case 4 -> {
                    System.out.print("Ingrese el ID del avión a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    planesService.deletePlane(deleteId);
                }

                case 5 -> {
                    List<Planes> planes = planesService.getAllPlanes();
                    planes.forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Matrícula: " + p.getPlateNumber() + ", Capacidad: "
                                + p.getCapacity()
                                + ", Fabricación: " + p.getFabrication_date() + ", ID Estado: " + p.getId_status()
                                + ", ID Modelo: " + p.getId_model());
                    });
                }

                case 6 -> {
                    scanner.close();
                    System.exit(0);
                }

                default ->
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

}
