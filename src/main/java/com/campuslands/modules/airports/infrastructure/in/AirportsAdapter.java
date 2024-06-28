package com.campuslands.modules.airports.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.campuslands.modules.airports.domain.models.Airport;
import com.campuslands.modules.airports.application.AirportsService;

/**
 * AirportsAdapter
 */
public class AirportsAdapter {

    private final AirportsService airportsService;

    public AirportsAdapter(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Aeropuertos");
        System.out.println("1. Crear Aeropuerto");
        System.out.println("2. Actualizar Aeropuerto");
        System.out.println("3. Buscar Aeropuerto por ID");
        System.out.println("4. Eliminar Aeropuerto");
        System.out.println("5. Listar todos los Aeropuertos");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del aeropuerto: ");
                String createName = scanner.nextLine();
                System.out.print("Ingrese el ID de la ciudad del aeropuerto: ");
                int createCityId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del aeropuerto: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Airport newAirport = new Airport(createId, createName, createCityId);
                airportsService.createAirport(newAirport);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del aeropuerto a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del aeropuerto: ");
                String updateName = scanner.nextLine();
                System.out.print("Ingrese el nuevo ID de la ciudad del aeropuerto: ");
                int updateCityId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Airport updatedAirport = new Airport(updateId, updateName, updateCityId);
                airportsService.updateAirport(updatedAirport);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del aeropuerto a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Airport> airport = airportsService.getAirportById(findId);
                airport.ifPresentOrElse(
                    a -> System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName() + ", ID Ciudad: " + a.getIdCity()),
                    () -> System.out.println("Aeropuerto no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del aeropuerto a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                airportsService.deleteAirport(deleteId);
                break;
            
            case 5:
                List<Airport> airports = airportsService.getAllAirports();
                airports.forEach(a -> {
                    System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName() + ", ID Ciudad: " + a.getIdCity());
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