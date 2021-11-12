package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.SesionEntrenamiento;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionEntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionEntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UsuarioAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UsuarioDTO;

import es.deusto.ingenieria.sd.auctions.server.services.GestorEntrenamientosAppService;
import es.deusto.ingenieria.sd.auctions.server.services.GestorRetosAppService;
import es.deusto.ingenieria.sd.auctions.server.services.GestorUsuariosAppService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private GestorUsuariosAppService usuariosService = GestorUsuariosAppService.getInstance();
	private GestorEntrenamientosAppService sesionService = GestorEntrenamientosAppService.getInstance();
	private GestorRetosAppService retosService = GestorRetosAppService.getInstance();
	
	public RemoteFacade() throws RemoteException {
		super();		
	}
	





	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
					
		//Perform login() using LoginAppService
		Usuario user = usuariosService.login(email, password);
				
		//If login() success user is stored in the Server State
		if (user != null) {
		//If user is not logged in 
		if (!this.serverState.values().contains(user)) {
			Long token = Calendar.getInstance().getTimeInMillis();		
			this.serverState.put(token, user);		
			return(token);
		} else {
			throw new RemoteException("User is already logged in!");
		}
		} else {
			throw new RemoteException("Login fails!");
		}
		
	}
	
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public boolean registro(UsuarioDTO usuarioDTO) {
		UsuarioAssembler usuarioToDTO= UsuarioAssembler.getInstance();
		Usuario u= usuarioToDTO.DTOToUsuario(usuarioDTO);
		return usuariosService.registro(u);
		
	}

	@Override
	public boolean crearSesionManual(SesionEntrenamientoDTO sesionDTO, long token) {
		Usuario u= serverState.get(token);
		SesionEntrenamientoAssembler sesionToDTO= SesionEntrenamientoAssembler.getInstance();
		SesionEntrenamiento s= sesionToDTO.DTOToSesion(sesionDTO);
		sesionService.crearSesionManual(s, u);
		return false;
	}

	@Override
	public boolean crearReto(RetoDTO retoDTO, long usuario) {
		Usuario u=serverState.get(usuario);
		RetoAssembler retoToDTO= RetoAssembler.getInstance();
		Reto reto= retoToDTO.DTOToReto(retoDTO);
		reto.setUsuario(u);
		retosService.crearReto(reto);
		return false;
	}

	@Override
	public boolean aceptarReto(RetoDTO retoDTO, long usuario) {
		RetoAssembler retoToDTO= RetoAssembler.getInstance();
		Reto reto= retoToDTO.DTOToReto(retoDTO);
		Usuario u=serverState.get(usuario);
		GestorRetosAppService gestor=GestorRetosAppService.getInstance();
		return gestor.aceptarReto(reto, u);
		
	}

	@Override
	public List<RetoDTO> getRetosAceptados(long usuario) {
		Usuario u= serverState.get(usuario);
		List<Reto> retos=retosService.getRetosAceptados(u);
		RetoAssembler retoToDTO= RetoAssembler.getInstance();
		return retoToDTO.retosToDTO(retos);
		
	}

	@Override
	public float calculateCumplimiento(RetoDTO retoDTO, long usuario) {
		RetoAssembler retoToDTO= RetoAssembler.getInstance();
		Reto reto= retoToDTO.DTOToReto(retoDTO);
		Usuario u= serverState.get(usuario);
		GestorRetosAppService gestor= GestorRetosAppService.getInstance();
		return gestor.calculateCumplimiento(reto, u);
	}










	@Override
	public long login(String email, String password, boolean facebook) throws RemoteException {
		
		//Perform login() using LoginAppService
		Usuario user = usuariosService.login(email, password,facebook );
		if (user!=null) {
			Long token = Calendar.getInstance().getTimeInMillis();		
			this.serverState.put(token, user);		
			return(token);
		}
		else {
			throw new RemoteException("El login ha fallado");
		}
		//If login() success user is stored in the Server State
	}







}