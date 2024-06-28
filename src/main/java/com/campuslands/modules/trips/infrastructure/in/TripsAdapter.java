package com.campuslands.modules.trips.infrastructure.in;

import com.campuslands.modules.trips.domain.models.Trips;
import com.campuslands.modules.trips.application.TripsService; // Asegúrate de importar el servicio correcto


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TripsAdapter {
    private final TripsService tripsService;

    public TripsAdapter(TripsService tripsService) {
        this.tripsService = tripsService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Menú de Gestión de Trips");
            System.out.println("1. Registrar Trip");
            System.out.println("2. Actualizar Trip");
            System.out.println("3. Buscar Trip por ID");
            System.out.println("4. Eliminar Trip");
            System.out.println("5. Listar todos los Trips");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del viaje: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la fecha del viaje (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    Date date;
                    try {
                        date = (Date) dateFormat.parse(dateStr);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
                        break;
                    }
                    System.out.print("Ingrese el precio del viaje: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el aeropuerto de salida: ");
                    String departureAirport = scanner.nextLine();
                    System.out.print("Ingrese el aeropuerto de llegada: ");
                    String arrivalAirport = scanner.nextLine();

                    Trips newTrip = new Trips(id, date, price, departureAirport, arrivalAirport);
                    tripsService.createTrip(newTrip);
                    System.out.println("Trip registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del Trip a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la nueva fecha del viaje (YYYY-MM-DD): ");
                    String updateDateStr = scanner.nextLine();
                    Date updateDate;
                    try {
                        updateDate = (Date) dateFormat.parse(updateDateStr);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
                        break;
                    }
                    System.out.print("Ingrese el nuevo precio del viaje: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo aeropuerto de salida: ");
                    String updateDepartureAirport = scanner.nextLine();
                    System.out.print("Ingrese el nuevo aeropuerto de llegada: ");
                    String updateArrivalAirport = scanner.nextLine();

                    Trips tripToUpdate = new Trips(updateId, updateDate, updatePrice, updateDepartureAirport, updateArrivalAirport);
                    tripsService.updateTrip(tripToUpdate);
                    System.out.println("Trip actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del Trip a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Trips> trip = tripsService.getTripById(findId);
                    trip.ifPresentOrElse(
                            t -> System.out.println("ID: " + t.getId() + ", Fecha: " + dateFormat.format(t.getDate()) + ", Precio: $" + t.getPrice() + ", Aeropuerto de Salida: " + t.getDeparture_airport() + ", Aeropuerto de Llegada: " + t.getArrival_airport()),
                            () -> System.out.println("Trip no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del Trip a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    tripsService.deleteTrip(deleteId);
                    System.out.println("Trip eliminado correctamente.");
                    break;

                case 5:
                    List<Trips> allTrips = tripsService.getAllTrips();
                    allTrips.forEach(t -> {
                        System.out.println("ID: " + t.getId() + ", Fecha: " + dateFormat.format(t.getDate()) + ", Precio: $" + t.getPrice() + ", Aeropuerto de Salida: " + t.getDeparture_airport() + ", Aeropuerto de Llegada: " + t.getArrival_airport());
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
