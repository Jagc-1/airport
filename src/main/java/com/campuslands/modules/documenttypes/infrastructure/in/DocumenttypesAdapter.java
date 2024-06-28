package com.campuslands.modules.documenttypes.infrastructure.in;

import com.campuslands.modules.documenttypes.domain.models.DocumentType;
import com.campuslands.modules.documenttypes.application.DocumenttypesService;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DocumenttypesAdapter {    private final DocumenttypesService documentTypesService;

    public DocumenttypesAdapter(DocumenttypesService documentTypesService) {
        this.documentTypesService = documentTypesService;
    }

     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Tipos de Documentos");
        System.out.println("1. Crear Tipo de Documento");
        System.out.println("2. Actualizar Tipo de Documento");
        System.out.println("3. Buscar Tipo de Documento por ID");
        System.out.println("4. Eliminar Tipo de Documento");
        System.out.println("5. Listar todos los Tipos de Documentos");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del tipo de documento: ");
                String createName = scanner.nextLine();
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del tipo de documento: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                DocumentType newDocumentType = new DocumentType(createId, createName);
                documentTypesService.createDocumentType(newDocumentType);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del tipo de documento a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del tipo de documento: ");
                String updateName = scanner.nextLine();
                
                DocumentType updatedDocumentType = new DocumentType(updateId, updateName);
                documentTypesService.updateDocumentType(updatedDocumentType);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del tipo de documento a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<DocumentType> documentType = documentTypesService.getDocumentTypeById(findId);
                documentType.ifPresentOrElse(
                    dt -> System.out.println("ID: " + dt.getId() + ", Nombre: " + dt.getName()),
                    () -> System.out.println("Tipo de documento no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del tipo de documento a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                documentTypesService.deleteDocumentType(deleteId);
                break;
            
            case 5:
                List<DocumentType> documentTypes = documentTypesService.getAllDocumentTypes();
                documentTypes.forEach(dt -> {
                    System.out.println("ID: " + dt.getId() + ", Nombre: " + dt.getName());
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
