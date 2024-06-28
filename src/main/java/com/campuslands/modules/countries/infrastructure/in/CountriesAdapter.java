package com.campuslands.modules.countries.infrastructure.in;

import com.campuslands.modules.countries.domain.models.Country;
import com.campuslands.modules.countries.application.CountriesService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CountriesAdapter {
    private final CountriesService countriesService;

    public CountriesAdapter(CountriesService countriesService) {
        this.countriesService = countriesService;
    }


     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Países");
        System.out.println("1. Crear País");
        System.out.println("2. Actualizar País");
        System.out.println("3. Buscar País por ID");
        System.out.println("4. Eliminar País");
        System.out.println("5. Listar todos los Países");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre del país: ");
                String createName = scanner.nextLine();
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID del país: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Country newCountry = new Country(createId, createName);
                countriesService.createCountry(newCountry);
                break;
            
            case 2:
                System.out.print("Ingrese el ID del país a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre del país: ");
                String updateName = scanner.nextLine();
                
                Country updatedCountry = new Country(updateId, updateName);
                countriesService.updateCountry(updatedCountry);
                break;
            
            case 3:
                System.out.print("Ingrese el ID del país a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Country> country = countriesService.getCountryById(findId);
                country.ifPresentOrElse(
                    c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName()),
                    () -> System.out.println("País no encontrado"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID del país a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                countriesService.deleteCountry(deleteId);
                break;
            
            case 5:
                List<Country> countries = countriesService.getAllCountries();
                countries.forEach(c -> {
                    System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
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
