package com.campuslands.modules.tripbooking.infrastructure.in;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.tripbooking.application.TripbookingService;
import com.campuslands.modules.tripbooking.domain.models.TripBooking;

public class TripbookingAdapter {
  
    private final TripbookingService tripBookingService;

    public TripbookingAdapter(TripbookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {

            System.out.println("Menú de Gestión de TripBooking");
            System.out.println("1. Registrar TripBooking");
            System.out.println("2. Actualizar TripBooking");
            System.out.println("3. Buscar TripBooking por ID");
            System.out.println("4. Eliminar TripBooking");
            System.out.println("5. Listar todos los TripBooking");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                
                case 1 -> {
                    System.out.print("Ingrese el ID de la reserva de viaje: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    Date date;
                    try {
                        date = (Date) dateFormat.parse(dateStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
                        break;
                    }
                    System.out.print("Ingrese el ID del viaje: ");
                    int idTrips = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    TripBooking newTripBooking = new TripBooking(id, date, idTrips);
                    tripBookingService.createTripbooking(newTripBooking);
                    System.out.println("TripBooking registrado correctamente.");
                }
                case 2 -> {
                    System.out.print("Ingrese el ID de la reserva de viaje a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la nueva fecha de la reserva (YYYY-MM-DD): ");
                    String updateDateStr = scanner.nextLine();
                    Date updateDate;
                    try {
                        updateDate = (Date) dateFormat.parse(updateDateStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
                        break;
                    }
                    System.out.print("Ingrese el nuevo ID del viaje: ");
                    int updateIdTrips = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    TripBooking tripBookingToUpdate = new TripBooking(updateId, updateDate, updateIdTrips);
                    tripBookingService.updateTripbooking(tripBookingToUpdate);
                    System.out.println("TripBooking actualizado correctamente.");
                }

                case 3 -> {
                    System.out.print("Ingrese el ID de la reserva de viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<TripBooking> tripBooking = tripBookingService.getTripbookingById(findId);
                    tripBooking.ifPresentOrElse(
                            t -> System.out.println("ID: " + t.getId() + ", Fecha: " + dateFormat.format(t.getDate()) + ", ID Viaje: " + t.getIdtrips()),
                            () -> System.out.println("TripBooking no encontrado"));
                }

                case 4 -> {
                    System.out.print("Ingrese el ID de la reserva de viaje a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    tripBookingService.deleteTripbooking(deleteId);
                    System.out.println("TripBooking eliminado correctamente.");
                }

                case 5 -> {
                    List<TripBooking> allTripBookings = tripBookingService.getAllTripbookings();
                    allTripBookings.forEach(t -> {
                        System.out.println("ID: " + t.getId() + ", Fecha: " + dateFormat.format(t.getDate()) + ", ID Viaje: " + t.getIdtrips());
                    });
                }

                case 6 -> {
                    scanner.close();
                    System.exit(0);
                }

                default -> System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

}
