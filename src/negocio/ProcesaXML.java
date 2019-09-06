package negocio;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import negocio.*;
import java.io.*;

import pojos.*;



public class ProcesaXML {

	private Cliente cl;
	private Emisor em;
	private Compra co;
	private Factura fa;
	
	public ProcesaXML(Cliente cl, Emisor em, Compra co, Factura fa) {
		this.cl = cl;
		this.em = em;
		this.co = co;
		this.fa = fa;
	}
	
	public String creaXML(){
		NumeroALetra nl = new NumeroALetra();
		String razonSocialReceptor = cl.getRazonSocial();
		String comprobante = fa.getComprobante();
		String serie = fa.getSerie();
		String folio = fa.getFolio();
		String formaPago = "UNA SOLA EXHIBICION";
		String tipoPago = fa.getTipopago();
		String rfcReceptor= cl.getRfc();
		String total = co.getTotal();
		String subtotal = co.getSubtotal();
		String impuesto = co.getImpuestos();		
		String calleReceptor = cl.getCalle();
		String noInteriorReceptor = cl.getNumeroint();
		String noExteriorReceptor = cl.getNumeroext();
		String coloniaReceptor = cl.getColonia();
		String codigoPostalReceptor =  cl.getCp();
		String muniReceptor = cl.getMunicipio();
		String ciudadReceptor = cl.getMunicipio();
		String estadoReceptor = cl.getEstado();
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
		String cadenaOriginal = fa.getCadenaOriginal();
		String sello = fa.getSello();
		String noCertif = fa.getNoCertif();
		String cantidad = co.getCantidad();
		String unidad = co.getUnidad();
		String concepto = co.getDescripcion();
		String precioUnitario = co.getValorUnitario();
		String importe = co.getTotal();
		String letraTotal = nl.Convertir(importe, true);
		XMLOutputter serializador = new XMLOutputter();
		Element Comprobante;
		Element Emisor;
		Element DomicilioFiscal;
		Element Receptor;
		Element Domicilio;
		Element Conceptos;
		Element Impuestos;
		Element Traslados;
		Element Addenda;
		Comprobante = new Element("Comprobante");
		Comprobante.setAttribute("serie", serie);
		Comprobante.setAttribute("version", "2.0");
		Comprobante.setAttribute("folio", folio);
		Comprobante.setAttribute("fecha",fecha);
		Comprobante.setAttribute("sello",sello);
		Comprobante.setAttribute("noCertificacion",noCertif);
		Comprobante.setAttribute("subTotal",subtotal);
		Comprobante.setAttribute("total",total);
		Comprobante.setAttribute("noAprobacion",noAprobacion);
		Comprobante.setAttribute("anoAprobacion",anoAprobacion);
		Comprobante.setAttribute("formaDePago",formaPago);
		Comprobante.setAttribute("metodoDePago",tipoPago);
		Comprobante.setAttribute("tipoComprobante",comprobante);
		Emisor=new Element("Emisor");
		Emisor.setAttribute("rfc", rfcEmisor);
		Emisor.setAttribute("nombre", razonSocialEmisor);
		DomicilioFiscal=new Element("DomicilioFiscal");
		DomicilioFiscal.setAttribute("calle", calleEmisor);
		DomicilioFiscal.setAttribute("noExterior", noExteriorEmisor);
		DomicilioFiscal.setAttribute("noInterior", noInteriorEmisor);
		DomicilioFiscal.setAttribute("colonia", coloniaEmisor);
		DomicilioFiscal.setAttribute("localidad", ciudadEmisor);
		DomicilioFiscal.setAttribute("municipio", muniEmisor);
		DomicilioFiscal.setAttribute("estado", estadoEmisor);
		DomicilioFiscal.setAttribute("pais", "MEXICO");
		DomicilioFiscal.setAttribute("codigoPostal", codigoPostalEmisor);
		Receptor=new Element("Receptor");
		Receptor.setAttribute("rfc", rfcReceptor);
		Receptor.setAttribute("nombre", razonSocialReceptor);
		Domicilio=new Element("Domicilio");
		Domicilio.setAttribute("calle", calleReceptor);
		Domicilio.setAttribute("noExterior", noExteriorReceptor);
		Domicilio.setAttribute("noInterior", noInteriorReceptor);
		Domicilio.setAttribute("colonia", coloniaReceptor);
		Domicilio.setAttribute("localidad", ciudadReceptor);
		Domicilio.setAttribute("municipio", muniReceptor);
		Domicilio.setAttribute("estado", estadoReceptor);
		Domicilio.setAttribute("pais", "Mexico");
		Domicilio.setAttribute("codigoPostal", codigoPostalReceptor);
		Conceptos=new Element("Conceptos");
		Impuestos=new Element("Impuestos");
		Impuestos.setAttribute("totalImpuestosTrasladados", impuesto);
		Traslados=new Element("Traslados");
		Element Concepto=new Element("Concepto");
		Element Traslado=new Element("Traslado");
		Concepto.setAttribute("cantidad", cantidad);
		Concepto.setAttribute("unidad",unidad);
		Concepto.setAttribute("descripcion", concepto);
		Concepto.setAttribute("valorUnitario", precioUnitario);
		Concepto.setAttribute("importe", importe);
		Traslado.setAttribute("impuesto","IVA");
		Traslado.setAttribute("importe",String.valueOf(impuesto));
		Traslado.setAttribute("tasa","16.00");
		Conceptos.addContent(Concepto);
		Traslados.addContent(Traslado);
		Addenda=new Element("Addenda");
		Addenda.setAttribute("letraTotal", letraTotal);
		Addenda.setAttribute("cadenaOriginal", cadenaOriginal);
		Comprobante.addContent(Emisor);
		Comprobante.addContent(Receptor);
		Comprobante.addContent(Conceptos);
		Comprobante.addContent(Impuestos);
		Emisor.addContent(DomicilioFiscal);
		Receptor.addContent(Domicilio);
		Impuestos.addContent(Traslados);
		Comprobante.addContent(Addenda);
		Document doc = new Document(Comprobante);
		Writer wr = new StringWriter();		
		try {
			serializador.output(doc, wr);
			System.out.println(wr.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wr.toString();		
	}
	
}
