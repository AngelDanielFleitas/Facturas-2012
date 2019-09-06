package Controlador;

import java.awt.Desktop;
import java.io.*;
import java.security.MessageDigest;
import java.util.Random;

import negocio.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.*;
import dao.*;
/**
 * Servlet implementation class ServletFactura
 */
@WebServlet("/ServletFactura")
public class ServletFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession actual = request.getSession(false);
		ClienteDao d = new ClienteDao();
		EmisorDao ed = new EmisorDao();
	    CompraDao cd = new CompraDao();
		String rfc = (String)actual.getAttribute("rfc");
		String calle = request.getParameter("calle").toUpperCase();
		String numeroext = request.getParameter("numeroext").toUpperCase();
		String numeroint = request.getParameter("numeroext").toUpperCase();
		String colonia = request.getParameter("colonia").toUpperCase();
		String cp = request.getParameter("cp").toUpperCase();
		String municipio = request.getParameter("municipio").toUpperCase();
		String estado = request.getParameter("estado").toUpperCase();
		String correo = request.getParameter("correo");
		String idcompra = request.getParameter("idcompra");
		String tipopago = request.getParameter("tipopago").toUpperCase();
		boolean b = d.modifcaCliente(rfc, calle, numeroext, numeroint, colonia, cp, municipio, estado, correo);
		Cliente cl = d.obtieneCliente(rfc);
		Emisor e = ed.obtieneEmisor();
		System.out.println(e + "" + cl);
		Compra co = cd.obtieneCompra(idcompra);
		Factura fa = new Factura(creaSerie(), creaFolio(), tipopago, "INGRESO", "50", "2012");
		ProcesaCadenaOriginal pro = new ProcesaCadenaOriginal(cl, e, co, fa);
		String cado = pro.generaCadena();
		System.out.println(cado);
		fa.setCadenaOriginal(cado);
		String rutaXML = "C:\\Users\\RaulAntonio\\Documents\\Workspace\\Facturas\\WebContent\\archivos\\"+fa.getSerie()+fa.getFolio()+".xml";
		String rutaPDF = "C:\\Users\\RaulAntonio\\Documents\\Workspace\\Facturas\\WebContent\\archivos\\"+fa.getSerie()+fa.getFolio()+".pdf";
		String rutaHTML = "C:\\Users\\RaulAntonio\\Documents\\Workspace\\Facturas\\WebContent\\archivos\\"+fa.getSerie()+fa.getFolio()+".html";
		String rutaXSL = "C:\\Users\\RaulAntonio\\Documents\\Workspace\\Facturas\\WebContent\\archivos\\formato.xsl";
		System.out.println(rutaXML + rutaPDF + rutaXSL + rutaHTML);
		try {
			String sello = md5(cado);
			fa.setSello(sello);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		fa.setNoCertif("00001000000203163706" );
		ProcesaXML px = new ProcesaXML(cl, e, co, fa);
		String xml = px.creaXML();
		System.out.println(xml);
		EscribeTexto etx = new EscribeTexto();
		etx.escribir(xml, rutaXML);
		CreaPDF pd = new CreaPDF();
		pd.crearPDF(rutaXML, rutaXSL, rutaHTML, rutaPDF);
		actual.setAttribute("docs",fa.getSerie()+fa.getFolio());
		abrePDF(fa.getSerie()+fa.getFolio()+".pdf");
		response.sendRedirect("previa.html");
	}
	
	private static String md5(String clear) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(clear.getBytes());
		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			int u = b[i] & 255;
			if (u < 16) {
				h.append("0" + Integer.toHexString(u));
			} else {
				h.append(Integer.toHexString(u));
			}
		}
		return h.toString();
	}
	
	public static String creaFolio(){
		Random generator = new Random();
		int i = 5000 - generator.nextInt(5000);
		String s = "" + i;
		return s;
	}
	
	public static String creaSerie(){
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int j = 0; j < 3; j++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	public static void abrePDF(String p){
		try {
			File pdfFile = new File("C:\\Users\\RaulAntonio\\Documents\\Workspace\\Facturas\\WebContent\\archivos\\"+p);
			if (pdfFile.exists()) {
	 			if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
				} else {
					System.out.println("Awt Desktop is not supported!");
				}
	 
			} else {
				System.out.println("File is not exists!");
			}
	 
			System.out.println("Done");
	 
		  } catch (Exception ex) {
			ex.printStackTrace();
		  }
	 
	}

}

