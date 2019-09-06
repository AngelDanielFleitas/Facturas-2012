package pojos;

public class Emisor {

	private String rfc;
	private String razonSocial;
	private String regimen;
	private String calle;
	private String numeroExt;
	private String numeroInt;
	private String colonia;
	private String cp;
	private String municipio;
	private String estado;
	
	public Emisor(){
		this.rfc = "";
		this.razonSocial = "";
		this.regimen = "";
		this.calle = "";
		this.numeroExt = "";
		this.numeroInt = "";
		this.colonia = "";
		this.cp = "";
		this.municipio = "";
		this.estado = "";
	}
	
	public Emisor(String rfc, String razonSocial, String regimen, String calle,
			String numeroExtM, String numeroInt, String colonia, String cp,
			String municipio, String estado) {
		this.rfc = rfc;
		this.razonSocial = razonSocial;
		this.regimen = regimen;
		this.calle = calle;
		this.numeroExt = numeroExtM;
		this.numeroInt = numeroInt;
		this.colonia = colonia;
		this.cp = cp;
		this.municipio = municipio;
		this.estado = estado;
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

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExt() {
		return numeroExt;
	}

	public void setNumeroExt(String numeroExtM) {
		this.numeroExt = numeroExtM;
	}

	public String getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
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

	@Override
	public String toString() {
		return "Emisor [rfc=" + rfc + ", razonSocial=" + razonSocial
				+ ", regimen=" + regimen + ", calle=" + calle + ", numeroExtM="
				+ numeroExt + ", numeroInt=" + numeroInt + ", colonia="
				+ colonia + ", cp=" + cp + ", municipio=" + municipio
				+ ", estado=" + estado + "]";
	}
	
}
