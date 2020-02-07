package proyecto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Utilidades;
import utilidades.*;

/**
 * Definimos la clase biblioteca donde esta el main  
 * @author almudenaflores
 * @version 6/02/2020
 */

public class biblioteca {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int opcion;
		Scanner En = new Scanner(System.in);
		Excepciones Excepcion = new Excepciones();
		Utilidades Utilidades = new Utilidades();
		
		Utilidades.ListaLibros.add(new libros("El Quijote", "Cervantes", 1, true));
		Utilidades.ListaLibros.add(new libros("Harry Potter", "J.k.Rowling", 2, true));
		Utilidades.ListaLibros.add(new libros("Perci Jackson", "Rick Riordan", 3, true));
		Utilidades.ListaLibros.add(new libros("La historia unica", "Julian Barnes", 4, true));
		Utilidades.ListaLibros.add(new libros("Maravillas de la mente", "Cervantes", 5, true));
		Utilidades.ListaLibros.add(new libros("Iluminada", "Mary Karr", 6, true));
		Utilidades.ListaLibros.add(new libros("La Frontera", "Don Winslow", 7, true));
		Utilidades.ListaLibros.add(new libros("Cuentos completos", "Mario Levrero", 8, true));
		
		Utilidades.ListaSocios.add(new socio("Pedro",10));
		Utilidades.ListaSocios.add(new socio("Maria",11));
		Utilidades.ListaSocios.add(new socio("Alejandro",12));
		Utilidades.ListaSocios.add(new socio("Marta",13));
		Utilidades.ListaSocios.add(new socio("Antonio",14));
		
		
		do {
			/** 
			*Al inicio de cada iteracionn mostramos el menu, y recogemos la opcion
			*/
			Utilidades.menu();
			opcion = Excepcion.controlaInt();
			switch (opcion) {
			case 1:
				Utilidades.aniadirSocio();
				break;
			case 2:
				Utilidades.aniadirLibro();
				break;
			case 3:
			
				Utilidades.atenderPeticion();
				break;
			case 4:
				
				
				Utilidades.devolverLibro();
				break;
				
			case 5: 
				Utilidades.borrarSocio();
				break;
			case 6:
				Utilidades.listarSocios();
				break;
			case 7:
				Utilidades.listarLibros();
				break;
			case 8:
				Utilidades.mostrarPrestamos();
				break;
				
			default:
				System.out.println("Opcion no valida. Introduzca una opcion valida, por favor.");
			}

		} while (opcion != 0);

		En.close();
	}
}




		
