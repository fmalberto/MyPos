package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Cliente;




/**
 * Servlet implementation class RegistroController
 */
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 /**
     * Default constructor. 
     */
    public RegistroController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contactoList", new Agenda().getContactos());		
		request.getRequestDispatcher("contactos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
		String telefono = request.getParameter("telefono");
		String ciudad = request.getParameter("ciudad");
		
		if(nombre.equals("") || apellido.equals("") || edad.equals("") || telefono.equals("") || ciudad.equals("")) {

			request.setAttribute("messaje", "insira todos os dados");
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}else {
			new Agenda().agregarCliente(new Cliente(nombre, apellido, edad, telefono, ciudad));

			
			request.setAttribute("messaje", "Dados enviados com sucesso!");
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}
	}
}
