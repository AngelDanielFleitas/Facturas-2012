package pojos;

public class Cliente {
	
	private String rfc;
	private String razonSocial;
	private String calle;
	private String numeroext;
	private String numeroint;
	private String colonia;
	private String cp;
	private String municipio;
	private String estado;
	private String correo;
	
	public Cliente(){
		this.rfc = "";
		this.razonSocial = "";
		this.calle = "";
		this.numeroext = "";
		this.numeroint = "";
		this.colonia = "";
		this.cp = "";
		this.municipio = "";
		this.estado = "";
		this.correo = "";
	}
	
	public Cliente(String rfc, String razonSocial, String calle,
			String numeroext, String numeroint, String colonia, String cp,
			String municipio, String estado, String correo) {
		this.rfc = rfc;
		this.razonSocial = razonSocial;
		this.calle = calle;
		this.numeroext = numeroext;
		this.numeroint = numeroint;
		this.colonia = colonia;
		this.cp = cp;
		this.municipio = municipio;
		this.estado = estado;
		this.correo = correo;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroext() {
		return numeroext;
	}
	public void setNumeroext(String numeroext) {
		this.numeroext = numeroext;
	}
	public String getNumeroint() {
		return numeroint;
	}
	public void setNumeroint(String numeroint) {
		this.numeroint = numeroint;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@Override
	public String toString() {
		return "Cliente [rfc=" + rfc + ", razonSocial=" + razonSocial
				+ ", calle=" + calle + ", numeroext=" + numeroext
				+ ", numeroint=" + numeroint + ", colonia=" + colonia + ", cp="
				+ cp + ", municipio=" + municipio + ", estado=" + estado
				+ ", correo=" + correo + "]";
	}
	
	
	
}
