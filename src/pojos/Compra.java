package pojos;

public class Compra {
	private String identificacion;
	private String descripcion;
	private String cantidad;
	private String unidad;
	private String valorUnitario;
	private String subtotal;
	private String impuestos;
	private String total;
	private String fecha;
	private String hora;
	
	public Compra() {
		this.identificacion = "";
		this.descripcion = "";
		this.cantidad = "";
		this.unidad = "";
		this.valorUnitario = "";
		this.subtotal = "";
		this.impuestos = "";
		this.total = "";
		this.fecha = "";
		this.hora = "";
	}
	
	public Compra(String identificacion, String descripcion, String cantidad,
			String unidad, String valorUnitario, String subtotal,
			String impuestos, String total, String fecha, String hora) {
		this.identificacion = identificacion;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.valorUnitario = valorUnitario;
		this.subtotal = subtotal;
		this.impuestos = impuestos;
		this.total = total;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(String impuestos) {
		this.impuestos = impuestos;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Compra [identificacion=" + identificacion + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", unidad=" + unidad
				+ ", valorUnitario=" + valorUnitario + ", subtotal=" + subtotal
				+ ", impuestos=" + impuestos + ", total=" + total + ", fecha="
				+ fecha + ", hora=" + hora + "]";
	}	
}
