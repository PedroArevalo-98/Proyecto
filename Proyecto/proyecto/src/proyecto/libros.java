package proyecto;

public class libros {
	
	private String autor;
	private String titulo;
	private double id= 0;
	private boolean disponible=true;
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	libros() {
		
	}
	
	public libros(String titulo, String autor, double id,boolean disponible) {
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

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "libros [autor=" + autor + ", titulo=" + titulo + ", id=" + id + ", disponible=" + disponible + "]";
	}
	
	
}
