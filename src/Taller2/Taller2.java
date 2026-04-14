package Taller2;

import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.List;

public class Taller2 {
	static List<Pokemon> lista_Poke = new ArrayList<>();
	static List<String> EquipoAM = new ArrayList<>();
	static List<AltoMando> Liga = new ArrayList<>();
	static List<String> EquipoLider = new ArrayList<>();
	static List<Lider> Lideres = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		File Partida = new File("txt\\Registros.txt");

		try {
			BufferedReader lector = new BufferedReader(new FileReader(Partida));
			String linea;

			while ((linea = lector.readLine()) != null) {

			}
		} catch (Exception e) {
			System.out.println("Problemas con el archivo Registros");
		}
		
		File ArchPokedex = new File("txt\\Pokedex.txt");
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchPokedex));
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				String Nombre = partes[0];
				String habitat = partes[1];
				double spawnrate = Double.parseDouble(partes[2]);
				int cantidad = partes.length;
				int stats = 0;
				for (int i = 3; i < cantidad - 1; i++) {
					stats += Integer.parseInt(partes[i]);
				}
				String tipo = partes[9];
				Pokemon poke = new Pokemon(Nombre, habitat, spawnrate, stats, tipo);
				
				lista_Poke.add(poke);
				
				
			}
		} catch (Exception e) {
			System.out.println("Problemas con el archivo pokedex");
		}

		File ArchAltoMando = new File("txt\\Alto Mando.txt");
		System.out.println(ArchAltoMando.exists());
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchAltoMando));
			
			String linea;

			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				EquipoAM.clear();
				int Numero = Integer.parseInt(partes[0]);
				String NombreAltoMando = partes[1];
				for (int i = 2; i < 8; i++) {
					EquipoAM.add(partes[i]);
				}
			AltoMando altoMando = new AltoMando(Numero,NombreAltoMando,EquipoAM);
			Liga.add(altoMando);
			
			}
		} catch (Exception e) {
			System.out.println("problemas con el archivo Alto Mando");
		}

		File ArchGimnasios = new File("txt\\Gimnasios.txt");
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
					EquipoLider.add(partes[i]);
				}
			Lider lider = new Lider(Numero, Nombre, Estado, Cantidad, EquipoLider);
			Lideres.add(lider);
			}
		} catch (Exception e) {
			System.out.println("problemas con el archivo Gimnasios");
		}

		File ArchHabitats = new File("txt\\Habitats.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ArchHabitats));
			String linea;

			while ((linea = lector.readLine()) != null) {
				String Habitat = linea;

			}
		} catch (Exception e) {
			System.out.println("Problema con el archivo Habitats");
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
