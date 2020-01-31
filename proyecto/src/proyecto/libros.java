package proyecto;

public class libros {
	
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

	libros() {
	}
	
	libros(String autor, String titulo, String id,boolean disponible) {
		this.autor = autor;
		this.titulo = titulo;
		this.id = id;
		this.disponible=disponible;
	}

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
