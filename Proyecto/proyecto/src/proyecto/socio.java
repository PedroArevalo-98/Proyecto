package proyecto;

import java.util.ArrayList;
import java.util.List;

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
	private int carnet;
	private ArrayList<Double> prestamo;
	

	
	
	public ArrayList<Double> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(ArrayList<Double> prestamo) {
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

	public socio(String nombre, int carnet) {
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

	public double getCarnet() {
		return carnet;
	}

	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}

	/**
	 * Metodo para anadir un libro nuevo
	 * @param codigoLibro
	 */
	 public void addLibro(Double codigoLibro){
	        prestamo.add(codigoLibro);
	    
			 /**
	  * Metodo para buscar un libro
	  * @param codigoLibro
	  * @return true si el libro existe, false si no
	  */
	 public boolean buscarLibro (double codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			double codigo =prestamo.get(i);
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
	 public void quitarLibro (double codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			double codigo =prestamo.get(i);
			if (codigo == codigoLibro) {
				prestamo.remove(i);
			}
		}
		
	 }
	 public void mostrarelementos() {
		 System.out.println(" Usuario: "+nombre +","+ "Id de usuario: "+carnet);
		System.out.println("ids de libros en su poder");
		 prestamo.forEach(
		            elemento -> System.out.print(String.format("%.1f  ", elemento)));
		 			System.out.println(" ");
	 }
	 
		

	@Override
	public String toString() {
		return "socio [nombre=" + nombre + ", carnet=" + carnet + ", prestamo=" + prestamo + "]";
	}
	 
}

