package com.campuslands.modules.flightfares.infrastructure.in;

import com.campuslands.modules.flightfares.domain.models.Flightfares;
import com.campuslands.modules.flightfares.application.FlightfaresService;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class FlightFaresAdapter {
  
    private final FlightfaresService flightfaresService;

    public FlightFaresAdapter(FlightfaresService flightfaresService) {
        this.flightfaresService = flightfaresService;
    }
    
     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Incidentes de Vuelo");
        System.out.println("1. Registrar Incidente de Vuelo");
        System.out.println("2. Actualizar Incidente de Vuelo");
        System.out.println("3. Buscar Incidente de Vuelo por ID");
        System.out.println("4. Eliminar Incidente de Vuelo");
        System.out.println("5. Listar todos los Incidentes de Vuelo");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese la descripción del incidente: ");
                String createDescription = scanner.nextLine();
                System.out.print("Ingrese los detalles del incidente: ");
                String createDetails = scanner.nextLine();
                System.out.print("Ingrese el valor del incidente: ");
                int createValue = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del incidente de vuelo: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Flightfares newFlightFire = new Flightfares(createId, createDescription, createDetails, createValue);
                flightfaresService.createFlightfare(newFlightFire);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del incidente de vuelo a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese la nueva descripción del incidente: ");
                String updateDescription = scanner.nextLine();
                System.out.print("Ingrese los nuevos detalles del incidente: ");
                String updateDetails = scanner.nextLine();
                System.out.print("Ingrese el nuevo valor del incidente: ");
                int updateValue = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Flightfares updatedFlightFire = new Flightfares(updateId, updateDescription, updateDetails, updateValue);
                flightfaresService.updateFlightfare(updatedFlightFire);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del incidente de vuelo a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Flightfares> flightFire = flightfaresService.getFlightfareById(findId);
                flightFire.ifPresentOrElse(
                    ff -> System.out.println("ID: " + ff.getId() + ", Descripción: " + ff.getDescription() + ", Detalles: " + ff.getDetails() + ", Valor: " + ff.getValue()),
                    () -> System.out.println("Incidente de vuelo no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del incidente de vuelo a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                flightfaresService.deleteFlightfare(deleteId);
                break;
            
            case 5:
                List<Flightfares> flightFires = flightfaresService.getAllFlightfares();
                flightFires.forEach(ff -> {
                    System.out.println("ID: " + ff.getId() + ", Descripción: " + ff.getDescription() + ", Detalles: " + ff.getDetails() + ", Valor: " + ff.getValue());
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
    
    