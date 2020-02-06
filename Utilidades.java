package utilidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import proyecto.Prestamo;
import proyecto.libros;
import proyecto.socio;
/**
 * Definimos la clase socio para poder crearlos  
 * @author almudenaflores
 * @version 6/02/2020
 */
public class Utilidades {
	
	/**
	 * referencias esteticas para no tener que crearlas en cada mï¿½todo
	 */
			static Scanner En;
			static ArrayList<libros> ListaLibros = new ArrayList<>();
			static ArrayList<socio> ListaSocios = new ArrayList <>();
			static ArrayList<Prestamo> ListaPrestamos= new ArrayList<>();
		
		/**
		 * atender peticion, la variable que da acceso al usuario sobre el libro puede ser el id de usuario, 
		 * si este es null significa que el libro.
		 * 
		 * no esta prestado / tambien puede ser un valor el cual toma un numero determinado cuando el libro es prestado
		 * @param carnetSocio
		 * @param Titulo
		 */
				
				
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
										System.out.println(" El libro "+L.getTitulo() +" estï¿½ ahora siendo prestado al usuario "+S.getNombre()+" cuyo codigo es "+S.getCarnet());
										LocalDateTime fecha = LocalDateTime.now();
										 Prestamo prestamo = new Prestamo(S.getCarnet(),L.getId(),fecha);
										 S.addLibro(L.getId());
										 
									}
								}
							}else if (L.isDisponible()==false) {
								for (int j = 0; j < ListaSocios.size(); j++) {
									socio S = ListaSocios.get(j);
									if (S.getCarnet().toLowerCase().equals(L.getId())) {
										System.out.println(" El libro "+L.getTitulo() +" ya estï¿½ siendo prestado al usuario "+S.getNombre()+" cuyo codigo es " +S.getCarnet());
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
				/**
				 * Metodo para recoger los datos de un socio nuevo
				 */
				public static void aniadirSocio() {
					System.out.println("--CREAR NUEVO SOCIO--");
					System.out.println("Introduzca el nombre");
					String nombre=En.next();
					System.out.println("Introduzca el numero de carnet");
					String carnet=En.next();
					ListaSocios.add(new socio(nombre, carnet));
					
				}
				
				/**
				 * Metodo para anadir un libro nuevo
				 */
				public static void aniadirLibro() {
					System.out.println("--CREAR NUEVO LIBRO--");
					System.out.println("Introduzca el tÃ­tulo");
					String titulo=En.next();
					En.nextLine();
					System.out.println("Introduzca el autor");
					String autor=En.next();
					System.out.println("Introduzca el ID del libro");
					String id=En.next();
					ListaLibros.add(new libros(titulo, autor, id, true));
				}
				
				
				/**
				 * Metodo para borrar un socio existente
				 */
				public static void borrarSocio() {
					
					for (int i = 0; i < ListaSocios.size(); i++) {
						System.out.println("Introduzca el numero de carnet del socio que quiera borrar");
						String borrar=En.next();
						socio s=ListaSocios.get(i);
						if(s.getCarnet().equalsIgnoreCase(borrar)) {
							System.out.println("ESTAS A PUNTO DE BORRAR EL USUARIO: "+s.getNombre()+" ¿ESTAS SEGURO? (S/N)");
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
				
				/**
				 * Menu de la biblioteca
				 */
				public static void menu() {
					System.out.println("--BIBLIOTECA--");
					System.out.println("===================");
					System.out.println("1. Anadir socio");
					System.out.println("2. Anadir libro");
					System.out.println("3. Solicitar libro");
					System.out.println("4. Devolver libro");
					System.out.println("5. Eliminar socio");
					System.out.println("6. Listar socios");
					System.out.println("7. Listar libros");
					System.out.println("0. Salir del programa\n\n");
					System.out.print("Introduzca una opciÃ³n: ");

				}
				
				
				/**
				 * Metodo para listar los socios que estan creados hasta ese momento
				 */
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
				
				/**
				 * Metodo para listar los socios que estan creados hasta ese momento
				 */
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
