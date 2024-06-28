package com.campuslands.modules.tripbookingdetails.infrastructure.in;
import com.campuslands.modules.tripbookingdetails.domain.models.Tripbookingdetails;
import com.campuslands.modules.tripbookingdetails.application.TripbookingdetailsService; 


import java.util.Optional;
import java.util.Scanner;
import java.util.List;

public class TripbookingdetailsAdapter {

    private final TripbookingdetailsService tripbookingdetailsService;

    public TripbookingdetailsAdapter(TripbookingdetailsService tripbookingdetailsService) {
        this.tripbookingdetailsService = tripbookingdetailsService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de TripBookingDetails");
            System.out.println("1. Registrar TripBookingDetails");
            System.out.println("2. Actualizar TripBookingDetails");
            System.out.println("3. Buscar TripBookingDetails por ID");
            System.out.println("4. Eliminar TripBookingDetails");
            System.out.println("5. Listar todos los TripBookingDetails");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del detalle de reserva de viaje: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID de la reserva de viaje: ");
                    int idTripBooking = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el ID del cliente: ");
                    String idCustomers = scanner.nextLine();
                    System.out.print("Ingrese el ID de la tarifa: ");
                    int idFares = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Tripbookingdetails newTripBookingDetails = new Tripbookingdetails(id, idTripBooking, idCustomers, idFares);
                    tripbookingdetailsService.createTripbookingdetail(newTripBookingDetails);
                    System.out.println("TripBookingDetails registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del detalle de reserva de viaje a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID de la reserva de viaje: ");
                    int updateIdTripBooking = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo ID del cliente: ");
                    String updateIdCustomers = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID de la tarifa: ");
                    int updateIdFares = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Tripbookingdetails tripBookingDetailsToUpdate = new Tripbookingdetails(updateId, updateIdTripBooking, updateIdCustomers, updateIdFares);
                    tripbookingdetailsService.updateTripbookingdetail(tripBookingDetailsToUpdate);
                    System.out.println("TripBookingDetails actualizado correctamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del detalle de reserva de viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Tripbookingdetails> tripBookingDetails = tripbookingdetailsService.getTripbookingdetailById(findId);
                    tripBookingDetails.ifPresentOrElse(
                            t -> System.out.println("ID: " + t.getId() + ", ID Reserva de Viaje: " + t.getIdtripbooking() + ", ID Cliente: " + t.getIdcustomers() + ", ID Tarifa: " + t.getIdfares()),
                            () -> System.out.println("TripBookingDetails no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del detalle de reserva de viaje a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    tripbookingdetailsService.deleteTripbookingdetail(deleteId);
                    System.out.println("TripBookingDetails eliminado correctamente.");
                    break;

                case 5:
                    List<Tripbookingdetails> allTripBookingDetails = tripbookingdetailsService.getAllTripbookingdetails();
                    allTripBookingDetails.forEach(t -> {
                        System.out.println("ID: " + t.getId() + ", ID Reserva de Viaje: " + t.getIdtripbooking() + ", ID Cliente: " + t.getIdcustomers() + ", ID Tarifa: " + t.getIdfares());
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
