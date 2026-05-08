package Taller2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
	static String nombreJugador;
	

	public static void main(String[] args) {
		
		Scanner scan;
		
		try {
			scan = new Scanner(new File("txt\\Pokedex.txt"));
			String linea;
			
			while ((scan.hasNextLine())){
				String[] partes = scan.nextLine().split(";");
				String Nombre = partes[0];
				String habitat = partes[1];
				double spawnrate = Double.parseDouble(partes[2]);
				int cantidad = partes.length;
				int stats = 0;
				for (int i = 3; i < cantidad - 1; i++) {
					stats += Integer.parseInt(partes[i]);
				}
				String tipo = partes[9];
				Pokemon poke = new Pokemon(Nombre, habitat, spawnrate, stats, tipo,"vivo");
				
				lista_Poke.add(poke);
				
				
			}
		} catch (Exception e) {
			System.out.println("Problemas con el archivo pokedex");
		}


		try {
			scan = new Scanner(new File("txt\\Alto Mando.txt"));

			while ((scan.hasNextLine())) {
				String[] partes = scan.nextLine().split(";");
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

		try {
			scan = new Scanner(new File("txt\\Gimnasios.txt"));

			while ((scan.hasNextLine())) {
				String[] partes = scan.nextLine().split(";");
				int Numero = Integer.parseInt(partes[0]);
				String Nombre = partes[1];
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

		try {
			scan = new Scanner(new File("txt\\Habitats.txt"));

			while ((scan.hasNextLine())) {
				String Habitat = scan.nextLine();
				habitats.add(Habitat);

			}
		} catch (Exception e) {
			System.out.println("Problema con el archivo Habitats");
		}


		MenuInicial();

	}

	public static void MenuInicial() {

		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1) Continuar");
			System.out.println("2) Nueva Partida");
			System.out.println("3) Salir");
			System.out.println(">");
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
				default:
					System.out.println("Opcion invalida, ingresa 1, 2 o 3.");
					break;
			}
		} while (opcion != 3);

	}

	public static void MenuPrincipal() {
		
		Scanner scan;

		try {
			scan = new Scanner(new File("txt\\Registros.txt"));
			
			if((scan.hasNextLine())) {
				String[] partes = scan.nextLine().split(";");
				nombreJugador = partes[0];
				
				for(int i = 1;i<partes.length; i++) {
					Ficha.add(partes[i]);
				}
			}
			while ((scan.hasNextLine())) {
				String[] partes = scan.nextLine().split(";");
				String NombrePokemon = partes[0];
				String Estado = partes[1];
				for(int i = 0;i<lista_Poke.size();i++) {
					if(NombrePokemon.equals(lista_Poke.get(i).getNombre())){
						PC.add(lista_Poke.get(i));
						
					}
				}
			}
			for(int i = 0;i<Ficha.size();i++){
				String Medalla = Ficha.get(i);
				for(Lider l: Lideres){
					if(l.getNombreLider().equalsIgnoreCase(Medalla)){
						l.setEstado("Derrotado");
					}
				}
			}
			
		} catch (IOException e) {
			System.out.println("Problemas con el archivo Registros");
		}
		
		int opcion;
		Scanner scanner = new Scanner(System.in);
		do {
			Jugador jugador = new Jugador(nombreJugador,Ficha,PC);
			System.out.println();
			System.out.printf("Bienvenido %s !!\n",nombreJugador);
			System.out.printf("%s, que deseas hacer?\n", nombreJugador);
			System.out.println("1) Revisar equipo");
			System.out.println("2) Salir a capturar");
			System.out.println("3) Acceso al PC (cambiar Pokemon del equipo)");
			System.out.println("4) Retar un gimnasio");
			System.out.println("5) Desafio al Alto mando");
			System.out.println("6) Curar equipo");
			System.out.println("7) Guardar");
			System.out.println("8) Guardar y salir");
			System.out.println(">");
			opcion = scanner.nextInt();
			
			switch (opcion) {
				case 1:
					RevisarEquipo();
					break;
				case 2:
					ElegirZona();
					break;
				case 3:
					VerPC();
					break;
				case 4:
					Gimnasios(jugador);
					break;
				case 5:
					LigaPokemon(jugador);
					break;
				case 6:
					Curar();
					break;
				case 7:
					Guardar();
					break;
				case 8:
					Guardar();
					return;
				default:
					System.out.println("Opcion invalida, ingresa un numero entre 1 y 8.");
					break;

			}
		} while (opcion != 8);
	}
	
	public static void RevisarEquipo() {
		System.out.println("Equipo Actual:");
		if(PC.size() < 6) {
			for(int i = 0;i<PC.size();i++) {
				System.out.printf("%d) %s|%s|Stats totales: %s",i+1,PC.get(i).getNombre(),PC.get(i).getTipo(),PC.get(i).getStats());
				System.out.println();
			}
		}else {
			for(int i = 0;i<6;i++) {
				System.out.printf("%d) %s|%s|Stats totales: %s",i+1,PC.get(i).getNombre(),PC.get(i).getTipo(),PC.get(i).getStats());
				System.out.println();
			}
			
		}
	}
	
	public static void ElegirZona() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Donde desea explorar?:  ");
		System.out.println("Zonas disponibles: ");
		System.out.println("1) Lago");
		System.out.println("2) Cueva");
		System.out.println("3) Montaña");
		System.out.println("4) Bosque");
		System.out.println("5) Prado");
		System.out.println("6) Mar");
		System.out.println("7) Regresar al menu");
		System.out.println(">");
		int lugar = scanner.nextInt();
		if(lugar <1 || lugar > 7) {
			System.out.println("Zona invalida para capturar.");
			return;
		}
		if(lugar == 7) return;
		Capturar(lugar);
	}

	public static void IngresarJugador() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("se eliminara la partida anterior");
		System.out.println("Esta seguro? (Si/No)");
		System.out.print(">");
		String opcion = scanner.nextLine();
		
		if(opcion.equalsIgnoreCase("Si")) {
			
			System.out.print("Ingrese su nombre de jugador: ");
			String jugador = scanner.nextLine();
			if (jugador.isEmpty()) {
				System.out.println("El nombre no puede estar vacio.");
				return;
			}
			
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("txt\\Registros.txt"));
				
				bw.write(jugador + ";none");
				
				
				bw.newLine();
				bw.close();
				
				System.out.println("Nueva partida creada con exito");
			}catch (Exception e) {
				System.out.println("Problemas con crear el archivo Registros");
			}
			PC.clear();
			Ficha.clear();
			MenuPrincipal();
		}else {
			System.out.println("No se creo la nueva partida");
			MenuInicial();
			
		}
		
	}
	public static void Capturar(int ubicacion ) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		poke_ruta.clear();
		int cantidad = 0;
			for( int i = 0; i< lista_Poke.size();i++) {
				Pokemon pokemon_actual = lista_Poke.get(i);
				
				
				if(pokemon_actual.getHabitat().equalsIgnoreCase(habitats.get(ubicacion-1))) {
					int aparicion = (int)(pokemon_actual.getPorAparicion()*100);
					for(int a = 0;a<aparicion;a++) {
						poke_ruta.add(pokemon_actual);
						
					}
				}
		}
			
		boolean todosCapturados = true;
		for(Pokemon pk: poke_ruta) {
			if(!Jugador.tienePokemon(pk.getNombre())) {
				todosCapturados = false;
				break;
			}
		}
		
		if(todosCapturados) {
			System.out.println("ya capturaste a todos los pokemones de esta zona");
			return;
		}
			
		int indice = r.nextInt(poke_ruta.size());
		Pokemon salvaje = poke_ruta.get(indice);
		
		
		
		System.out.println("Aparecio un " + salvaje.getNombre());
		System.out.println();
		System.out.println("¿Que desea hacer?");
		System.out.println("1) Capturar");
		System.out.println("2) Escapar");
		System.out.println(">");
		int opc = scan.nextInt();
		switch(opc) {
		case 1:
			if(Jugador.tienePokemon(salvaje.getNombre())) {
				System.out.println("Ya tienes un " + salvaje.getNombre());
				break;
			}
			
			if(PC.size() >= 6) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("txt/Registros.txt",true));
					bw.write(salvaje.getNombre() + ";" + salvaje.getEstado());
					
					bw.newLine();
					bw.close();
					
					
					System.out.printf("%s capturado con exito!!\n",salvaje.getNombre());
					System.out.printf("Tu equipo esta lleno, %s fue enviado a tu PC\n",salvaje.getNombre());
					PC.add(salvaje);

				}catch (Exception e) {
					System.out.println("Problemas reescribiendo el archivo registros");
				}
				
			}else {
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("txt/Registros.txt",true));
					bw.write(salvaje.getNombre() + ";" + salvaje.getEstado());
					bw.newLine();
					bw.close();
					
					
					System.out.printf("%s capturado con exito!!\n",salvaje.getNombre());
					PC.add(salvaje);
					System.out.printf("%s ha sido agregado a tu equipo!\n",salvaje.getNombre());
				}catch (Exception e) {
					System.out.println("Problemas reescribiendo el archivo registros");
				}
				
			}
			break;
		case 2:
			System.out.println("Has escapado con exito");
			System.out.println();
			ElegirZona();
			break;
		default:
			System.out.println("Opcion invalida.");
			break;
		}
		
	}
	
	
	public static void VerPC() {
		Scanner scanner = new Scanner(System.in);
		
		if(PC.isEmpty()) {
			System.out.println("No tienes pokemon");
			return;
			
		}
		System.out.println("--------Equipo--------");
		for(int i = 0;i<PC.size();i++) {
			if(i == 6) {
				System.out.println("------PC------");
			}
			System.out.printf("%d) %s\n",i+1,PC.get(i).getNombre());
		}
		System.out.println("Desea cambiar pokemons? (si/no).");
		System.out.println(">");
		String opcion = scanner.nextLine();
		if (!opcion.equalsIgnoreCase("si") && !opcion.equalsIgnoreCase("no")) {
			System.out.println("Respuesta invalida, escriba si o no.");
			return;
		} 
		if(opcion.equalsIgnoreCase("si")) {
			System.out.println("Ingrese el numero del primer pokemon");
			System.out.println(">");
			int indice1 = scanner.nextInt() - 1;
			
			System.out.println("Ingrese el numero del segundo pokemon");
			System.out.println(">");
			int indice2 = scanner.nextInt() - 1;
			
			if(indice1 < 0 || indice2 < 0 || indice1 >= PC.size() || indice2 >= PC.size()) {
				System.out.println("indices invalidos");
				return;
			}
			
			Pokemon temp = PC.get(indice1);
			PC.set(indice1, PC.get(indice2));
			PC.set(indice2, temp);
			System.out.println("Pokemon intercambiados con exito!");
			Guardar();
			
		}
		
		
		
	}
	public static void Guardar() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("txt\\Registros.txt"));
			
			bw.write(nombreJugador);
			for(int i = 0;i<Ficha.size();i++) {
				
				bw.write(";" + Ficha.get(i));
			}
			bw.newLine();
			
			for(Pokemon pk: PC) {
				bw.write(pk.getNombre() + ";" + pk.getEstado());
				bw.newLine();
			}
			
			bw.close();
			System.out.println("Partida Guardada!");
			
		}catch(Exception e) {
			System.out.println("error con el archivo registros");
		}
	}
	public static void Curar() {
		for(Pokemon pk : PC) {
			pk.setEstado("Vivo");
		}
		System.out.println("Tu equipo se ha recuperado");
		Guardar();
	}
	public static void Gimnasios(Jugador jugador){
		
		boolean pokemonvivo = false;
		for(int i = 0;i<PC.size() && i<6;i++){
			if(PC.get(i).estaVivo()){
				pokemonvivo = true;
				break;
			}
		}
		if(!pokemonvivo) {
			System.out.println("Deberias curar a tus pokemon primero");
			return;
		}
		if(PC.size()== 0) {
			System.out.println("No puedes enfrentarte a un lider sin pokemones");
			return;
		}
		Scanner scan = new Scanner(System.in);
		int opcion;
		for(int i = 0;i<Lideres.size();i++){
			System.out.println(Lideres.get(i).toString());
		}
		System.out.println("9) Volver al menu.");
		System.out.print(">");
		opcion = scan.nextInt();
		if (opcion < 1 || opcion > 9) {
			System.out.println("Lider de gimnasio no encontrado, pruebe un numero entre 1 y 8.");
			return;
		}
		if(opcion == 9){
			return;
		}else{
			if(opcion == 1 && Lideres.get(opcion -1).estaDisponible()){
				BatallaGimnasios(jugador,Lideres.get(opcion-1));
				return;
			}
			if (!Lideres.get(opcion-1).estaDisponible()){
				System.out.printf("Ya derrotaste a %s!\n",Lideres.get(opcion-1).getNombreLider());
				return;
			}
			for(int i = 0;i<opcion-1;i++){
				if(Lideres.get(i).estaDisponible()){
					System.out.printf("Calmado entrenador!! no puedes retar a %s sin haber derrotado a los anteriores lideres\n",Lideres.get(i+1).getNombreLider());
					return;
				}
			}
			BatallaGimnasios(jugador, Lideres.get(opcion-1));
			}

		
		
	}
	public static void BatallaGimnasios(Jugador jugador, Lider lider){

		
		Scanner scan = new Scanner(System.in);
		//verificamos que tenga algun pokemon
		if(PC.size() == 0){
			System.out.println("No tienes Pokemon para combatir");
			return;
		}
		//verificamos que el primero este vivo
		int indiceLider = 0;
		int indiceJugador= 0;
		boolean pokemonvivo = false;
		for(int i = 0;i<PC.size() && i<6;i++){
			if(PC.get(i).estaVivo()){
				pokemonvivo = true;
				indiceJugador = i;
				break;
			}
		}
		if(!pokemonvivo) {
			System.out.println("Deberias curar a tus pokemon primero");
			return;
		}
		//guardamos el pokemon actual de cada uno para no escribir tanto
		Pokemon pkLider = lider.getEquipoLider().get(indiceLider);
		Pokemon pkJugador = PC.get(indiceJugador);


		System.out.printf("%s saca a %s!\n",lider.getNombreLider(),pkLider.getNombre());
	
		System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());
		int opcion;
		do{
			System.out.println("Que deseas hacer?");
			System.out.println("1) Atacar");
			System.out.println("2) Cambiar de pokemon");
			System.out.println("3) Rendirse");
			System.out.println(">");
			opcion = scan.nextInt();
			switch (opcion) {
				case 1:
					System.out.printf("%s -> %d puntos\n",pkJugador.getNombre(),pkJugador.getStats());
				
					System.out.printf("%s -> %d puntos\n",pkLider.getNombre(),pkLider.getStats());

					//aqui hice el calculo de efectividad, total sera el mismo en cualquie caso
					double EFECTIVIDAD = TablaTipo.getEfectividad(pkJugador.getTipo(), pkLider.getTipo());
					int  StatsJugador = (int)(pkJugador.getStats()*EFECTIVIDAD);

					if(EFECTIVIDAD == 1.0){
						System.out.printf("%s es neutro contra %s\n",pkJugador.getNombre(),pkLider.getNombre());
					}else if(EFECTIVIDAD == 0.5){
						System.out.printf("%s es poco efectivo contra %s\n",pkJugador.getNombre(),pkLider.getNombre());
					}else if(EFECTIVIDAD == 2.0){
						System.out.printf("%s es super efectivo contra %s\n",pkJugador.getNombre(),pkLider.getNombre());
					}else if(EFECTIVIDAD == 0.0){
						System.out.printf("%s no afecta a %S\n",pkJugador.getNombre(),pkLider.getNombre());
					}
					
					//se imprimen los nuevos puntajes
					System.out.println("Nuevo Puntaje:");
					System.out.printf("%s -> %d puntos\n",pkJugador.getNombre(),StatsJugador);
					System.out.printf("%s -> %d puntos\n",pkLider.getNombre(),pkLider.getStats());
					

					if (StatsJugador == pkLider.getStats()) {
						System.out.println("Ambos pokemon son igual de poderosos, lo mejor sera cambiar de Pokemon");
						break;
					}
					//si ganamos
					if(StatsJugador > pkLider.getStats()){
						System.out.printf("Ha ganado %s! %s ha sido derrotado!\n",pkJugador.getNombre(),pkLider.getNombre());
						indiceLider++;
						if(indiceLider >= lider.getEquipoLider().size()){
							System.out.println("Has derrotado a " + lider.getNombreLider() + " Medalla obtenida!!");
							lider.setEstado("Derrotado");
							jugador.agregarMedalla(lider.getNombreLider());
							Guardar();
							if(Ficha.size() == 8){
								System.out.println("Has derrotado a todos los lideres de gimnasio");
								System.out.println("Ya puedes pasar a la liga pokemon, ¡Felicidades!");
							}
							return;
						}
						pkLider =	lider.getEquipoLider().get(indiceLider);
						System.out.printf("%s saca a %s!\n",lider.getNombreLider(),pkLider.getNombre());
						
					//si perdemos
					}else{
						System.out.printf("Ha ganado %s! %s ha sido derrotado!\n",pkLider.getNombre(),pkJugador.getNombre());
						pkJugador.setEstado("Debilitado");

						indiceJugador++;
						pokemonvivo = false;
						for(int i = 0;i<PC.size() && i<6;i++){
							if(PC.get(i).estaVivo()){
								pokemonvivo = true;
								indiceJugador =i;
								break;
							}
						}
						if (pokemonvivo) {
							pkJugador = PC.get(indiceJugador);
							System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());
						
					}else if(indiceJugador>5 || indiceJugador>= PC.size()){
							System.out.println("Te has quedado sin Pokemons!");
							System.out.println("Volviendo al menu...");
							return;
						}
						
					}
					
					break;
			//y toca ahora el case 2 que seria cambiar pokemon
			case 2:
			Scanner scanner = new Scanner(System.in);
			int indice;
				for(int i = 0;i<PC.size() && i<6;i++){
					if(PC.get(i).estaVivo()){
						System.out.printf("%d) %s\n",i+1,PC.get(i).getNombre());
					}
				}
				
				System.out.println(">");
				indice = scanner.nextInt()-1;
				 if(indice < 0 || indice >= PC.size() || indice >= 6){
				        System.out.println("Indice invalido.");
				        break;
				    }
				if (PC.get(indice).estaVivo() == false) {
					System.out.println("Tu pokemon derrotado no puede pelear");
					break;
				}
				if (indiceJugador == indice) {
					System.out.println("No puedes elegir a tu pokemon activo");
					break;
				}
				 
				indiceJugador = indice;
				pkJugador = PC.get(indiceJugador);
				
				System.out.println("Pokemon intercambiados con exito!");
				System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());

				break;
				default:
					System.out.println("opcion no valida");
					break;
				case 3 :
					System.out.println("Has perdido el combate contra lider "+ lider.getNombreLider());
				}
			}while(opcion != 3);


		
	}
	public static void LigaPokemon(Jugador jugador){
		Scanner scan = new Scanner(System.in);
		if(Ficha.size() < 8){
			System.out.println("No puedes enfrentar la liga pokemon sin derrotar antes a los 8 lideres");
			return;
		}
		System.out.println("Vas a enfrentarte al Alto Mando, una vez que entres no podras salir hasta que todos tus pokemon se debiliten o ganes la liga");
		System.out.println("Estas segura de continuar?(si/no)");
		System.out.println(">");
		String opcion = scan.nextLine();

		if(opcion.equalsIgnoreCase("no")){
			return;
		}else if(!opcion.equalsIgnoreCase("no") && !opcion.equalsIgnoreCase("si")){
			System.out.println("opcion invalida");
			return;
		}

		for(int i = 0; i<Liga.size();i++){
			BatallaLiga(jugador, Liga.get(i));
		}
	}
	public static void BatallaLiga(Jugador jugador, AltoMando altomando){
		Scanner scanner = new Scanner(System.in);
		int indiceJugador = 0;
		int indiceAltoMando = 0;
		boolean pokemonvivo = false;
		for(int i = 0;i<PC.size() && i<6;i++){
			if(PC.get(i).estaVivo()){
				pokemonvivo = true;
				indiceJugador = i;
				break;
			}
		}
		if(!pokemonvivo) {
			System.out.println("Deberias curar a tus pokemon primero");
			return;
		}
		Pokemon pkAltoMando = altomando.getEquipoAM().get(indiceAltoMando);
		Pokemon pkJugador = PC.get(indiceJugador);

		System.out.printf("%s saca a %s!\n",altomando.getNombre(),pkAltoMando.getNombre());
	
		System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());
		int opcion;
		do{
			System.out.println("Que deseas hacer?");
			System.out.println("1) Atacar");
			System.out.println("2) Cambiar de pokemon");
			System.out.println("3) Rendirse");
			System.out.println(">");
			opcion = scanner.nextInt();
			switch (opcion) {
				case 1:
					System.out.printf("%s -> %d puntos\n",pkJugador.getNombre(),pkJugador.getStats());
				
					System.out.printf("%s -> %d puntos\n",pkAltoMando.getNombre(),pkAltoMando.getStats());

					//aqui hice el calculo de efectividad, total sera el mismo en cualquie caso
					double EFECTIVIDAD = TablaTipo.getEfectividad(pkJugador.getTipo(), pkAltoMando.getTipo());
					int  StatsJugador = (int)(pkJugador.getStats()*EFECTIVIDAD);

					if(EFECTIVIDAD == 1.0){
						System.out.printf("%s es neutro contra %s\n",pkJugador.getNombre(),pkAltoMando.getNombre());
					}else if(EFECTIVIDAD == 0.5){
						System.out.printf("%s es poco efectivo contra %s\n",pkJugador.getNombre(),pkAltoMando.getNombre());
					}else if(EFECTIVIDAD == 2.0){
						System.out.printf("%s es super efectivo contra %s\n",pkJugador.getNombre(),pkAltoMando.getNombre());
					}else if(EFECTIVIDAD == 0.0){
						System.out.printf("%s no afecta a %S\n",pkJugador.getNombre(),pkAltoMando.getNombre());
					}
					
					//se imprimen los nuevos puntajes
					System.out.println("Nuevo Puntaje:");
					System.out.printf("%s -> %d puntos\n",pkJugador.getNombre(),StatsJugador);
					System.out.printf("%s -> %d puntos\n",pkAltoMando.getNombre(),pkAltoMando.getStats());

					if (StatsJugador == pkAltoMando.getStats()) {
						System.out.println("Ambos pokemon son igual de poderosos, lo mejor sera cambiar de Pokemon");
						break;
					}
					//si ganamos
					if(StatsJugador > pkAltoMando.getStats()){
						System.out.printf("Ha ganado %s! %s ha sido derrotado!\n",pkJugador.getNombre(),pkAltoMando.getNombre());
						indiceAltoMando++;
						if(indiceAltoMando >= altomando.getEquipoAM().size()){
							System.out.println("Has derrotado a Alto Mando" + altomando.getNombre() + " Puedes pasar al siguiente");
							if(altomando.getNumero() == 7){
								System.out.println("¡Felicidades! Has derrotado a todos los Altos Mandos");
								System.out.println("Eres el nuevo Campeón UCN!!");
							}
							return;
						}
						pkAltoMando =	altomando.getEquipoAM().get(indiceAltoMando);
						System.out.printf("%s saca a %s!\n",altomando.getNombre(),pkAltoMando.getNombre());
						
					//si perdemos, aun falta ver como hacerlo si empatan
					}else{
						System.out.printf("Ha ganado %s! %s ha sido derrotado!\n",pkAltoMando.getNombre(),pkJugador.getNombre());
						pkJugador.setEstado("Debilitado");

						indiceJugador++;
						pokemonvivo = false;
						for(int i = 0;i<PC.size() && i<6;i++){
							if(PC.get(i).estaVivo()){
								pokemonvivo = true;
								indiceJugador =i;
								break;
							}
						}
						if (pokemonvivo) {
							pkJugador = PC.get(indiceJugador);
							System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());
						
					}else if(indiceJugador>5 || indiceJugador>= PC.size()){
							System.out.println("Te has quedado sin Pokemons!");
							System.out.println("Volviendo al menu...");
							return;
						}
						
					}
					
					break;
			//y toca ahora el case 2 que seria cambiar pokemon
			case 2:
			int indice;
				for(int i = 0;i<PC.size() && i<6;i++){
					if(PC.get(i).estaVivo()){
						System.out.printf("%d) %s\n",i+1,PC.get(i).getNombre());
					}
				}
				
				System.out.println(">");
				indice = scanner.nextInt()-1;
				 if(indice < 0 || indice >= PC.size() || indice >= 6){
				        System.out.println("Indice invalido.");
				        break;
				    }
				if (PC.get(indice).estaVivo() == false) {
					System.out.println("Tu pokemon derrotado no puede pelear");
					break;
				}
				if (indiceJugador == indice) {
					System.out.println("No puedes elegir a tu pokemon activo");
					break;
				}
				 
				indiceJugador = indice;
				pkJugador = PC.get(indiceJugador);
				
				System.out.println("Pokemon intercambiados con exito!");
				System.out.printf("%s saca a %s!\n",jugador.getJugador(),pkJugador.getNombre());

				break;
			case 3 :
					System.out.println("Has perdido el combate contra lider "+ altomando.getNombre());
					return;
			}
					
		}while(opcion != 3);
	}
}

