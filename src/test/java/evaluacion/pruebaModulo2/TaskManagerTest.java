package evaluacion.pruebaModulo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import evaluacion.pruebaModulo2.model.Task;
import evaluacion.pruebaModulo2.model.TaskManager;

public class TaskManagerTest {
	
	private TaskManager taskManager;
	
	// Este método se ejecuta antes de cada prueba para inicializar el administrador de tareas.
    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }
    
    // Prueba para verificar que se puede agregar una tarea correctamente.
    @Test
    void testAddTask() {
        Task task = new Task("Test Task", "Esta es una prueba", Task.Priority.ALTA, Task.Status.PENDIENTE);
        taskManager.addTask(task);

        List<Task> tasks = taskManager.listTasksByPriority();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }
    
    // Prueba para verificar que se puede editar una tarea existente.
    @Test
    void testEditTask() {
        Task task = new Task("Tarea Original", "Descripción Original", Task.Priority.MEDIA, Task.Status.PENDIENTE);
        taskManager.addTask(task);
        
        // Se Edita la tarea y se verifican los cambios.
        taskManager.editTask(task.getId(), "Tarea Actualizada", "Descripción Actualizada", Task.Priority.ALTA, Task.Status.EN_PROGRESO);
        Task updatedTask = taskManager.filterTasksByStatus(Task.Status.EN_PROGRESO).get(0);

        assertEquals("Tarea Actualizada", updatedTask.getTitle());
        assertEquals(Task.Priority.ALTA, updatedTask.getPriority());
        assertEquals(Task.Status.EN_PROGRESO, updatedTask.getStatus());
    }
    
    // Prueba para verificar que se puede eliminar una tarea correctamente. 
    @Test
    void testDeleteTask() {
        Task task = new Task("Tarea a Eliminar", "Descripción", Task.Priority.BAJA, Task.Status.PENDIENTE);
        taskManager.addTask(task);
        
        // Se elimina la tarea y se verifica que ya no existe.
        taskManager.deleteTask(task.getId());
        List<Task> tasks = taskManager.listTasksByPriority();

        assertTrue(tasks.isEmpty());
    }
    
    // Prueba para verificar que las tareas se listan en orden de prioridad.
    @Test
    void testListTasksByPriority() {
        Task highPriorityTask = new Task("Tarea Alta Prioridad", "Descripción", Task.Priority.ALTA, Task.Status.PENDIENTE);
        Task lowPriorityTask = new Task("Tarea Baja Prioridad", "Descripción", Task.Priority.BAJA, Task.Status.PENDIENTE);
        
        // Se Agregan las tareas en orden invertido.
        taskManager.addTask(lowPriorityTask);
        taskManager.addTask(highPriorityTask);
        
        // Se Verifica que se listen en orden de prioridad (ALTA primero).
        List<Task> tasks = taskManager.listTasksByPriority();
        assertEquals(Task.Priority.ALTA, tasks.get(0).getPriority());
        assertEquals(Task.Priority.BAJA, tasks.get(1).getPriority());
    }
    
    // Prueba para verificar que se pueden buscar tareas por palabra clave.
    @Test
    void testSearchTasks() {
        Task task = new Task("Tarea Buscada", "Contiene una palabra clave", Task.Priority.MEDIA, Task.Status.PENDIENTE);
        taskManager.addTask(task);
        
        // Se Buscan las tareas que contengan la palabra "clave".
        List<Task> results = taskManager.searchTasks("clave");
        assertEquals(1, results.size());
        assertEquals("Tarea Buscada", results.get(0).getTitle());
    }
    
    // Prueba para verificar que se pueden filtrar tareas por estado.
    @Test
    void testFilterTasksByStatus() {
        Task pendingTask = new Task("Tarea Pendiente", "Descripción", Task.Priority.BAJA, Task.Status.PENDIENTE);
        Task completedTask = new Task("Tarea Completada", "Descripción", Task.Priority.ALTA, Task.Status.COMPLETADA);
        
        // Se agregan las tareas con diferentes estados.
        taskManager.addTask(pendingTask);
        taskManager.addTask(completedTask);
        
        // Se filtran las tareas que están en estado COMPLETADA.
        List<Task> completedTasks = taskManager.filterTasksByStatus(Task.Status.COMPLETADA);
        assertEquals(1, completedTasks.size());
        assertEquals("Tarea Completada", completedTasks.get(0).getTitle());
    }
	
}
