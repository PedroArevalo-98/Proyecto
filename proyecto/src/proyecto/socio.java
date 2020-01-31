package proyecto;

import java.util.ArrayList;

public class socio {
	
	private String nombre;
	private String carnet;
	private ArrayList prestamo = new ArrayList();
	
	
	socio() {
	}
	
	socio(String nombre, String carnet, ArrayList prestamo) {
		this.nombre = nombre;
		this.carnet = carnet;
		this.prestamo = prestamo;
	}

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

	public ArrayList getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(ArrayList prestamo) {
		this.prestamo = prestamo;
	}
}
