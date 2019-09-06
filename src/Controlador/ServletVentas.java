package Controlador;

import pojos.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

/**
 * Servlet implementation class ServletVentas
 */
@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //DINERO
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("combustible");
		String di = request.getParameter("cantidadpe");
		System.out.println(tipo);
		CombustileDao d = new CombustileDao(); 
		Combustible c = d.obtieneCombustible(tipo);
		System.out.println(c);
		String id = creaId();
		String pu = c.getPrecioUni();
		String sub = subtotalD(di);
		String imp = im(sub);
		String li = liD(sub, pu);
		System.out.println(sub+"*"+imp+"*"+li);
		String fecha = d.fecha();
		String hora = d.hora();
		CompraDao cd = new CompraDao();
		cd.InsertaCompra(id, tipo, li, pu, sub, imp, di, fecha, hora); 
		response.sendRedirect("CompraCombustile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//LITROS
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("combustible");
		String li = request.getParameter("cantidadli");
		CombustileDao d = new CombustileDao(); 
		Combustible c = d.obtieneCombustible(tipo);
		System.out.println(c);
		String id = creaId();
		String pu = c.getPrecioUni();
		String sub = subtotalL(pu, li);
		String imp = im(sub);
		String tot = totL(sub);
		System.out.println(sub+"*"+imp+"*"+tot);
		String fecha = d.fecha();
		String hora = d.hora();
		CompraDao cd = new CompraDao();
		cd.InsertaCompra(id, tipo, li, pu, sub, imp, tot, fecha, hora);
	}
	
	public static String creaId(){
		Random generator = new Random();
		int i = 1000000000 - generator.nextInt(1000000000);
		String s = "" + i;
		return s;
	}
	
	public static String subtotalL(String pu,String li){
		double pr = Double.parseDouble(pu);
		double l = Double.parseDouble(li);
		double subtotal = pr*l;
		return roundTwoDecimals(subtotal)+"";
	}
	
	public static String subtotalD(String to){
		double pr = Double.parseDouble(to);
		double subtotal = (pr*100)/116;
		return roundTwoDecimals(subtotal)+"";
	}
	
	public static String im(String sub){
		double su = Double.parseDouble(sub);
		double im = .16*su;
		return roundTwoDecimals(im)+"";
	}
	
	public static String totL(String sub){
		double su = Double.parseDouble(sub);
		double tot = su+(.16*su);
		return roundTwoDecimals(tot)+"";
	}
	
	public static String liD(String sub, String pu){
		double su = Double.parseDouble(sub);
		double p = Double.parseDouble(pu);
		double li = su/p;
		return li+"";
	}
	
	public static double roundTwoDecimals(double d) { 
	      DecimalFormat twoDForm = new DecimalFormat("#.##"); 
	      return Double.valueOf(twoDForm.format(d));
	}  
	
}
