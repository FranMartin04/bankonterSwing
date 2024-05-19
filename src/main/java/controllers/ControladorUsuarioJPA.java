package controllers;

import java.util.List;

import entities.Usuario;



public class ControladorUsuarioJPA extends SuperControladorJPA {

	
	private static ControladorUsuarioJPA instance = null;
	
	
	public ControladorUsuarioJPA() {
		super(Usuario.class, "usuario");
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorUsuarioJPA getInstance() {
		if (instance == null) {
			instance = new ControladorUsuarioJPA();
		}
		return instance;
	}
	
	
	
}
