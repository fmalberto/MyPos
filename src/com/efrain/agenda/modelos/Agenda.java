package com.efrain.agenda.modelos;

import java.util.ArrayList;

import com.efrain.agenda.persistencia.Conexion;

public class Agenda {
	
	private ArrayList<Contacto> contactos;
	
	public Agenda () {
		
		contactos = new Conexion().getContactos();		
	}
	
	public void agregarContacto(Contacto contacto) {
		new Conexion().agregarContacto(contacto);		
	}
	
	public ArrayList<Contacto> getContactos () {		
		return contactos;		
	}
	

}
