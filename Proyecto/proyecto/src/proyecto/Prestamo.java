package proyecto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Prestamo {
	private LocalDateTime fechaSalida;
    private LocalDateTime fechaDevolucion;
    private double idUsuario; 
    private double codigoLibro;
    
    
    
    public Prestamo(double d, double codigoLibro, LocalDateTime fecha){
        this.idUsuario = d;
        this.fechaSalida=fecha;
        this.codigoLibro=codigoLibro;
        this.fechaDevolucion = null;
       
    }

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

    
   
    
    public void devolverLibro(){
    }
    
    public void multa(){
    }
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

