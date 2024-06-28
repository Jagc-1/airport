package com.campuslands.modules.revision_details.infrastructure.in;

import com.campuslands.modules.revision_details.domain.models.RevisionDetails;
import com.campuslands.modules.revision_details.application.RevisionDetailsService;


import java.util.Scanner;
import java.util.List;
import java.util.Optional;


public class Revision_detailsAdapter {
    private final RevisionDetailsService revisionDetailsService;

    public Revision_detailsAdapter(RevisionDetailsService revisionDetailsService) {
        this.revisionDetailsService = revisionDetailsService;
    }


        public void start() {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("Menú de Gestión de RevisionDetails");
                System.out.println("1. Registrar RevisionDetails");
                System.out.println("2. Actualizar RevisionDetails");
                System.out.println("3. Buscar RevisionDetails por ID");
                System.out.println("4. Eliminar RevisionDetails");
                System.out.println("5. Listar todos los RevisionDetails");
                System.out.println("6. Salir");
                System.out.println("");
                System.out.print("Ingrese la opción: ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
    
                switch (choice) {
                    case 1:
                        System.out.print("Ingrese el ID del detalle de revisión: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Ingrese la descripción: ");
                        String description = scanner.nextLine();
                        System.out.print("Ingrese el ID del empleado: ");
                        int idEmployee = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
    
                        RevisionDetails newRevisionDetails = new RevisionDetails(id, description, idEmployee);
                        revisionDetailsService.createRevisionDetail(newRevisionDetails);
                        System.out.println("RevisionDetails registrado correctamente.");
                        break;
    
                    case 2:
                        System.out.print("Ingrese el ID del detalle de revisión a actualizar: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Ingrese la nueva descripción: ");
                        String updateDescription = scanner.nextLine();
                        System.out.print("Ingrese el nuevo ID del empleado: ");
                        int updateIdEmployee = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
    
                        RevisionDetails revisionDetailsToUpdate = new RevisionDetails(updateId, updateDescription, updateIdEmployee);
                        revisionDetailsService.updateRevisionDetail(revisionDetailsToUpdate);
                        System.out.println("RevisionDetails actualizado correctamente.");
                        break;
    
                    case 3:
                        System.out.print("Ingrese el ID del detalle de revisión a buscar: ");
                        int findId = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
    
                        Optional<RevisionDetails> revisionDetails = revisionDetailsService.getRevisionDetailById(findId);
                        revisionDetails.ifPresentOrElse(
                                r -> System.out.println("ID: " + r.getId() + ", Descripción: " + r.getDescription() + ", ID Empleado: " + r.getId_employee()),
                                () -> System.out.println("RevisionDetails no encontrado"));
                        break;
    
                    case 4:
                        System.out.print("Ingrese el ID del detalle de revisión a eliminar: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
    
                        revisionDetailsService.deleteRevisionDetail(deleteId);
                        System.out.println("RevisionDetails eliminado correctamente.");
                        break;
    
                    case 5:
                        List<RevisionDetails> allRevisionDetails = revisionDetailsService.getAllRevisionDetails();
                        allRevisionDetails.forEach(r -> {
                            System.out.println("ID: " + r.getId() + ", Descripción: " + r.getDescription() + ", ID Empleado: " + r.getId_employee());
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