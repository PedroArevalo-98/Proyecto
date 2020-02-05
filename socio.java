package proyecto;

import java.util.ArrayList;

public class socio {
	
	private String nombre;
	private String carnet;
	private ArrayList<String> prestamo;
	

	
	
	public ArrayList<String> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(ArrayList<String> prestamo) {
		this.prestamo = prestamo;
	}

	socio() {
	}
	
	socio(String nombre, String carnet) {
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	
	 public void addLibro(String codigoLibro){
	        prestamo.add(codigoLibro);
	    }
	 public boolean buscarLibro (String codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			String codigo =prestamo.get(i);
			if (codigo==codigoLibro) {
				return true;
			}
		}
		return false;
	 }
	 public void quitarLibro (String codigoLibro) {
		 for (int i = 0; i < prestamo.size(); i++) {
			String codigo =prestamo.get(i);
			if (codigo==codigoLibro) {
				prestamo.remove(i);
			}
		}
		
	 }
}
