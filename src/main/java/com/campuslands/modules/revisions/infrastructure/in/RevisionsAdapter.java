package com.campuslands.modules.revisions.infrastructure.in;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.revisions.application.RevisionsService;
import com.campuslands.modules.revisions.domain.models.Revisions;

public class RevisionsAdapter {

    private final RevisionsService revisionsService;

    public RevisionsAdapter(RevisionsService revisionsService) {
        this.revisionsService = revisionsService;
    }

    public void start(int rol) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
         
            System.out.println("Menú de Gestión de Revisiones");
            System.out.println("1. Registrar Revisión");
            System.out.println("2. Actualizar Revisión");
            System.out.println("3. Buscar Revisión por ID");
            System.out.println("4. Eliminar Revisión");
            System.out.println("5. Listar todas las Revisiones");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                if (rol !=1 || rol!=2){break;}
                    System.out.print("Ingrese el ID de la revisión: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la fecha de la revisión (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();

                    System.out.print("Ingrese el ID del avión: ");
                    int idPlane = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Revisions newRevision = new Revisions(id, dateStr, idPlane);
                    revisionsService.createRevision(newRevision);
                    System.out.println("Revisión registrada correctamente.");
                    break;

                case 2:
                if (rol !=1 || rol!=2){break;}
                    System.out.print("Ingrese el ID de la revisión a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la nueva fecha de la revisión (YYYY-MM-DD): ");
                    String updateDateStr = scanner.nextLine();

                    System.out.print("Ingrese el nuevo ID del avión: ");
                    int updateIdPlane = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Revisions revisionToUpdate = new Revisions(updateId, updateDateStr, updateIdPlane);
                    revisionsService.updateRevision(revisionToUpdate);
                    System.out.println("Revisión actualizada correctamente.");
                    break;

                case 3:
                if (rol !=1 || rol!=2){break;}
                    System.out.print("Ingrese el ID de la revisión a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Optional<Revisions> revision = revisionsService.getRevisionById(findId);
                    revision.ifPresentOrElse(
                            rev -> System.out.println("ID: " + rev.getId() + ", Fecha: "
                                    + dateFormat.format(rev.getRevision_date()) + ", ID Avión: " + rev.getId_plane()),
                            () -> System.out.println("Revisión no encontrada"));
                    break;

                case 4:
                if (rol !=1 || rol!=2){break;}
                    System.out.print("Ingrese el ID de la revisión a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    revisionsService.deleteRevision(deleteId);
                    System.out.println("Revisión eliminada correctamente.");
                    break;

                case 5:
                if (rol !=1 || rol!=2){break;}
                    List<Revisions> allRevisions = revisionsService.getAllRevisions();
                    allRevisions.forEach(rev -> {
                        System.out.println("ID: " + rev.getId() + ", Fecha: "
                                + dateFormat.format(rev.getRevision_date()) + ", ID Avión: " + rev.getId_plane());
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
