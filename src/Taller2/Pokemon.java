package Taller2;

public class Pokemon {
	private String nombre;
	private String Habitat;
	private double PorAparicion;
	private int Stats;
	private String Tipo;
	private String Estado;
	

	public Pokemon(String nombre, String habitat, double porAparicion, int stats, String tipo, String estado) {
		this.nombre = nombre;
		Habitat = habitat;
		PorAparicion = porAparicion;
		Stats = stats;
		Tipo = tipo;
		Estado = estado;
	}


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public String getHabitat() {
		return Habitat;
	}


	public double getPorAparicion() {
		return PorAparicion;
	}


	public int getStats() {
		return Stats;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
