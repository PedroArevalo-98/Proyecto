package proyecto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Prestamo {
	private LocalDateTime fechaSalida;
    private LocalDateTime fechaDevolucion;
    private double idUsuario; 
    private double codigoLibro;
    
    private ArrayList<String> codigosLibrosPrestados; 
    
    public Prestamo(double d, double codigoLibro, LocalDateTime fecha){
        this.idUsuario = d;
        this.fechaSalida=fecha;
        this.codigoLibro=codigoLibro;
        this.fechaDevolucion = fecha.plus(30, ChronoUnit.DAYS);
        this.codigosLibrosPrestados = new ArrayList();
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

    
    public void addLibro(String codigoLibro){
        codigosLibrosPrestados.add(codigoLibro);
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

	public ArrayList<String> getCodigosLibrosPrestados() {
		return codigosLibrosPrestados;
	}

	public void setCodigosLibrosPrestados(ArrayList<String> codigosLibrosPrestados) {
		this.codigosLibrosPrestados = codigosLibrosPrestados;
	}
	public void mostrarPrestamo() {
		System.out.println(" fecha de prestamo "+fechaSalida +" fecha de devolucion " +fechaDevolucion +" carnet de socio poseedor del libro " +idUsuario +" codigo del libro "+codigoLibro);
	}
    
}

