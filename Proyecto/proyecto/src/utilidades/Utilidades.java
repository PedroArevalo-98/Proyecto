package utilidades;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import proyecto.Prestamo;
import proyecto.libros;
import proyecto.socio;
import java.util.*;
/**
 * Definimos la clase socio para poder crearlos  
 * @author almudenaflores
 * @version 6/02/2020
 */
public class Utilidades {
	
/**
	 * referencias esteticas para no tener que crearlas en cada metodo
	 */
			static Scanner En = new Scanner (System.in);
			public ArrayList<libros> ListaLibros = new ArrayList<>();
			public ArrayList<socio> ListaSocios = new ArrayList <>();
			public ArrayList<Prestamo> ListaPrestamos= new ArrayList<>();
			Excepciones Excepcion = new Excepciones();
			
			
			
		
		/**
		 * atender peticion, la variable que da acceso al usuario sobre el libro puede ser el id de usuario, 
		 * si este es null significa que el libro.
		 * 
		 * no esta prestado / tambien puede ser un valor el cual toma un numero determinado cuando el libro es prestado
		 * @param carnetSocio
		 * @param Titulo
		 */
			public void atenderPeticion() throws IOException {
				boolean pedir=true;
				//double  carnetSocio=10;
				double idlibro;
				boolean confirmar;
				double carnetSoci;
				do {
					 System.out.println("Introduzca su carnet de socio");
						double carnetSocio=Excepcion.controlaDouble();

				 pedir=ListaSocios.stream().anyMatch(S-> S.getCarnet()==(carnetSocio));
				 String mensaje = (pedir)? "usuario aceptado" : "ERROR, el usuario no existe";
				 System.out.println(mensaje);
				 System.out.println("");
				 confirmar=pedir;
				 carnetSoci=carnetSocio;
				}while(confirmar==false);
				
				if(pedir){
					double carnetSocio3=carnetSoci;
					System.out.println("Introduzca el titulo del libro que desea pedir");
					String Titulo=En.nextLine();
				boolean pedir2= ListaLibros.stream().anyMatch(L->L.getTitulo().equalsIgnoreCase(Titulo));
				String mensaje2= (pedir2)? "Libro aceptado" : "Error, el libro no existe";
				System.out.println(mensaje2);
				System.out.println("");
				if (pedir2==true) {
					if(ListaLibros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(Titulo)).anyMatch(l->l.isDisponible()==true)) {
						ListaLibros.stream().filter(l ->l.getTitulo().equalsIgnoreCase(Titulo)).forEach((l) ->{ l.setDisponible(false); } );
					double id=	(ListaLibros.stream().filter(l ->l.getTitulo().equalsIgnoreCase(Titulo)).findFirst().get()).getId();
					//	ListaSocios.stream().filter(s ->s.getCarnet()==(carnet)).forEach(s->s.addLibro(ListaLibros.stream().anyMatch(L-> L.getTitulo().equalsIgnoreCase(Titulo)).forEach((l) -> l.getId())));
						System.out.println("El libro "+Titulo+ "se ha reservado para el socio"+carnetSoci);
						ListaSocios.stream().filter(s -> s.getCarnet()==carnetSocio3).forEach(l -> l.addLibro(id));
						LocalDateTime fecha = LocalDateTime.now();
						 ListaPrestamos.add(new Prestamo(carnetSocio3,id,fecha));
						
					
					}else  {
						System.out.println("El libro ya está prestado");
					}
				}
				
			}
				
				
			
			}
			
				
			
			
			/*	public void atenderPeticion() {
				
				
				
				boolean bandera=false;
				boolean bandera2=false;
				boolean bandera3=false;
				int i=0;
				
				System.out.println("Introduzca su carnet de socio");
				double carnetSocio=Excepcion.controlaDouble();
				System.out.println("Introduzca el titulo del libro que desea pedir");
				String Titulo=En.nextLine();
				
					for ( i = 0; i < ListaLibros.size(); i++) {
						libros L = ListaLibros.get(i);
						
						if (L.getTitulo().equalsIgnoreCase(Titulo) ) {
							
						bandera=true;
							if (L.isDisponible()==true) {
								
								
								for (int j = 0; j < ListaSocios.size(); j++) {
									socio S = ListaSocios.get(j);
									if (S.getCarnet()==carnetSocio) {
										
										bandera2=true;
										L.setDisponible(false);
										System.out.println(" El libro "+L.getTitulo() +" está ahora siendo prestado al usuario "+S.getNombre()+" cuyo codigo es "+S.getCarnet());
										LocalDateTime fecha = LocalDateTime.now();
										 ListaPrestamos.add(new Prestamo(S.getCarnet(),L.getId(),fecha));
										 S.addLibro(L.getId());
										 bandera=true;
										 break;
										 
										
										 
									}
								}
							}else if (L.isDisponible()==false) {
								bandera2=true;
								for (int j = 0; j < ListaSocios.size(); j++) {
									socio S = ListaSocios.get(j);
									if (S.buscarLibro((L.getId()))) {
										System.out.println(" El libro "+L.getTitulo() +" ya está siendo prestado al usuario "+S.getNombre()+" cuyo codigo es " +S.getCarnet());
									}
							}
							
						
				}
			}
						
						
					}if(bandera==false) {
						System.out.println("El libro no esta en la biblioteca");
					}if (bandera2==false) {
						System.out.println("Carnet de socio incorrecto");
					}/*if (bandera3==false) {
						System.out.println();
					}
						}*/
				
				/**
	*Metodo para devolver un libro, en donde se pide el carnet de socio y el titulo que se quiere devolver
	*/
			
				public void devolverLibro() throws IOException {
					double carnetSoci;
					boolean pedir;
					do {
					 System.out.println("Introduzca su carnet de socio");
						double carnetSocio=Excepcion.controlaDouble();
						double carnet = carnetSocio;
						
						 pedir=ListaSocios.stream().anyMatch(S-> S.getCarnet()==(carnetSocio));
						 String mensaje = (pedir)? "usuario aceptado" : "ERROR, el usuario no existe";
						 System.out.println(mensaje);
						 System.out.println("");
						 carnetSoci=carnetSocio;
						} while (pedir != true);
					
					System.out.println("Introduzca el titulo del libro que desea devolver");
					String Titulo=En.nextLine();
					boolean pedir2= ListaLibros.stream().anyMatch(L->L.getTitulo().equalsIgnoreCase(Titulo));
					String mensaje2= (pedir2)? "Libro aceptado" : "Error, el libro no existe";
					System.out.println(mensaje2);
					System.out.println("");
					if (pedir2==true) {
						double carnetSocio3=carnetSoci;
						if(ListaLibros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(Titulo)).anyMatch(l->l.isDisponible()==false)) {
							ListaLibros.stream().filter(l ->l.getTitulo().equalsIgnoreCase(Titulo)).forEach((l) -> l.setDisponible(true)    );
							double id=	(ListaLibros.stream().filter(l ->l.getTitulo().equalsIgnoreCase(Titulo)).findFirst().get()).getId();
							System.out.println("El libro "+Titulo+ " se ha devuelto a la biblioteca por el usuario"+carnetSoci);
							ListaSocios.stream().filter(s -> s.getCarnet()==carnetSocio3).forEach(l -> l.quitarLibro(id));
							LocalDateTime fecha = LocalDateTime.now();
							ListaPrestamos.stream().filter(p-> p.getIdUsuario()==carnetSocio3 && p.getCodigoLibro()==id).forEach(p -> p.setFechaDevolucion(fecha));
							
							
							
							
							
						}else {
							System.out.println("El libro no esta prestado");
						}
					}
							
				}
				
					
				
			/*	public void devolverLibro() throws IOException {
					boolean bandera=false;
					boolean bandera2=false;
					boolean bandera3=false;
					System.out.println("Introduzca su carnet de socio");
					double carnetSocio=Excepcion.controlaDouble();
					System.out.println("Introduzca el titulo del libro que va a devolver");
					String Titulo =En.nextLine();
					
					 for(int i=0; i<ListaLibros.size(); i++){
				            libros L=ListaLibros.get(i);
				            if(L.getTitulo().equalsIgnoreCase(Titulo)){
				            	
				            	double codigoLibro=L.getId();
				            	if(L.isDisponible()==false){
				            		for (int j = 0; j < ListaSocios.size(); j++) {
										socio S = ListaSocios.get(j);
										if (S.getCarnet()==carnetSocio) {
											bandera=true;
											if(S.buscarLibro(codigoLibro)) {
												bandera2=true;
												S.quitarLibro(codigoLibro);
												L.setDisponible(true);
											for (int k = 0; k < ListaPrestamos.size(); k++) {
												Prestamo p = ListaPrestamos.get(k);
												if(p.buscarPrestamo(codigoLibro)) {
													
													LocalDateTime fecha = LocalDateTime.now();
													p.setFechaDevolucion(fecha);
													System.out.println("Libro devuelto");
													break;
												}
											}
											}else {
												
												
											}
										}else {
											
											
										}
				            		}
				            	}else {
				            		System.out.println("El libro ya está disponible");
				            		break;
				            	}
				            }else {
				            	System.out.println("Libro no está en la biblioteca");
				            }
					 }if (bandera==false) {
						 System.out.println("Socio no encontrado");
					}if (bandera2==false) {
						System.out.println("Libro no encontrado en la lista de prestamos del usuario");
					}
				}
				/*
				 * Metodo para recoger los datos de un socio nuevo
				 */
				public void aniadirSocio() {
					System.out.println("--CREAR NUEVO SOCIO--");
					System.out.println("Introduzca el nombre");
					String nombre=En.nextLine();
					int numero2;
					System.out.println("Se le ha asignado un numero de carnet");
					boolean confnumero;
									do {
					int numero= (int)(Math.random()*1000+1);

			
					confnumero =ListaSocios.stream().anyMatch((s -> s.getCarnet()!=numero));
					numero2=numero;
					}while(confnumero!=true); 
					
					ListaSocios.add(new socio(nombre, numero2));
					/*for (int i = 0; i < ListaSocios.size(); i++) {
						socio S = ListaSocios.get(i);
						while (S.getCarnet()==numero) {
							numero=(int) Math.floor(Math.random()*99999+11111);*/

						
					}
					
					
