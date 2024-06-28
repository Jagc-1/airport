package com.campuslands.modules.models.infrastructure.in;
import com.campuslands.modules.models.domain.models.Models;
import com.campuslands.modules.models.application.ModelsService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ModelsAdapter {

    private final ModelsService modelsService;

    public ModelsAdapter(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Modelos");
        System.out.println("1. Registrar Modelo");
        System.out.println("2. Actualizar Modelo");
        System.out.println("3. Buscar Modelo por ID");
        System.out.println("4. Eliminar Modelo");
        System.out.println("5. Listar todos los Modelos");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del modelo: ");
                String createName = scanner.nextLine();
                System.out.print("Ingrese el ID del fabricante del modelo: ");
                int createManufacturerId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del modelo: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Models newModel = new Models(createId, createName, createManufacturerId);
                modelsService.createModel(newModel);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del modelo a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del modelo: ");
                String updateName = scanner.nextLine();
                System.out.print("Ingrese el nuevo ID del fabricante del modelo: ");
                int updateManufacturerId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Models updatedModel = new Models(updateId, updateName, updateManufacturerId);
                modelsService.updateModel(updatedModel);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del modelo a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Models> model = modelsService.getModelById(findId);
                model.ifPresentOrElse(
                    m -> System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName() + ", ID Fabricante: " + m.getManuFactureId()),
                    () -> System.out.println("Modelo no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del modelo a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                modelsService.deleteModel(deleteId);
                break;
            
            case 5:
                List<Models> models = modelsService.getAllModels();
                models.forEach(m -> {
                    System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName() + ", ID Fabricante: " + m.getManuFactureId());
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
