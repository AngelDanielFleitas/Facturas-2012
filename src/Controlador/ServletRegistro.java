package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
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
		HttpSession s = request.getSession();
		String rfc = request.getParameter("rfc").toUpperCase();
		String razonSocial = request.getParameter("rsocial").toUpperCase();
		String calle = request.getParameter("calle").toUpperCase();
		String numeroext = request.getParameter("numeroext").toUpperCase();
		String numeroint = request.getParameter("numeroint").toUpperCase();
		String colonia = request.getParameter("colonia").toUpperCase();
		String cp = request.getParameter("cp").toUpperCase();
		String municipio = request.getParameter("municipio").toUpperCase();
		String estado = request.getParameter("estado").toUpperCase();
		String correo = request.getParameter("correo");
		System.out.println(rfc + razonSocial);
		String msg;
		if(rfc == "" || razonSocial==""||calle==""||municipio==""||correo==""){
			msg = "Error, Verifique su informacion";
			s.setAttribute("msg", msg);
			response.sendRedirect("error.jsp");
		}
		else{
			boolean b = new ClienteDao().insertaCliente(rfc, razonSocial, calle, numeroext, numeroint, colonia, cp, 
					municipio, estado, correo);
			System.out.println(b);
			msg = "Registro Correcto";
			s.setAttribute("msg", msg);
			response.sendRedirect("login.html");
			
		}
	}

}
