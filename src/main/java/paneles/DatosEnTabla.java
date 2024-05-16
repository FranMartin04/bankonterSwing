package paneles;

import java.util.List;

import controllers.ControladorTipoContratoJPA;
import entities.Tipocontrato;




public class DatosEnTabla {
private static List<Tipocontrato> tipoContratos = null;
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripción"};
	}

	/**
	 * 
	 * @return
	 */
	public static List<Tipocontrato> getTodosTipoContratos () {
		if (tipoContratos == null) {
			tipoContratos =  (List<Tipocontrato>) ControladorTipoContratoJPA
					.getInstance().findAll();
		}
		return tipoContratos;

	}
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Tipocontrato> TipoContratos = getTodosTipoContratos();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[TipoContratos.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < TipoContratos.size(); i++) {
			Tipocontrato c = TipoContratos.get(i);
			datos[i][0] = c.getId();
			datos[i][1] = c.getDescripcion();

		}
		
		return datos;
	}
}
