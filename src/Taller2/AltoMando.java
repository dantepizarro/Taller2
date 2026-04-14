package Taller2;
import java.util.List;

public class AltoMando {
	private int numero;
	private String NombreAltoMando;
	private List<String> EquipoAM;
	
	public AltoMando(int numero, String nombre, List<String> equipoAM) {
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

	public List<String> getEquipoAM() {
		return EquipoAM;
	}
	public String toString() {
		return "AltoMando [nombre=" + NombreAltoMando + "]"; 
	}
	
}
