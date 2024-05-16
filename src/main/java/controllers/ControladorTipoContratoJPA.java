package controllers;

import java.util.List;


import entities.Tipocontrato;




public class ControladorTipoContratoJPA extends SuperControladorJPA {

	
	private static ControladorTipoContratoJPA instance = null;
	
	
	public ControladorTipoContratoJPA() {
		super(Tipocontrato.class,"tipocontrato");
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorTipoContratoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContratoJPA();
		}
		return instance;
	}

	
	
}
