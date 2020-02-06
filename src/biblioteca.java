package proyecto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Utilidades;

public class biblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		Scanner En = new Scanner(System.in);
		do {
			// Al inicio de cada iteracionn mostramos el menu, y recogemos la opcion
			Utilidades.menu();
			opcion = En.nextInt();
			switch (opcion) {
			case 1:
				Utilidades.aniadirSocio();
				break;
			case 2:
				Utilidades.aniadirLibro();
				break;
			case 3:
				System.out.println("Introduzca su carnet de socio");
				String pedir=En.next();
				System.out.println("Introduzca el titulo del libro que desea pedir");
				String pedir2=En.next();
				Utilidades.atenderPeticion(pedir, pedir2);
				break;
			case 4:
				//devolverLibro();
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
				
			default:
				System.out.println("Opcion no valida. Introduzca una opcion valida, por favor.");
			}

		} while (opcion != 0);

		En.close();
	}
}




		

