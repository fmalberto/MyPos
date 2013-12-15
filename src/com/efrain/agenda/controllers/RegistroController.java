package com.efrain.agenda.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.efrain.agenda.modelos.Agenda;
import com.efrain.agenda.modelos.Contacto;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("contactoList", new Agenda().getContactos());
		req.getRequestDispatcher("contactos.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String edad = req.getParameter("edad");
		String telefono = req.getParameter("telefono");
		String ciudad = req.getParameter("ciudad");
		
		if(nombre.equals("") || apellido.equals("") || edad.equals("") || telefono.equals("") || ciudad.equals("")) {

			req.setAttribute("messaje", "insira todos os dados");
			req.getRequestDispatcher("resultado.jsp").forward(req, resp);
		}else {
			new Agenda().agregarContacto(new Contacto(nombre, apellido, edad, telefono, ciudad));
			req.setAttribute("messaje", "Dados enviados com sucesso!");
			req.getRequestDispatcher("resultado.jsp").forward(req, resp);
		}
	}
}
