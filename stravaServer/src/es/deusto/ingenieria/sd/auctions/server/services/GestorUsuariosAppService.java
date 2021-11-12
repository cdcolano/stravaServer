package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.ArrayList;
import java.util.HashMap;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionEntrenamientoAssembler;

public class GestorUsuariosAppService {
	private HashMap<String, Usuario> usuarios= new HashMap<>();
	
	private static GestorUsuariosAppService instance;

	private GestorUsuariosAppService(){ }
	
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario user=usuarios.get(email);
		
		if (user!=null && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
		
	}
	
	public Usuario login(String email, String password, boolean facebook) {
		//TODO: Get User using DAO and check 		
		//Generate the hash of the password
		//String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		//user.setContrasena(sha1);
		
		if (usuarios.containsKey(email)) {		
			return usuarios.get(email);
		} else {
			return null;
		}
		
	}
	
	
	/** El registro se hace independientemente de como se realice por Facebook o Google o email
	 * de manera igual para el servidor unicamente varia al introducir los datos en las ventanas
	 * @param user
	 * @return
	 */
	public boolean registro(Usuario user) {
		if (usuarios.containsKey(user.getEmail())) {
			System.out.println("El usuario ya existe");
			return false;
		}else {
			usuarios.put(user.getEmail(), user);
		}
		return true;
	}
	
	
	public static GestorUsuariosAppService getInstance() {
		if (instance == null) {
			instance = new GestorUsuariosAppService();
		}
		return instance;
		
	}
	
	
	
	
	
	
	
}
