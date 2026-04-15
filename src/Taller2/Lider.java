package Taller2;
import java.util.List;

public class Lider {
	private int Numero;
	private String NombreLider;
	private String Estado;
	private int Cantidad;
	private List<Pokemon> EquipoLider;
	
	public Lider(int numero, String nombreLider, String estado, int cantidad, List<Pokemon> equipoLider) {
		Numero = numero;
		NombreLider = nombreLider;
		Estado = estado;
		Cantidad = cantidad;
		EquipoLider = equipoLider;
	}

	public int getNumero() {
		return Numero;
	}

	public String getNombreLider() {
		return NombreLider;
	}

	public String getEstado() {
		return Estado;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public List<Pokemon> getEquipoLider() {
		return EquipoLider;
	}
	
}
