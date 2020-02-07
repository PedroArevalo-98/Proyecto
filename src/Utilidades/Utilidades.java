package utilidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import proyecto.Prestamo;
import proyecto.libros;
import proyecto.socio;

public class Utilidades {
	
	//referencias esteticas para no tener que crearlas en cada mï¿½todo
			static Scanner En = new Scanner (System.in);
			public ArrayList<libros> ListaLibros = new ArrayList<>();
			public ArrayList<socio> ListaSocios = new ArrayList <>();
			public ArrayList<Prestamo> ListaPrestamos= new ArrayList<>();
			
			
			
		
		//atender peticion, la variable que da acceso al usuario sobre el libro puede ser el id de usuario, si este es null significa que el libro
				//no esta prestado / tambien puede ser un valor el cual toma un numero determinado cuando el libro es prestado
				
				public void atenderPeticion(double carnetSocio, String Titulo) {
				
				
				
				boolean bandera=false;
				boolean bandera2=false;
				boolean bandera3=false;
				int i=0;
				
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
					}*/
						}
				
				
				public void devolverLibro(double carnetSocio, String Titulo) {
					boolean bandera=false;
					boolean bandera2=false;
					boolean bandera3=false;
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
				 * MÃ©todo para recoger los datos de un socio nuevo
				 */
				public void aniadirSocio() {
					System.out.println("--CREAR NUEVO SOCIO--");
					System.out.println("Introduzca el nombre");
					String nombre=En.nextLine();
					
					System.out.println("Se le ha asignado un numero de carnet");
					int numero=(int)(Math.random()*1000+1);
					for (int i = 0; i < ListaSocios.size(); i++) {
						socio S = ListaSocios.get(i);
						while (S.getCarnet()==numero) {
							numero=(int) Math.floor(Math.random()*99999+11111);

						}
					}
					ListaSocios.add(new socio(nombre, numero));
					
				}
				
				public void aniadirLibro() {
					System.out.println("--CREAR NUEVO LIBRO--");
					System.out.println("Introduzca el tÃ­tulo");
					String titulo=En.nextLine();
					En.nextLine();
					System.out.println("Introduzca el autor");
					
					String autor=En.nextLine();
					En.nextLine();
					
					
					System.out.println("Se le ha asignado un ID al libro");
					double id=Math.floor(Math.random()*99999+11111);
					for (int i = 0; i < ListaLibros.size(); i++) {
						libros L = ListaLibros.get(i);
						while (L.getId()==id) {
							id=Math.floor(Math.random()*99999+11111);

						}
					}
					ListaLibros.add(new libros(titulo, autor, id, true));
					
				}
				
				public void borrarSocio() {
					
					for (int i = 0; i < ListaSocios.size(); i++) {
						System.out.println("Introduzca el numero de carnet del socio que quiera borrar");
						double borrar=En.nextDouble();
						socio s=ListaSocios.get(i);
						
						if(s.getCarnet()==(borrar)) {
							System.out.println("ESTAS A PUNTO DE BORRAR EL USUARIO: "+s.getNombre()+" ¿ESTAS SEGURO? (Si/No)");
							String sino=En.next();
							String comprobar ="Si";
							if(sino.equals(comprobar)) {
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
				
				public void listarSocios() {
					if (ListaSocios.isEmpty()) {
						System.out.println("La biblioteca no tiene usuarios");
					} else {
						for (int i = 0; i < ListaSocios.size(); i++) {
							socio s = ListaSocios.get(i);
							s.mostrarelementos();
						}
						System.out.println("");
					
					}
				}
				
				public void listarLibros() {
					if (ListaLibros.isEmpty()) {
						System.out.println("La biblioteca no tiene libros");
					} else {
						for (int i = 0; i < ListaLibros.size(); i++) {
							libros L = ListaLibros.get(i);
							System.out.printf("%s, %s, (%s), %b \n",L.getTitulo(), L.getAutor(), L.getId(), L.isDisponible() );
							
						}
						System.out.println("");
					}
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
					 for (int i = 0; i < ListaPrestamos.size(); i++) {
						 Prestamo prestamo = ListaPrestamos.get(i);
						prestamo.mostrarPrestamo();
					}
					}
					           
				}
				
				
}