/**
				 * Metodo para anadir un libro nuevo
				 */
				
				public void aniadirLibro() {
					System.out.println("--CREAR NUEVO LIBRO--");
					System.out.println("Introduzca el tÃ­tulo");
					String titulo=En.nextLine();
					En.nextLine();
					System.out.println("Introduzca el autor");
					
					String autor=En.nextLine();
					En.nextLine();
					
					System.out.println("Se le ha asignado un ID al libro");
					boolean confnumero;
					double id2;
					do {
						double id=Math.floor(Math.random()*99999+11111);
						id2=id;
			
					confnumero =ListaLibros.stream().anyMatch((l ->l.getId()!=id));
					
					}while(confnumero!=true); 
					ListaLibros.add(new libros(titulo, autor, id2, true));
					
					
					
					/*for (int i = 0; i < ListaLibros.size(); i++) {
						libros L = ListaLibros.get(i);
						while (L.getId()==id) {
							id=Math.floor(Math.random()*99999+11111);
							*/

						}
					
					/**
				 * Metodo para borrar un socio existente
				 */
					
				public void borrarSocio() throws IOException {
					boolean pedir;
					double carnet;
					 ArrayList <Double> array;
					do {
						 System.out.println("Introduzca su carnet de socio");
							double carnetSocio=Excepcion.controlaDouble();
							carnet = carnetSocio;
							
							 pedir=ListaSocios.stream().anyMatch(S-> S.getCarnet()==(carnetSocio));
							 String mensaje = (pedir)? "usuario aceptado" : "ERROR, el usuario no existe";
							 System.out.println(mensaje);
							 System.out.println("");
							 double carnetSoci = carnetSocio;
							} while (pedir != true);
					double carnetsocio3=carnet;
					String nombre = ListaSocios.stream().filter(s ->s.getCarnet()==carnetsocio3).findAny().get().getNombre();
					//double id=	(ListaLibros.stream().filter(l ->l.getTitulo().equalsIgnoreCase(Titulo)).findFirst().get()).getId();
					System.out.println("Estas a punto de borrar al usuario: "+nombre+" confirmar?(si/no)");
					String sino=En.next();
					
					String comprobar ="si";
					if(sino.equalsIgnoreCase(comprobar)) {
				      
				       //lista.stream().map(persona -> persona.getViajes()).flatMap(viajes -> viajes.stream())
						//.map(viaje -> viaje.getPais()).distinct().forEach(System.out::println);
				 array=  ListaSocios.stream().map(socio->socio.getPrestamo()).flatMap(p->p.stream()).collect(Collectors.toCollection(ArrayList::new));
				 for (int i = 0; i < array.size(); i++) {
					double numero= array.get(i);
					double carnetsocio4=carnet;
					ListaLibros.stream().filter(l ->l.getId()==numero ).forEach((l) ->{ l.setDisponible(true); } );
					LocalDateTime fecha = LocalDateTime.now();
					ListaPrestamos.stream().filter(p-> p.getIdUsuario()==carnetsocio4 ).forEach(p -> p.setFechaDevolucion(fecha));
					
				}
				System.out.println("usuario eliminado");
				 ListaSocios.removeIf(s->s.getCarnet()==carnetsocio3);
				 }
				
				 /*
				  *  List<Model> models = new ArrayList<>();

        // TODO: First create your model and add to models ArrayList, to prevent NullPointerException for trying this example

        // Print the name from the list....
        for(Model model : models) {
            System.out.println(model.getName());
				  */
						 
						 
						 
				       
					}
					
					
						
				
				
			/*	public void borrarSocio() {
					System.out.println("Introduzca el numero de carnet del socio que quiera borrar");
					double borrar=En.nextDouble();
					for (int i = 0; i < ListaSocios.size(); i++) {
						
						socio s=ListaSocios.get(i);
						System.out.println(borrar);
						System.out.println(s.getCarnet());
						if(s.getCarnet()==(borrar)) {
							System.out.println("ESTAS A PUNTO DE BORRAR EL USUARIO: "+s.getNombre()+" ¿ESTAS SEGURO? (Si/No)");
							String sino=En.next();
							
							String comprobar ="Si";
							if(sino.equalsIgnoreCase(comprobar)) {
								for(int j=0; j<s.getPrestamo().size(); j++){
									Double a = s.getPrestamo().get(j);
						            for (int j2 = 0; j2 < ListaLibros.size(); j2++) {
										libros L = ListaLibros.get(j2);
										if (a.equals(L.getId())) {
											System.out.println("prueba");
											L.setDisponible(true);
											double codigoLibro=(double) L.getId();
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
																break;
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
				*/
				
