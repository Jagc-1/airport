package com.campuslands.modules.manufacturers.infrastructure.in;

import com.campuslands.modules.manufacturers.domain.models.Manufacturers;
import com.campuslands.modules.manufacturers.application.ManufacturersService;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ManufacturersAdapter {

    private final ManufacturersService manufacturersService;

    public ManufacturersAdapter(ManufacturersService manufacturersService) {
        this.manufacturersService = manufacturersService;
    }


     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Fabricantes");
        System.out.println("1. Registrar Fabricante");
        System.out.println("2. Actualizar Fabricante");
        System.out.println("3. Buscar Fabricante por ID");
        System.out.println("4. Eliminar Fabricante");
        System.out.println("5. Listar todos los Fabricantes");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del fabricante: ");
                String createName = scanner.nextLine();
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del fabricante: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Manufacturers newManufacturer = new Manufacturers(createId, createName);
                manufacturersService.createManufacturer(newManufacturer);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del fabricante a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del fabricante: ");
                String updateName = scanner.nextLine();
                
                Manufacturers updatedManufacturer = new Manufacturers(updateId, updateName);
                manufacturersService.updateManufacturer(updatedManufacturer);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del fabricante a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Manufacturers> manufacturer = manufacturersService.getManufacturerById(findId);
                manufacturer.ifPresentOrElse(
                    m -> System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName()),
                    () -> System.out.println("Fabricante no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del fabricante a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                manufacturersService.deleteManufacturer(deleteId);
                break;
            
            case 5:
                List<Manufacturers> manufacturers = manufacturersService.getAllManufacturers();
                manufacturers.forEach(m -> {
                    System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName());
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
