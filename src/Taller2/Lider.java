package Taller2;
import java.util.List;

public class Lider {
	private int Numero;
	private String NombreLider;
	private String Estado;
	private int Cantidad;
	private List<String> EquipoLider;
	
	public Lider(int numero, String nombreLider, String estado, int cantidad, List<String> equipoLider) {
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

	public List<String> getEquipoLider() {
		return EquipoLider;
	}
	
}