/**
				 * Menu de la biblioteca
				 */
				public void menu() {
					System.out.println("--BIBLIOTECA--");
					System.out.println("===================");
					System.out.println("1. Añadir socio");
					System.out.println("2. Añadir libro");
					System.out.println("3. Solicitar libro");
					System.out.println("4. Devolver libro");
					System.out.println("5. Eliminar socio");
					System.out.println("6. Listar socios");
					System.out.println("7. Listar libros");
					System.out.println("8. Mirar lista de libros prestados");
					System.out.println("0. Salir del programa\n\n");
					System.out.print("Introduzca una opcion: ");

				}
				
	/**
				 * Metodo para listar los socios que estan creados hasta ese momento
				 */
				public void listarSocios() {
					if (ListaSocios.isEmpty()) {
						System.out.println("La biblioteca no tiene usuarios");
					} else {
						/*for (int i = 0; i < ListaSocios.size(); i++) {
							socio s = ListaSocios.get(i);
							s.mostrarelementos();
							*/
						ListaSocios.stream().forEach(s ->System.out.println( s.toString()));
						}
						System.out.println("");
					
					}
				
				/**
				 * Metodo para listar los socios que estan creados hasta ese momento
				 */
				public void listarLibros() {
					if (ListaLibros.isEmpty()) {
						System.out.println("La biblioteca no tiene libros");
					} else {
						ListaLibros.stream().forEach(l->System.out.println(l.toString()));
						/*for (int i = 0; i < ListaLibros.size(); i++) {
							libros L = ListaLibros.get(i);
							System.out.printf("%s, %s, (%s), %b \n",L.getTitulo(), L.getAutor(), L.getId(), L.isDisponible() );
						*/	
						}
						System.out.println("");
					}
				
				public libros buscarLibroByCodigo(String titulo){
			        libros libro;
			        for(int i=0; i<ListaLibros.size(); i++){
			            libro=ListaLibros.get(i);
			            if(libro.getTitulo() == titulo){
			                return libro;
			            }
			        }
			        return null;
			    }
				public void mostrarPrestamos() {
					
					
					if (ListaPrestamos.isEmpty()) {
						System.out.println("lista de prestamos vacia");
					}
					else {
					 /*for (int i = 0; i < ListaPrestamos.size(); i++) {
						 Prestamo prestamo = ListaPrestamos.get(i);
						prestamo.mostrarPrestamo(); */
						ListaPrestamos.stream().forEach(s -> System.out.println(s.toString()) );
					}
					}
					           
				}
				
				
