package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excepciones {
	
	public int controlaInt() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		boolean error = false;

	int entero = 0;
	do {
	try {
	entero = Integer.parseInt(entrada.readLine());
	error = false;
	} catch (NumberFormatException e) {
	// TODO: handle exception
	System.out.println("Valor no válido, introduzcalo de nuevo");
	error = true;
	}
	} while (error);
	return entero;
	}

	public double controlaDouble() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		boolean error = false;

	double entero = 0;
	do {
	try {
	entero = Double.parseDouble(entrada.readLine());
	error = false;
	} catch (NumberFormatException e) {
	// TODO: handle exception
	System.out.println("Valor no válido, vuelva a introducirlo");
	error = true;
	}
	} while (error);
	return entero;
	}
	
	
	}





