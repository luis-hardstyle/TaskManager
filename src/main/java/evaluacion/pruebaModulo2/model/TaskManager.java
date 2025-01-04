package evaluacion.pruebaModulo2.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
	private List<Task> tasks;
 	
	 
    public TaskManager() {
        this.tasks = new LinkedList<>();
    }
    
    ////Método para agregar una nueva tarea a la lista enlazada de tareas.
    public void addTask(Task task) {
        tasks.add(task);
    }
    
    //Permite editar los detalles de una tarea existente identificada por su ID.
    public void editTask(int id, String title, String description, Task.Priority priority, Task.Status status) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setPriority(priority);
            task.setStatus(status);
        } else {
            System.out.println("Task not found.");
        }
    }
    
    //Elimina una tarea de la lista según su identificador único.
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    //Utiliza programación funcional para ordenar las tareas por prioridad usando Streams.
    public List<Task> listTasksByPriority() {
        return tasks.stream()
                .sorted((t1, t2) -> t1.getPriority().compareTo(t2.getPriority()))
                .collect(Collectors.toList());
    }
    
    //Filtra las tareas según una palabra clave en su título o descripción usando Streams.
    public List<Task> searchTasks(String keyword) {
        return tasks.stream()
                .filter(task -> task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<Task> filterTasksByStatus(Task.Status status) {
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    private Task findTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

}
