package proyecto;

import java.util.ArrayList;

public class socio {
	
	private String nombre;
	private int carnet;
	private ArrayList<Double> prestamo;
	

	
	
	public ArrayList<Double> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(ArrayList<Double> prestamo) {
		this.prestamo = prestamo;
	}

	socio() {
	}
	
	public socio(String nombre, int carnet) {
		this.nombre = nombre;
		this.carnet = carnet;
		this.prestamo=new ArrayList<>();
	}

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

	
	 public void addLibro(Double codigoLibro){
	        prestamo.add(codigoLibro);
	    }
	 public boolean buscarLibro (double codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			double codigo =prestamo.get(i);
			if (codigo==codigoLibro) {
				return true;
			}
		}
		return false;
	 }
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
}
