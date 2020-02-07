package proyecto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Utilidades;
import utilidades.*;

/**
 * Definimos la biblioteca en donde ya hay creados unos cuantos libros  
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
		/**
		 * libros ya disponibles en la biblioteca
		 */
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
		
		/**
		 * Menu de la biblioteca
		 */
		
		do {
			// Al inicio de cada iteracionn mostramos el menu, y recogemos la opcion
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
				System.out.println("Introduzca su carnet de socio");
				double pedir=Excepcion.controlaDouble();
				System.out.println("Introduzca el titulo del libro que desea pedir");
				String pedir2=En.nextLine();
				Utilidades.atenderPeticion(pedir, pedir2);
				break;
			case 4:
				System.out.println("Introduzca su carnet de socio");
				double pedir3=Excepcion.controlaDouble();
				System.out.println("Introduzca el titulo del libro que va a devolver");
				String pedir4=En.nextLine();
				
				Utilidades.devolverLibro(pedir3, pedir4);
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




		
