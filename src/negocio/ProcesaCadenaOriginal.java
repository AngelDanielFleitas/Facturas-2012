package negocio;

import pojos.*;

public class ProcesaCadenaOriginal {

	private Cliente cl;
	private Emisor em;
	private Compra co;
	private Factura fa;
	
	public ProcesaCadenaOriginal(Cliente cl, Emisor em, Compra co, Factura fa) {
		this.cl = cl;
		this.em = em;
		this.co = co;
		this.fa = fa;
	}
	
	public String generaCadena(){
		String razonSocialReceptor = cl.getRazonSocial();
		String comprobante = fa.getComprobante();
		String serie = fa.getSerie();
		String folio = fa.getFolio();
		String formaPago = "UNA SOLA EXHIBICION";
		String tipoPago = fa.getTipopago();
		String rfcReceptor = cl.getRfc();
		String total = co.getTotal();
		String subtotal = co.getTotal();
		String impuesto = co.getImpuestos();
		String calleReceptor = cl.getCalle();
		String noInteriorReceptor = cl.getNumeroint();
		String noExteriorReceptor = cl.getNumeroext();
		String coloniaReceptor = cl.getColonia();
		String codigoPostalReceptor =  cl.getCp();
		String muniReceptor = cl.getMunicipio();
		String ciudadReceptor = cl.getMunicipio();
		String estadoReceptor = cl.getEstado();
		String paisReceptor="MEXICO";
		String fecha = co.getFecha() + "T" + co.getHora();
		String noAprobacion = fa.getNoAprobacion();
		String anoAprobacion = fa.getAnoAprobacion();
		String rfcEmisor = em.getRfc();
		String razonSocialEmisor = em.getRazonSocial();
		String calleEmisor  = em.getCalle();
		String noInteriorEmisor = em.getNumeroInt();
		String noExteriorEmisor = em.getNumeroExt();
		String coloniaEmisor = em.getColonia();
		String codigoPostalEmisor = em.getCp();
		String muniEmisor = em.getMunicipio();
		String ciudadEmisor  = em.getMunicipio();
		String estadoEmisor = em.getEstado();
		String paisEmisor="MEXICO";
		String cantidad = co.getCantidad();
		String unidad = co.getUnidad();
		String concepto = co.getDescripcion();
		String precioUnitario = co.getValorUnitario();
		String importe = co.getTotal();
		// ||2.0|ABCD|2|2010-05-03T14:11:36|49|2008|ingreso|UNA SOLA EXHIBICIÓN|2000.00|0.00|2320.00|PAMC660606ER9|CONTRIBUYENTE PRUEBASEIS PATERNOSEIS MATERNOSEIS|PRUEBA SEIS|6|6|PUEBLA CENTRO|PUEBLA|PUEBLA|PUEBLA|MÉXICO|72000|CAUR390312S87|ROSA MARÍA CALDERÓN UIRIEGAS|TOPOCHICO|52|JARDINES DEL VALLE|NUEVO LEON|México|95465|1.00|Servicio|01|Asesoria Fiscal y administrativa|2000.00|2000.00|IVA|16.00|320.00|320.00||
		//||2.0|AB|32|2010-02-18T12:30:03|434|2006|ingreso|EFECTIVO|3000.00|45029.85|02934INFOSOFT|Infosoft & Xgress|arenas|98|Coyoacan|DF|México|54832|4503495WXGF4|México|2|Impresoras|1500.00|3000.00|2|PC|2000.00|4000.00|IVA|15.00|2900.85|2900.85|| 
		String cadenaOriginal = "||2.0|"+serie+"|"+folio+"|"+fecha+"|"+noAprobacion+"|"+anoAprobacion+"|"+comprobante+"|"+formaPago+"|"+subtotal+"|"+"0.00"+"|"+total+"|"
		+tipoPago+"|"+rfcEmisor+"|"+razonSocialEmisor+"|"+calleEmisor+"|"+noExteriorEmisor+"|"+noInteriorEmisor+"|"+coloniaEmisor+"|"+ciudadEmisor+"|"+muniEmisor+"|"
		+estadoEmisor+"|"+paisEmisor+"|"+codigoPostalEmisor+"|"+rfcReceptor+"|"+razonSocialReceptor+"|"+calleReceptor+"|"+noExteriorReceptor+"|"+noInteriorReceptor+"|"
		+coloniaReceptor+"|"+ciudadReceptor+"|"+muniReceptor+"|"+estadoReceptor+"|"+paisReceptor+"|"+codigoPostalReceptor;
		String conceptos = "|" + cantidad + "|" + unidad + "|" + concepto + "|" + precioUnitario + "|" + importe;
		String traslados = "|" + "IVA" + "|" + "16.00" + "|" + impuesto + "|" + impuesto + "||"; 
		cadenaOriginal = cadenaOriginal + conceptos + traslados;
		return cadenaOriginal;
	}
}
