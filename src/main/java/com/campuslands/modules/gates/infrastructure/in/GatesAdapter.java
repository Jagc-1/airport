package com.campuslands.modules.gates.infrastructure.in;
import com.campuslands.modules.gates.domain.models.Gates;
import com.campuslands.modules.gates.application.GatesService; 

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class GatesAdapter {
  
    private final GatesService gatesService;

    public GatesAdapter(GatesService gatesService) {
        this.gatesService = gatesService;
    }

    
     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Puertas de Embarque");
        System.out.println("1. Registrar Puerta de Embarque");
        System.out.println("2. Actualizar Puerta de Embarque");
        System.out.println("3. Buscar Puerta de Embarque por ID");
        System.out.println("4. Eliminar Puerta de Embarque");
        System.out.println("5. Listar todas las Puertas de Embarque");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el número de la puerta de embarque: ");
                String createGateNumber = scanner.nextLine();
                System.out.print("Ingrese el ID del aeropuerto: ");
                String createAirportId = scanner.nextLine();
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID de la puerta de embarque: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Gates newGate = new Gates(createId, createGateNumber, createAirportId);
                gatesService.createGate(newGate);
                break;
            
            case 2:
                System.out.print("Ingrese el ID de la puerta de embarque a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo número de la puerta de embarque: ");
                String updateGateNumber = scanner.nextLine();
                System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                String updateAirportId = scanner.nextLine();
                
                Gates updatedGate = new Gates(updateId, updateGateNumber, updateAirportId);
                gatesService.updateGate(updatedGate);
                break;
            
            case 3:
                System.out.print("Ingrese el ID de la puerta de embarque a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Gates> gate = gatesService.getGateById(findId);
                gate.ifPresentOrElse(
                    g -> System.out.println("ID: " + g.getId() + ", Número de puerta: " + g.getGetNumber() + ", ID Aeropuerto: " + g.getIdAirport()),
                    () -> System.out.println("Puerta de embarque no encontrada"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID de la puerta de embarque a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                gatesService.deleteGate(deleteId);
                break;
            
            case 5:
                List<Gates> gates = gatesService.getAllGates();
                gates.forEach(g -> {
                    System.out.println("ID: " + g.getId() + ", Número de puerta: " + g.getGetNumber() + ", ID Aeropuerto: " + g.getIdAirport());
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

   