package com.campuslands.modules.flightconnections.infrastructure.in;

import com.campuslands.modules.flightconnections.domain.models.FlightConnection;
import com.campuslands.modules.flightconnections.application.FlightConnectionsService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FlightConnectionsAdapter {
    private final FlightConnectionsService flightConnectionsService;

    public FlightConnectionsAdapter(FlightConnectionsService flightConnectionsService) {
        this.flightConnectionsService = flightConnectionsService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Conexiones de Vuelo");
            System.out.println("1. Crear Conexión de Vuelo");
            System.out.println("2. Actualizar Conexión de Vuelo");
            System.out.println("3. Buscar Conexión de Vuelo por ID");
            System.out.println("4. Eliminar Conexión de Vuelo");
            System.out.println("5. Listar todas las Conexiones de Vuelo");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el número de conexión: ");
                    String createConnectionNumber = scanner.nextLine();
                    System.out.print("Ingrese el ID del viaje: ");
                    int createTripId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID del avión: ");
                    int createPlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID del aeropuerto: ");
                    String createAirportId = scanner.nextLine();
                    System.out.print("Ingrese el tipo de vuelo: ");
                    String createFlightType = scanner.nextLine();
                    System.out.print("Ingrese la última escala: ");
                    String createLastScale = scanner.nextLine();

                    // Generar un ID único (puede ser automático o solicitado)
                    System.out.print("Ingrese el ID de la conexión de vuelo: ");
                    int createId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    FlightConnection newFlightConnection = new FlightConnection(createId, createConnectionNumber,
                            createTripId, createPlaneId, createAirportId, createFlightType, createLastScale);
                    flightConnectionsService.createFlightConnection(newFlightConnection);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la conexión de vuelo a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo número de conexión: ");
                    String updateConnectionNumber = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del viaje: ");
                    int updateTripId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID del avión: ");
                    int updatePlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                    String updateAirportId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo tipo de vuelo: ");
                    String updateFlightType = scanner.nextLine();
                    System.out.print("Ingrese la nueva última escala: ");
                    String updateLastScale = scanner.nextLine();

                    FlightConnection updatedFlightConnection = new FlightConnection(updateId, updateConnectionNumber,
                            updateTripId, updatePlaneId, updateAirportId, updateFlightType, updateLastScale);
                    flightConnectionsService.updateFlightConnection(updatedFlightConnection);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la conexión de vuelo a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<FlightConnection> flightConnection = flightConnectionsService
                            .getFlightConnectionById(findId);
                    flightConnection.ifPresentOrElse(
                            fc -> System.out.println("ID: " + fc.getId() + ", Número de conexión: "
                                    + fc.getConnection_number() + ", ID Viaje: " + fc.getId_trip() + ", ID Avión: "
                                    + fc.getId_plane() + ", ID Aeropuerto: " + fc.getId_airport() + ", Tipo de vuelo: "
                                    + fc.getType_flight() + ", Última escala: " + fc.getLast_Scale()),
                            () -> System.out.println("Conexión de vuelo no encontrada"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la conexión de vuelo a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    flightConnectionsService.deleteFlightConnection(deleteId);
                    break;

                case 5:
                    List<FlightConnection> flightConnections = flightConnectionsService.getAllFlightConnections();
                    flightConnections.forEach(fc -> {
                        System.out.println("ID: " + fc.getId() + ", Número de conexión: " + fc.getConnection_number()
                                + ", ID Viaje: " + fc.getId_trip() + ", ID Avión: " + fc.getId_plane()
                                + ", ID Aeropuerto: " + fc.getId_airport() + ", Tipo de vuelo: " + fc.getType_flight()
                                + ", Última escala: " + fc.getLast_Scale());
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
