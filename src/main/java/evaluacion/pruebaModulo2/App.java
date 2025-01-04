package evaluacion.pruebaModulo2;

import java.util.Scanner;

import evaluacion.pruebaModulo2.model.Task;
import evaluacion.pruebaModulo2.model.TaskManager;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("a) Agregar tarea");
            System.out.println("b) Editar tarea");
            System.out.println("c) Eliminar tarea");
            System.out.println("d) Listar tareas");
            System.out.println("e) Buscar tarea");
            System.out.println("f) Salir");
            System.out.print("Elige una opción: ");

            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "a":
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();
                    System.out.print("Prioridad (ALTA, MEDIA, BAJA): ");
                    //Task.Priority priority = Task.Priority.valueOf(scanner.nextLine().toUpperCase());
                    String newPriorityInput = scanner.nextLine().toUpperCase().replace(" ", "_");
                    Task.Priority priority;
                    try {
                    	priority = Task.Priority.valueOf(newPriorityInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Prioridad inválida. Usando prioridad por defecto: BAJA.");
                        priority = Task.Priority.BAJA;
                    } 	
                    
                    System.out.print("Estado (PENDIENTE, EN_PROGRESO, COMPLETADA): ");
                    String statusInput = scanner.nextLine().toUpperCase().replace(" ", "_");
                    Task.Status status;
                    try {
                        status = Task.Status.valueOf(statusInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Estado inválido. Usando estado por defecto: PENDIENTE.");
                        status = Task.Status.PENDIENTE;
                    }
                    
                    taskManager.addTask(new Task(title, description, priority, status));
                    break;
                case "b":
                	  while (true) {
                          try {
                              System.out.print("ID de la tarea a editar (o 'exit' para regresar): ");
                              String editIdInput = scanner.nextLine();
                              if (editIdInput.equalsIgnoreCase("exit")) {
                                  System.out.println("Operación cancelada.");
                                  break;
                              }
                              if (!editIdInput.matches("\\d+")) {
                                  throw new NumberFormatException("El ID debe ser un número válido.");
                              }
                              int editId = Integer.parseInt(editIdInput);
                              Task task = taskManager.listTasksByPriority().stream()
                                      .filter(t -> t.getId() == editId)
                                      .findFirst()
                                      .orElse(null);

                              if (task == null) {
                                  System.out.println("ID no encontrado. Intente nuevamente.");
                                  continue;
                              }

                              System.out.print("Nuevo título: ");
                              String newTitle = scanner.nextLine();
                              System.out.print("Nueva descripción: ");
                              String newDescription = scanner.nextLine();
                              System.out.print("Prioridad (ALTA, MEDIA, BAJA): ");                   
  		                      String priorityInput = scanner.nextLine().toUpperCase().replace(" ", "_");
  		                      Task.Priority newPriority;
                              try {
  		                    	newPriority = Task.Priority.valueOf(priorityInput);
  		                      } catch (IllegalArgumentException e) {
  		                        System.out.println("Prioridad inválida. Usando prioridad por defecto: BAJA.");
  		                        newPriority = Task.Priority.BAJA;
  		                      }
  		                      System.out.print("Estado (PENDIENTE, EN_PROGRESO, COMPLETADA): ");
  		                      String newStatusInput = scanner.nextLine().toUpperCase().replace(" ", "_");
  		                      Task.Status newStatus;
  		                      try {
  		                          newStatus = Task.Status.valueOf(newStatusInput);
  		                      } catch (IllegalArgumentException e) {
  		                          System.out.println("Estado inválido. Usando estado por defecto: PENDIENTE.");
  		                          newStatus = Task.Status.PENDIENTE;
  		                      }
                              taskManager.editTask(editId, newTitle, newDescription, newPriority, newStatus);
                              break;
                          } catch (NumberFormatException e) {
                              System.out.println("El ID debe ser un número válido.");
                          }
                      }
                      break;
                case "c":                 
                    try {
                        System.out.print("ID de la tarea a eliminar: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        taskManager.deleteTask(deleteId);
                        System.out.print("La Tarea ha sido eliminada exitosamente ");
                    } catch (NumberFormatException e) {
                        System.out.println("El ID debe ser un número válido.");
                    }
                case "d":
                    System.out.println("Tareas organizadas por prioridad:");
                    taskManager.listTasksByPriority().forEach(System.out::println);
                    break;
                case "e":
                    System.out.print("Palabra clave para buscar: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Resultados de búsqueda:");
                    taskManager.searchTasks(keyword).forEach(System.out::println);
                    break;
                case "f":
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }

    }
}
