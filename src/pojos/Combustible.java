package pojos;

public class Combustible {

	private String precioUni;
	private String nombre;
	
	public Combustible() {
		this.precioUni = "";
		this.nombre = "";
	}
	
	public Combustible(String precioUni, String nombre) {
		this.precioUni = precioUni;
		this.nombre = nombre;
	}
	
	public String getPrecioUni() {
		return precioUni;
	}
	
	public void setPrecioUni(String precioUni) {
		this.precioUni = precioUni;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Combustible [precioUni=" + precioUni + ", nombre=" + nombre
				+ "]";
	}	
	
	
}
