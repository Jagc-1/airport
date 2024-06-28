package com.campuslands;

import java.util.Scanner;

import com.campuslands.modules.airports.infrastructure.out.AirportsOutModule;
import com.campuslands.modules.customers.infrastructure.out.CustomersOutModule;
import com.campuslands.modules.documenttypes.infrastructure.out.DocumenttypesOutModule;
import com.campuslands.modules.planes.infrastructure.out.PlanesOutModule;
import com.campuslands.modules.revisions.infrastructure.out.RevisionsOutModule;
import com.campuslands.modules.tripbooking.infrastructure.out.TripbookingOutModule;
import com.campuslands.modules.tripbookingdetails.infrastructure.out.TripbookingdetailsOutModule;
import com.campuslands.modules.tripcrews.infrastructure.out.TripcrewsOutModule;
import com.campuslands.modules.trips.infrastructure.out.TripsOutModule;

public class Main {
    public static void main(String[] args) {
        menuUser();

    }

    public static void menuUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Administrador");
            System.out.println("2. Ventas");
            System.out.println("3. Técnico de Mantenimiento");
            System.out.println("4. Cliente");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    subMenuAdmin();
                    break;
                case 2:
                    bMenuVentas();
                    break;
                case 3:
                    subMenuTecnico();
                    break;
                case 4:
                    subMenuCliente();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return; // Salir del programa

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
    public static void subMenuAdmin() {
        try (Scanner scanner = new Scanner(System.in)) {
            TripsOutModule tripsOutModule = new TripsOutModule();
            while (true) {
                System.out.println("Bienvenido Admin");
                System.out.println("1. Aviones");
                System.out.println("2. Asignar Tripulación");
                System.out.println("3. Trayectos");
                System.out.println("4. Aeropuertos");
                System.out.println("5. Escalas");
                System.out.println("6. Tarifas");
                System.out.println("7. Tipo de Documento");
               // System.out.println("8. Consultas");
                System.out.println("9. Salir");

                System.out.println("");
                // scanner.next();
              //  String role f
              int rol = 1;
                int choice = scanner.nextInt();
                // scanner.nextLine(); // Consumir el salto de línea
                switch (choice) {
                    case 1:
                        PlanesOutModule plane = new PlanesOutModule();
                        plane.module().start(rol);

                    case 2:
                        TripcrewsOutModule tripcrewsOutModule = new TripcrewsOutModule();
                        tripcrewsOutModule.module().start();

                    case 3:
                        tripsOutModule.module().start();
                    case 4:
                        AirportsOutModule airportsOutModule = new AirportsOutModule();
                        airportsOutModule.module().start();

                    case 5:
                        tripsOutModule.module().start();

                    case 6:
                        tripsOutModule.module().start();

                    case 7:
                        DocumenttypesOutModule document = new DocumenttypesOutModule();
                        document.module().start();

                    case 8:
                        //subMenuConsults();

                    case 9:
                        System.out.println("Saliendo...");
                        return; // Salir del programa

                    default:
                        System.out.println("Opción inválida, inténtelo de nuevo.");
                }
            }
        }
    }

   
    

    public static void bMenuVentas() {
        try (Scanner scanner = new Scanner(System.in)) {
            CustomersOutModule CustomersOutModule = new CustomersOutModule();
            TripbookingOutModule tripbookingOutModule = new TripbookingOutModule();
            while (true) {
                System.out.println("1. Crear una reserva");
                System.out.println("2. Consultar Cliente");
                System.out.println("3. Actualizar Cliente");
                System.out.println("4. Consultar Reserva");
                System.out.println("5. Registrar Cliente");
                System.out.println("6. Eliminar Reserva");
                System.out.println("7. Salir");
                System.out.print("Ingrese la opción: ");
int rol = 3;
                int choice = scanner.nextInt();
                // scanner.nextLine(); // Consumir el salto de línea

                switch (choice) {
                    case 1 ->
                        tripbookingOutModule.module().start(rol);

                    case 2 ->
                        CustomersOutModule.module().start(rol);

                    case 3 ->
                        CustomersOutModule.module().start(rol);

                    case 4 ->
                        tripbookingOutModule.module().start(rol);

                    case 5 ->
                        CustomersOutModule.module().start(rol);

                    case 6 ->
                        tripbookingOutModule.module().start(rol);
                    case 7 -> {
                        System.out.println("Saliendo...");
                        return;
                    }
                    default ->
                        System.out.println("Opción inválida, inténtelo de nuevo.");
                }
            }
        }
    }

    public static void subMenuTecnico() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Revisiones");
                System.out.println("2. Salir");
                System.out.print("Ingrese la opción: ");

                int choice = scanner.nextInt();
                // scanner.nextLine(); // Consumir el salto de línea
int rol =2;
                switch (choice) {
                    case 1:
                        RevisionsOutModule revisionsOutModule = new RevisionsOutModule();
                        revisionsOutModule.module().start(rol);

                    case 2:
                        System.out.println("Saliendo...");
                        return; // Salir del programa

                    default:
                        System.out.println("Opción inválida, inténtelo de nuevo.");
                }
            }
        }
    }

    public static void subMenuCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
            TripsOutModule trips = new TripsOutModule();
            TripbookingdetailsOutModule tripDetails = new TripbookingdetailsOutModule();
            while (true) {
                System.out.println("1. Buscar Vuelos");
                System.out.println("2. Seleccionar Vuelos");
                System.out.println("3. Añadir Pasajero");
                System.out.println("4. Seleccionar Asientos");
                System.out.println("5. Realizar Pago");
                System.out.println("6. Consultar Reserva de Vuelo");
                System.out.println("7. Cancelar Reserva de Vuelo");
                System.out.println("8. Modificar Reserva de Vuelo");
                System.out.println("9. Salir");
                System.out.println("");
                System.out.print("Ingrese la opción: ");

                int choice = scanner.nextInt();
                // scanner.nextLine(); // Consumir el salto de línea

                switch (choice) {
                    case 1 -> {
                        trips.module().start();
                    }

                    case 2 -> {
                        trips.module().start();
                    }

                    case 3 -> {
                        trips.module().start();
                    }

                    case 4 -> {
                        trips.module().start();
                    }

                    case 5 -> {
                        trips.module().start();
                    }

                    case 6 -> {
                        tripDetails.module().start();
                    }

                    case 7 -> {
                        tripDetails.module().start();
                    }

                    case 8 -> {
                        tripDetails.module().start();
                    }
                    case 9 -> {
                        System.out.println("Saliendo...");
                        return; // Salir del programa
                    }
                    default ->
                        System.out.println("Opción inválida, inténtelo de nuevo.");
                }
            }
        }
    }

}
