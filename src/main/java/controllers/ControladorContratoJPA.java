package controllers;

import java.util.List;

import entities.Contrato;



public class ControladorContratoJPA extends SuperControladorJPA {

	
	private static ControladorContratoJPA instance = null;
	
	
	public ControladorContratoJPA() {
		super("contrato", Contrato.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorContratoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorContratoJPA();
		}
		return instance;
	}
	
	
}
