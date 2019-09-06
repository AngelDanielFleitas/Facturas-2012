package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import pojos.*;

/**
 * Servlet implementation class ServletInicio
 */
@WebServlet("/ServletInicio")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession actual = request.getSession();
		String rfc = request.getParameter("rfc").toUpperCase();
		ClienteDao d = new ClienteDao();
		boolean b = d.verificaCliente(rfc);
		String msg;
		if(b == true){
			Cliente c = new Cliente();
			c = d.obtieneCliente(rfc);
			System.out.println(c);
			actual.setAttribute("clienteactual", c);
			actual.setAttribute("rfc", c.getRfc());
			actual.setAttribute("razon", c.getRazonSocial());
			actual.setAttribute("calle", c.getCalle());
			actual.setAttribute("numeroext", c.getNumeroext());
			actual.setAttribute("numeroint", c.getNumeroint());
			actual.setAttribute("colonia", c.getColonia());
			actual.setAttribute("cp", c.getCp());
			actual.setAttribute("municipio", c.getMunicipio());
			actual.setAttribute("estado", c.getEstado());
			actual.setAttribute("correo", c.getCorreo());
			System.out.println(actual.getAttribute("numeroext"));
			System.out.println(actual.getAttribute("numeroint"));
			response.sendRedirect("datosfacturacion.jsp");
		}else{
			msg = "error de inicio de sesion";
			actual.setAttribute("msg", msg);
			response.sendRedirect("error.jsp");
		}
		
		
		
		
	}

}
