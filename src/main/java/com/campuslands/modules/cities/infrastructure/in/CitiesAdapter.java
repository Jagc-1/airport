package com.campuslands.modules.cities.infrastructure.in;
import com.campuslands.modules.cities.application.CitiesService;
import com.campuslands.modules.cities.domain.models.Cities;

import java.util.Scanner;
import java.util.List;
import java.util.Optional;


public class CitiesAdapter {
    private final CitiesService citiesService;

    public CitiesAdapter(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

     public void start() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Ciudades");
        System.out.println("1. Crear Ciudad");
        System.out.println("2. Actualizar Ciudad");
        System.out.println("3. Buscar Ciudad por ID");
        System.out.println("4. Eliminar Ciudad");
        System.out.println("5. Listar todas las Ciudades");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opción: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese el nombre de la ciudad: ");
                String createName = scanner.nextLine();
                System.out.print("Ingrese el ID del país de la ciudad: ");
                int createCountryId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                // Generar un ID único (puede ser automático o solicitado)
                System.out.print("Ingrese el ID de la ciudad: ");
                int createId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Cities newCity = new Cities(createId, createName, createCountryId);
                citiesService.createCities(newCity);
                break;
            
            case 2:
                System.out.print("Ingrese el ID de la ciudad a actualizar: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Ingrese el nuevo nombre de la ciudad: ");
                String updateName = scanner.nextLine();
                System.out.print("Ingrese el nuevo ID del país de la ciudad: ");
                int updateCountryId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Cities updatedCity = new Cities(updateId, updateName, updateCountryId);
                citiesService.updateCities(updatedCity);;
                break;
            
            case 3:
                System.out.print("Ingrese el ID de la ciudad a buscar: ");
                int findId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Optional<Cities> city = citiesService.getCityById(findId);
                city.ifPresentOrElse(
                    c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", ID País: " + c.getIdCountry()),
                    () -> System.out.println("Ciudad no encontrada"));
                break;
            
            case 4:
                System.out.print("Ingrese el ID de la ciudad a eliminar: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                citiesService.deleteCities(deleteId);;
                break;
            
            case 5:
                List<Cities> cities = citiesService.getAllCities();
                cities.forEach(c -> {
                    System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", ID País: " + c.getIdCountry());
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
