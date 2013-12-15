package com.efrain.agenda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.efrain.agenda.modelos.Contacto;

public class Conexion {	

	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private Connection conexion;
	private ArrayList<Contacto> contactos;
	

	public Conexion () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/csdb?user=cs&password=cs");
			consulta = conexion.createStatement();
			contactos = new ArrayList<Contacto>();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}				
	}
	
	
	public void agregarContacto(Contacto contacto) {
		
		try {
			enunciado = conexion.prepareStatement("insert into agenda values (?,?,?,?,?)");
			enunciado.setString(1, contacto.getNombre());
			enunciado.setString(2, contacto.getApellido());
			enunciado.setString(3, contacto.getEdad());
			enunciado.setString(4, contacto.getTelefono());
			enunciado.setString(5, contacto.getCiudad());
			enunciado.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Contacto> getContactos() {
		
		try {
			resultado = consulta.executeQuery("select * from agenda");
			while(resultado.next()) {
				contactos.add(new Contacto(resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("edad"), resultado.getString("telefono"), resultado.getString("ciudad")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	return contactos;		
	}
	
	
	
}
