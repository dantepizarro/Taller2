package Taller2;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Taller2 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		File Partida = new File("txts\\Registros.txt");
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader(Partida));
			String linea;

			while ((linea = lector.readLine()) != null) {

			}
		} catch (Exception e) {

		}

		File ArchAltoMando = new File("txts\\Alto Mando.txt");
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchAltoMando));
			String linea;

			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");

				int Numero = Integer.parseInt(partes[0]);
				String NombreAltoMando = partes[1];
				for (int i = 2; i < 8; i++) {

				}
				

			}
		} catch (Exception e) {

		}

		File ArchGimnasios = new File("txts\\Gimnasios.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchGimnasios));
			String linea;

			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				int Numero = Integer.parseInt(partes[0]);
				String Nombre = partes[1];
				String Estado = partes[2];
				int Cantidad = Integer.parseInt(partes[3]);
				for (int i = 4; i < Cantidad + 4; i++) {

				}
			}
		} catch (Exception e) {

		}

		File ArchHabitats = new File("txts\\Habitats.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchHabitats));
			String linea;

			while ((linea = lector.readLine()) != null) {
				String Habitat = linea;

			}
		} catch (Exception e) {

		}

		File ArchPokedex = new File("txts\\Pokedex.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchPokedex));
			String linea;

			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				String Nombre = partes[0];
				

			}
		} catch (Exception e) {

		}

		MenuInicial();

	}

	public static void MenuInicial() {
		// Cotrol de errores
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1) Continuar");
			System.out.println("2) Nueva Partida");
			System.out.println("3) Salir");
			opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					MenuPrincipal();
					break;
				case 2:
					IngresarJugador();
					break;
				case 3:
					break;
			}
		} while (opcion != 3);

	}

	public static void MenuPrincipal() {
		// cargar datos de registros y dar la bienvenida
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1) Revisar equipo");
			System.out.println("2) Salir a capturar");
			System.out.println("3) Acceso al PC (cambiar Pokemon del equipo)");
			System.out.println("4) Retar un gimnasio");
			System.out.println("5) Desafio al Alto mando");
			System.out.println("6) Curar equipo");
			System.out.println("7) Guardar");
			System.out.println("8) Guardar y salir");
			opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					// RevisarEquipo()
					break;
				case 2:
					// Capturar()
					break;
				case 3:
					// PC
					break;
				case 4:
					// Gimnasios
					break;
				case 5:
					// Alto mando
					break;
				case 6:
					// Curar
					break;
				case 7:
					// Guardar
					break;
				case 8:
					// GuardarYsalir
					break;

			}
		} while (opcion != 8);
	}

	public static void IngresarJugador() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese su nombre de jugador: ");
		String Nombre = scanner.nextLine();

		// reescribir registros con jugador nuevo
		MenuPrincipal();
	}

}
