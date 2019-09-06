package pojos;

public class Factura {

	private String serie;
	private String folio;
	private String tipopago;
	private String comprobante;
	private String noAprobacion;
	private String anoAprobacion;
	private String cadenaOriginal;
	private String sello;
	private String noCertif;
	
	public Factura(String serie, String folio, String tipopago,
			String comprobante, String noAprobacion, String anoAprobacion) {
		this.serie = serie;
		this.folio = folio;
		this.tipopago = tipopago;
		this.comprobante = comprobante;
		this.noAprobacion = noAprobacion;
		this.anoAprobacion = anoAprobacion;
	}
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getTipopago() {
		return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getComprobante() {
		return comprobante;
	}
	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}
	public String getNoAprobacion() {
		return noAprobacion;
	}
	public void setNoAprobacion(String noAprobacion) {
		this.noAprobacion = noAprobacion;
	}
	public String getAnoAprobacion() {
		return anoAprobacion;
	}
	public void setAnoAprobacion(String anoAprobacion) {
		this.anoAprobacion = anoAprobacion;
	}

	public String getCadenaOriginal() {
		return cadenaOriginal;
	}

	public void setCadenaOriginal(String cadenaOriginal) {
		this.cadenaOriginal = cadenaOriginal;
	}

	public String getSello() {
		return sello;
	}

	public void setSello(String sello) {
		this.sello = sello;
	}

	public String getNoCertif() {
		return noCertif;
	}

	public void setNoCertif(String noCertif) {
		this.noCertif = noCertif;
	}
	
	
	
}
