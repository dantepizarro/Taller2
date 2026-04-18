package Taller2;

import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.PortUnreachableException;

public class Taller2 {
	static List<Pokemon> lista_Poke = new ArrayList<>();
	static List<Pokemon> EquipoAM = new ArrayList<>();
	static List<AltoMando> Liga = new ArrayList<>();
	static List<Pokemon> EquipoLider = new ArrayList<>();
	static List<Lider> Lideres = new ArrayList<>();
	static List<String> Ficha = new ArrayList<>();
	static List<Pokemon> PC = new ArrayList<>(); 
	static List<String> habitats = new ArrayList<>();
	static List<Pokemon> poke_ruta = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
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
				EquipoAM.clear();
				
				for (int i = 2; i < 8; i++) {
					String NombrePokemon = partes[i];
					
					for(int j = 0;j<lista_Poke.size();j++) {
						if(NombrePokemon.equals(lista_Poke.get(j).getNombre())) {
							EquipoAM.add(lista_Poke.get(j));
						}
					}
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
				System.out.println(Nombre);
				String Estado = partes[2];
				int Cantidad = Integer.parseInt(partes[3]);
				EquipoLider.clear();
				
				for (int i = 4; i < Cantidad + 4; i++) {
					String NombrePokemon = partes[i];
					
					
					
					for(int j = 0;j<lista_Poke.size();j++) {
						if(NombrePokemon.equals(lista_Poke.get(j).getNombre())) {
							EquipoLider.add(lista_Poke.get(j));
							
						}
					}
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
				habitats.add(Habitat);

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
					System.out.printf("Bienvenido %s !!\n",Ficha.get(0));
					break;
				case 2:
					IngresarJugador();
					System.out.printf("Bienvenido %s !!\n",Ficha.get(0));
					MenuPrincipal();
					break;
				case 3:
					break;
			}
		} while (opcion != 3);

	}

	public static void MenuPrincipal() {
		// cargar datos de registros y dar la bienvenida
		Scanner scanner = new Scanner(System.in);
		
		File Partida = new File("txt\\Registros.txt");

		try {
			BufferedReader lector = new BufferedReader(new FileReader(Partida));
			String linea;
			
			if((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				Ficha.add(partes[0]);
				for(int i = 1;i<partes.length; i++) {
					Ficha.add(partes[i]);
				}
				
			}
			
			
			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				String NombrePokemon = partes[0];
				
				
			}
		} catch (Exception e) {
			System.out.println("Problemas con el archivo Registros");
		}
		
		int opcion;
		do {
			System.out.printf("%s, que deseas hacer?\n", Ficha.get(0));
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
					System.out.println("Donde desea explorar?:  ");
					System.out.println("Zonas disponibles: ");
					System.out.println("1) Lago");
					System.out.println("2) Cueva");
					System.out.println("3) Montaña");
					System.out.println("4) Bosque");
					System.out.println("5) Prado");
					System.out.println("6) Mar");
					System.out.println("7) Regresar al menu");
					int lugar = scanner.nextInt();
					 Capturar(lugar);
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
		
		System.out.println("se eliminara la partida anterior");
		System.out.println("Esta seguro? (Si/No)");
		System.out.print(">");
		String opcion = scanner.nextLine();
		
		if(opcion.equalsIgnoreCase("Si")) {
			
			System.out.print("Ingrese su nombre de jugador: ");
			String Jugador = scanner.nextLine();
			
			String Medallas = "none";
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("txt\\Registros.txt"));
				
				bw.write(Jugador + ";" + Medallas);
				bw.newLine();
				
				bw.close();
				
				System.out.println("Nueva partida creada con exito");
			}catch (Exception e) {
				System.out.println("Problemas con crear el archivo Registros");
			}
			
			MenuPrincipal();
		}else {
			System.out.println("No se creo la nueva partida");
			MenuInicial();
			
		}
		
	}
	public static void Capturar(int ubicacion ) {
		Random r = new Random();
		poke_ruta.clear();
		int cantidad = 0;
			for (int i = 0; i < lista_Poke.size(); i ++) {
				Pokemon pokemon_actual = lista_Poke.get(i);
				
				if (pokemon_actual.getHabitat().equalsIgnoreCase(habitats.get(ubicacion-1))) {
					int aparicion =(int)(pokemon_actual.getPorAparicion()*100);
					for (int a = 0 ; a < aparicion ;a++) {
						poke_ruta.add(pokemon_actual);						
					}
				}
			}
			System.out.println(poke_ruta.get(0).getNombre());
			MenuPrincipal();
		}
	
}
