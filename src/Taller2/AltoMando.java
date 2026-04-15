package Taller2;
import java.util.List;

public class AltoMando {
	private int numero;
	private String NombreAltoMando;
	private List<Pokemon> EquipoAM;
	
	public AltoMando(int numero, String nombre, List<Pokemon> equipoAM) {
		this.numero = numero;
		NombreAltoMando = nombre;
		EquipoAM = equipoAM;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return NombreAltoMando;
	}

	public List<Pokemon> getEquipoAM() {
		return EquipoAM;
	}
	public String toString() {
		return "AltoMando [nombre=" + NombreAltoMando + "]"; 
	}
	
}
