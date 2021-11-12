package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionEntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	
	public long login(String email, String password, boolean facebook) throws RemoteException;

	boolean registro (UsuarioDTO usuario);
	boolean crearSesionManual(SesionEntrenamientoDTO sesion, long token);
	boolean crearReto( RetoDTO reto, long usuario);
	boolean aceptarReto(RetoDTO reto, long usuario);
	List<RetoDTO> getRetosAceptados(long usuario);
	float calculateCumplimiento(RetoDTO reto, long usuario);
	
}