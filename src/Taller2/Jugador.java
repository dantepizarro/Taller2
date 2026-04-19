package Taller2;

import java.util.List;

public class Jugador {
	private String usuario;
	private List<String> Ficha;
	private List<Pokemon> PC;
	private List<Pokemon> Equipo;
	
	public Jugador(String usuario, List<String> ficha, List<Pokemon> pC, List<Pokemon> equipo) {
		this.usuario = usuario;
		Ficha = ficha;
		PC = pC;
		Equipo = equipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public List<Pokemon> getEquipo() {
		return Equipo;
	}
	public void setEquipo(List<Pokemon> equipo) {
		Equipo = equipo;
	}
	
	
}
