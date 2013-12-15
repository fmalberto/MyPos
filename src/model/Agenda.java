package model;

import java.util.ArrayList;

import persistence.DbConnection;

public class Agenda {
	
	private ArrayList<Cliente> listaClientes;
	
	public Agenda () {
		listaClientes = new DbConnection().getClientes();		
	}
	
	public void agregarCliente(Cliente cliente) {
		new DbConnection().adicionarCliente(cliente);		
	}
	
	public ArrayList<Cliente> getContactos () {		
		return listaClientes;		
	}
	

}
