package evaluacion.pruebaModulo2.model;

public class Task {
	 //contador estático que se utiliza para asignar un identificador único a cada tarea creada.
	  private static int counter = 0;
	    private int id;
	    private String title;
	    private String description;
	    private Priority priority;
	    private Status status;
	    
	    //Constructor de la clase Task que inicializa los atributos de la tarea y asigna un ID único automáticamente
	    public Task(String title, String description, Priority priority, Status status) {
	        this.id = ++counter;
	        this.title = title;
	        this.description = description;
	        this.priority = priority;
	        this.status = status;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Priority getPriority() {
	        return priority;
	    }

	    public void setPriority(Priority priority) {
	        this.priority = priority;
	    }

	    public Status getStatus() {
	        return status;
	    }

	    public void setStatus(Status status) {
	        this.status = status;
	    }
	    
	    //Sobrescribe el método toString para proporcionar una representación en texto de la tarea.
	    @Override
	    public String toString() {
	        return String.format("[ID: %d] Titulo: %s, Descripcion: %s, Prioridad: %s, Estatus: %s", 
	                             id, title, description, priority, status);
	    }

	    public enum Priority {
	        ALTA, MEDIA, BAJA
	    }

	    public enum Status {
	    	PENDIENTE, EN_PROGRESO, COMPLETADA
	    }
}
