package proyecto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Prestamo {
	private LocalDateTime fechaSalida;
    private LocalDateTime fechaDevolucion;
    private String idUsuario; 
    private String codigoLibro;
    
    private ArrayList<String> codigosLibrosPrestados; 
    
    public Prestamo(String idUsuario, String codigoLibro, LocalDateTime fecha){
        this.idUsuario = idUsuario;
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

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    
    public void addLibro(String codigoLibro){
        codigosLibrosPrestados.add(codigoLibro);
    }
    
    public void devolverLibro(){
    }
    
    public void multa(){
    }
    public boolean buscarPrestamo (String codigo) {
		
			if (codigoLibro==codigo) {
				return true;
			}
		
		return false;
	 }

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ArrayList<String> getCodigosLibrosPrestados() {
		return codigosLibrosPrestados;
	}

	public void setCodigosLibrosPrestados(ArrayList<String> codigosLibrosPrestados) {
		this.codigosLibrosPrestados = codigosLibrosPrestados;
	}
    
}

