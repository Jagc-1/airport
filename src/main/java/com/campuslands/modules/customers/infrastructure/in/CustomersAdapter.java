package com.campuslands.modules.customers.infrastructure.in;

import com.campuslands.modules.customers.domain.models.Customer;
import com.campuslands.modules.customers.application.CustomersService;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomersAdapter {
    private final CustomersService customersService;

    public CustomersAdapter(CustomersService customersService) {
        this.customersService = customersService;
    }

     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Clientes");
        System.out.println("1. Crear Cliente");
        System.out.println("2. Actualizar Cliente");
        System.out.println("3. Buscar Cliente por ID");
        System.out.println("4. Eliminar Cliente");
        System.out.println("5. Listar todos los Clientes");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del cliente: ");
                String createName = scanner.nextLine();
                System.out.print("Ingrese la edad del cliente: ");
                int createAge = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el tipo de documento del cliente (1-Identificación, 2-Pasaporte, 3-Cédula): ");
                int createDocumentType = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el número de documento del cliente: ");
                String createDocumentId = scanner.nextLine();
                System.out.print("Ingrese la contraseña del cliente: ");
                String createPassword = scanner.nextLine();
                System.out.print("Ingrese el correo electrónico del cliente: ");
                String createEmail = scanner.nextLine();
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del cliente: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Customer newCustomer = new Customer(createId, createName, createAge, createDocumentType, createDocumentId, createPassword, createEmail);
                customersService.createCustomer(newCustomer);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del cliente a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del cliente: ");
                String updateName = scanner.nextLine();
                System.out.print("Ingrese la nueva edad del cliente: ");
                int updateAge = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo tipo de documento del cliente (1-Identificación, 2-Pasaporte, 3-Cédula): ");
                int updateDocumentType = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo número de documento del cliente: ");
                String updateDocumentId = scanner.nextLine();
                System.out.print("Ingrese la nueva contraseña del cliente: ");
                String updatePassword = scanner.nextLine();
                System.out.print("Ingrese el nuevo correo electrónico del cliente: ");
                String updateEmail = scanner.nextLine();
                
                Customer updatedCustomer = new Customer(updateId, updateName, updateAge, updateDocumentType, updateDocumentId, updatePassword, updateEmail);
                customersService.updateCustomer(updatedCustomer);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del cliente a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Customer> customer = customersService.getCustomerById(findId);
                customer.ifPresentOrElse(
                    c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", Edad: " + c.getAge() + ", Tipo de Documento: " + c.getId_document_type() + ", Documento: " + c.getId_document() + ", Email: " + c.getEmail()),
                    () -> System.out.println("Cliente no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del cliente a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                customersService.deleteCustomer(deleteId);
                break;
            
            case 5:
                List<Customer> customers = customersService.getAllCustomers();
                customers.forEach(c -> {
                    System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", Edad: " + c.getAge() + ", Tipo de Documento: " + c.getId_document_type() + ", Documento: " + c.getId_document() + ", Email: " + c.getEmail());
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
