package proyecto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import usoarraylist.Persona;

public class biblioteca {

	
	//referencias esteticas para no tener que crearlas en cada m�todo
	static Scanner En;
	static ArrayList<libros> ListaLibros = new ArrayList<>();
	static ArrayList<socio> ListaSocios = new ArrayList <>();
	static ArrayList<Prestamo> ListaPrestamos= new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		En =new Scanner(System.in);
		do {
			// Al inicio de cada iteración mostramos el menú, y recogemos la opción
			menu();
			opcion = En.nextInt();
			switch (opcion) {
			case 1:
				añadirSocio();
				break;
			case 2:
				añadirLibro();
				break;
			case 3:
				System.out.println("Introduzca su carnet de socio");
				String pedir=En.next();
				System.out.println("Introduzca el titulo del libro que desea pedir");
				String pedir2=En.next();
				atenderPeticion(pedir, pedir2);
				break;
			case 4:
				//devolverLibro();
				break;
				
			case 5: 
				borrarSocio();
				break;
			case 6:
				listarSocios();
				break;
			case 7:
				listarLibros();
				break;
				
			default:
				System.out.println("Opci�n no v�lida. Introduzca una opci�n v�lida, por favor.");
			}

		} while (opcion != 0);

		En.close();

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
							System.out.println(" El libro "+L.getTitulo() +" est� ahora siendo prestado al usuario "+S.getNombre()+" cuyo codigo es "+S.getCarnet());
							LocalDateTime fecha = LocalDateTime.now();
							 Prestamo prestamo = new Prestamo(S.getCarnet(),L.getId(),fecha);
							 S.addLibro(L.getId());
							 
						}
					}
				}else if (L.isDisponible()==false) {
					for (int j = 0; j < ListaSocios.size(); j++) {
						socio S = ListaSocios.get(j);
						if (S.getCarnet().toLowerCase().equals(L.getId())) {
							System.out.println(" El libro "+L.getTitulo() +" ya est� siendo prestado al usuario "+S.getNombre()+" cuyo codigo es " +S.getCarnet());
						}
				}
				
			}else if(L.getTitulo()==null) {
				System.out.println("El libro no existe en la biblioteca");
			}
	}
}
}
	public static void devolverLibro(String carnetSocio, String Titulo) {
		
		 for(int i=0; i<ListaLibros.size(); i++){
	            libros L=ListaLibros.get(i);
	            if(L.getTitulo() == Titulo){
	            	String codigoLibro=L.getId();
	            	if(L.isDisponible()==false){
	            		for (int j = 0; j < ListaSocios.size(); j++) {
							socio S = ListaSocios.get(j);
							if (S.getCarnet()==carnetSocio) {
								if(S.buscarLibro(codigoLibro)) {
									S.quitarLibro(codigoLibro);
									L.setDisponible(true);
								for (int k = 0; k < ListaPrestamos.size(); k++) {
									Prestamo p = ListaPrestamos.get(k);
									if(p.buscarPrestamo(codigoLibro)) {
										LocalDateTime fecha = LocalDateTime.now();
										p.setFechaDevolucion(fecha);
									
									}
								}
								}
							}
	            			 
                
            }
        }
	            }
       
    
	}
}
	/*
	 * Método para recoger los datos de un socio nuevo
	 */
	public static void añadirSocio() {
		System.out.println("--AÑADIR NUEVO SOCIO--");
		System.out.println("Introduzca el nombre");
		String nombre=En.next();
		System.out.println("Introduzca el numero de carnet");
		String carnet=En.next();
		ListaSocios.add(new socio(nombre, carnet));
		
	}
	
	public static void añadirLibro() {
		System.out.println("--AÑADIR NUEVO LIBRO--");
		System.out.println("Introduzca el título");
		String titulo=En.next();
		En.nextLine();
		System.out.println("Introduzca el autor");
		String autor=En.next();
		System.out.println("Introduzca el ID del libro");
		String id=En.next();
		ListaLibros.add(new libros(titulo, autor, id, true));
	}
	
	public static void borrarSocio() {
		
		for (int i = 0; i < ListaSocios.size(); i++) {
			System.out.println("Introduzca el numero de carnet del socio que quiera borrar");
			String borrar=En.next();
			socio s=ListaSocios.get(i);
			if(s.getCarnet().equalsIgnoreCase(borrar)) {
				System.out.println("ESTÁ A PUNTO DE BORRAR EL USUARIO: "+s.getNombre()+" ¿ESTÁ SEGURO? (S/N)");
				String sino=En.next();
				String comprobar ="Si";
				if(sino.equals(comprobar)) {
					for(int j=0; j<s.getPrestamo().size(); j++){
						String a = s.getPrestamo().get(j);
			            for (int j2 = 0; j2 < ListaLibros.size(); j2++) {
							libros L = ListaLibros.get(j2);
							if (a.equals(L)) {
								L.setDisponible(true);
								String codigoLibro=L.getId();
				            	if(L.isDisponible()==false){
				            		for (int l = 0; l < ListaSocios.size(); l++) {
										socio S = ListaSocios.get(l);
										if (S.getCarnet()==borrar) {
											if(S.buscarLibro(codigoLibro)) {
												S.quitarLibro(codigoLibro);
												L.setDisponible(true);
											for (int k = 0; k < ListaPrestamos.size(); k++) {
												Prestamo p = ListaPrestamos.get(k);
												if(p.buscarPrestamo(codigoLibro)) {
													LocalDateTime fecha = LocalDateTime.now();
													p.setFechaDevolucion(fecha);
												}
											}
											}
										}
				            		}
				            	}
							}
			            }
					}
					ListaSocios.remove(i);
					System.out.println("Usuario borrado");
					
				}else {
					System.out.println("error al borrar");
				}
				
			}else {
				System.out.println("NO EXISTE EL USUARIO");
			}
		}
	}
	
	
	public static void menu() {
		System.out.println("--BIBLIOTECA--");
		System.out.println("===================");
		System.out.println("1. Añadir socio");
		System.out.println("2. Añadir libro");
		System.out.println("3. Solicitar libro");
		System.out.println("4. Devolver libro");
		System.out.println("5. Eliminar socio");
		System.out.println("6. Listar socios");
		System.out.println("7. Listar libros");
		System.out.println("0. Salir del programa\n\n");
		System.out.print("Introduzca una opción: ");

	}
	
	public static void listarSocios() {
		if (ListaSocios.isEmpty()) {
			System.out.println("La biblioteca no tiene usuarios");
		} else {
			for (int i = 0; i < ListaSocios.size(); i++) {
				socio s = ListaSocios.get(i);
				System.out.printf("%s (%s) %n", s.getNombre(), s.getCarnet());
			}
			System.out.println("");
		}
	}
	
	public static void listarLibros() {
		if (ListaLibros.isEmpty()) {
			System.out.println("");
		} else {
			for (int i = 0; i < ListaLibros.size(); i++) {
				libros L = ListaLibros.get(i);
				System.out.printf("%s, %s, (%s), %b \n",L.getTitulo(), L.getAutor(), L.getId(), L.isDisponible() );
			}
			System.out.println("");
		}
	}
}
	

