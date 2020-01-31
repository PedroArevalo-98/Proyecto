package proyecto;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class biblioteca {

	
	//referencias esteticas para no tener que crearlas en cada método
	static Scanner En;
	static ArrayList<libros> ListaLibros;
	static ArrayList<socio> ListaSocios;
	static ArrayList<Prestamo> Prestamos;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//atender peticion, la variable que da acceso al usuario sobre el libro puede ser el id de usuario, si este es null significa que el libro
	//no esta prestado / tambien puede ser un valor el cual toma un numero determinado cuando el libro es prestado
	
	public static void atenderPeticion(String carnetSocio, String Titulo) {
	
	carnetSocio=carnetSocio.toLowerCase();
		for (int i = 0; i < ListaLibros.size(); i++) {
			libros L = ListaLibros.get(i);
			
			if (L.getTitulo().toLowerCase().equals(Titulo) ) {
				if (L.isDisponible()==true) {
					L.setDisponible(false);
					L.setId(carnetSocio);
					for (int j = 0; j < ListaSocios.size(); j++) {
						socio S = ListaSocios.get(j);
						if (S.getCarnet().toLowerCase().equals(carnetSocio)) {
							System.out.println(" El libro "+L.getTitulo() +" está ahora siendo prestado al usuario "+S.getNombre()+" cuyo codigo es "+S.getCarnet());
							LocalDateTime fecha = LocalDateTime.now();
							 Prestamo prestamo = new Prestamo(S.getCarnet(),L.getId(),fecha);
							 S.addLibro(L.getId());
						}
					}
				}else if (L.isDisponible()==false) {
					for (int j = 0; j < ListaSocios.size(); j++) {
						socio S = ListaSocios.get(j);
						if (S.getCarnet().toLowerCase().equals(L.getId())) {
							System.out.println(" El libro "+L.getTitulo() +" ya está siendo prestado al usuario "+S.getNombre()+" cuyo codigo es " +S.getCarnet());
						}
				}
				
			}else if(L.getTitulo()==null) {
				System.out.println("El libro no existe en la biblioteca");
			}
	}
}
}
	
}
