package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.SesionEntrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

public class GestorEntrenamientosAppService {
	private static GestorEntrenamientosAppService instance;

	private GestorEntrenamientosAppService(){ }

	public boolean crearSesionManual(SesionEntrenamiento sesion, Usuario u) {
		for (SesionEntrenamiento sesionEntrenamiento:u.getSesiones()) {
			if (sesionEntrenamiento.equals(sesionEntrenamiento)) {
				return false;
			}
		}
		u.addSesion(sesion);
		return true;
	}
	
	
	public static GestorEntrenamientosAppService getInstance() {
		if (instance == null) {
			instance = new GestorEntrenamientosAppService();
		}
		return instance;
		
	}
}
