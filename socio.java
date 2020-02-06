package proyecto;

import java.util.ArrayList;

/**
 * Definimos la clase socio para poder crearlos  
 * @author almudenaflores
 * @version 6/02/2020
 */

public class socio {
	
	/**
	 * Definimos las variables de los socios
	 */
	private String nombre;
	private String carnet;
	private ArrayList<String> prestamo;
	

	public ArrayList<String> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(ArrayList<String> prestamo) {
		this.prestamo = prestamo;
	}
/**
 * Constructor por defecto
 */
	socio() {
	}
	
	/**
	 * Constructor con las variables
	 * @param nombre
	 * @param carnet
	 */
	public socio(String nombre, String carnet) {
		this.nombre = nombre;
		this.carnet = carnet;
		this.prestamo=new ArrayList<>();
	}

	/**
	 * Getters y setters
	 * @return devuelve el atributo
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	/**
	 * Metodo para anadir un libro nuevo
	 * @param codigoLibro
	 */
	 public void addLibro(String codigoLibro){
	        prestamo.add(codigoLibro);
	    }
	 
	 /**
	  * Metodo para buscar un libro
	  * @param codigoLibro
	  * @return true si el libro existe, false si no
	  */
	 public boolean buscarLibro (String codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			String codigo =prestamo.get(i);
			if (codigo==codigoLibro) {
				return true;
			}
		}
		return false;
	 }
	 
	 /**
	  * Metodo para quitar un libro existente
	  * @param codigoLibro
	  */
	 public void quitarLibro (String codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			String codigo =prestamo.get(i);
			if (codigo==codigoLibro) {
				prestamo.remove(i);
			}
		}
		
	 }
}
