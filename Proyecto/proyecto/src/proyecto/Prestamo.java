package proyecto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * Definimos la clase Prestamo para poder crearlos  
 * @author almuflores, Pedro Arevalo, jose manuel
 * @version 6/02/2020
 */
/**
 * Definimos las variables
 */
public class Prestamo {
	private LocalDateTime fechaSalida;
    private LocalDateTime fechaDevolucion;
    private double idUsuario; 
    private double codigoLibro;
    
    
    
    /**
     * Creamos el constructor de Prestamos
     */
    public Prestamo(double d, double codigoLibro, LocalDateTime fecha){
        this.idUsuario = d;
        this.fechaSalida=fecha;
        this.codigoLibro=codigoLibro;
        this.fechaDevolucion = null;
       
    }
    /**
     * Getters y setters 
     * @return devuelve el atributo
     */

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(double codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    
   
    
  
    /**
     * Método para buscar un prestamo
     * @param codigo
     * @return falso si esta prestado y true si esta disponible 
     */
    public boolean buscarPrestamo (double codigoLibro2) {
		
			if (codigoLibro==codigoLibro2) {
				return true;
			}
		
		return false;
	 }

	public double getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(double idUsuario) {
		this.idUsuario = idUsuario;
	}

	

	
	public void mostrarPrestamo() {
		System.out.println(" fecha de prestamo "+fechaSalida +" fecha de devolucion " +fechaDevolucion +" carnet de socio poseedor del libro " +idUsuario +" codigo del libro "+codigoLibro);
	}

	@Override
	public String toString() {
		return "Prestamo [fechaSalida=" + fechaSalida + ", fechaDevolucion=" + fechaDevolucion + ", idUsuario="
				+ idUsuario + ", codigoLibro=" + codigoLibro
				+ "]";
	}
	
    
}

