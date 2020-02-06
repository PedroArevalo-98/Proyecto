package proyecto;

/**
 * Definimos la clase libros para poder crearlos  
 * @author almudenaflores
 * @version 6/02/2020
 */
public class libros {
	
	/**
	 * Creamos las variables de los libros
	 */
	private String autor;
	private String titulo;
	private String id= null;
	private boolean disponible=true;
	
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Creamos constructor por defecto
	 */
	libros() {
		
	}
	/**
	 * Creamos el constructor con las variables
	 * @param titulo 
	 * @param autor
	 * @param id
	 * @param disponible
	 */
	
	public libros(String titulo, String autor, String id,boolean disponible) {
		this.autor = autor;
		this.titulo = titulo;
		this.id = id;
		this.disponible=disponible;
	}
	
	/**
	 * getters and setters
	 * @return devuelve el atributo
	 */

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
