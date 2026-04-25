package Taller2;

import java.util.List;

public class Jugador {
	private String jugador;
	private List<String> Ficha;
	private List<Pokemon> PC;
	public Jugador(String jugador, List<String> ficha, List<Pokemon> pC) {
		this.jugador = jugador;
		Ficha = ficha;
		PC = pC;
	}
	public String getJugador() {
		return jugador;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	public List<String> getFicha() {
		return Ficha;
	}
	public void setFicha(List<String> ficha) {
		Ficha = ficha;
	}
	public List<Pokemon> getPC() {
		return PC;
	}
	public void setPC(List<Pokemon> pC) {
		PC = pC;
	}
	
	
	
	
	
	
}
