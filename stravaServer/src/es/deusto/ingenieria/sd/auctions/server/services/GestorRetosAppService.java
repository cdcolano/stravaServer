package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

public class GestorRetosAppService {
	 private ArrayList<Reto> retos;
	 
	private static GestorRetosAppService instance;

	private GestorRetosAppService(){ }
	/**Cuando se crea un Reto la ventana envia el token del usuario y ese usuario se añade al reto 
	 * @param reto
	 * @return
	 */
	public boolean crearReto(Reto reto) {
		for (Reto r: retos) {
			if (r.equals(reto))
				return false;
		}
		retos.add(reto);
		return true;
	}
	
	public boolean aceptarReto(Reto reto, Usuario usuario) {
		for (Reto r: usuario.getRetosAceptados()) {
			if (r.equals(reto))
				return false;
		}
		usuario.addReto(reto);
		return true;
	}
	
	public List<Reto> getRetosAceptados(Usuario u){
		return u.getRetosAceptados();
	}
	
	public float calculateCumplimiento(Reto reto, Usuario u) {
		return u.calculateCumplimiento(reto);
	}
	
	public static GestorRetosAppService getInstance() {
		if (instance == null) {
			instance = new GestorRetosAppService();
		}
		return instance;
		
	}
	
	
}
