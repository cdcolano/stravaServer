package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.SesionEntrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

public class UsuarioAssembler {
	private static UsuarioAssembler instance;

	private UsuarioAssembler() {}
		// TODO Auto-generated constructor stub
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO usuarioToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setEmail(usuario.getEmail());
		
		
	
		dto.setContrasena(usuario.getContrasena());
		dto.setFechaNacimiento(usuario.getFechaNacimiento());
		dto.setFrecuenciaMax(usuario.getFrecuenciaMax());
		dto.setFrecuenciaReposo(usuario.getFrecuenciaReposo());
		dto.setNombre(usuario.getNombre());
		dto.setAltura(usuario.getAltura());
		
				
		return dto;
	}
	
	public Usuario DTOToUsuario(UsuarioDTO dto) {
		Usuario usuario= new Usuario();
		usuario.setAltura(dto.getAltura());
		usuario.setContrasena(dto.getContrasena());
		usuario.setEmail(dto.getEmail());
		usuario.setFechaNacimiento(dto.getFechaNacimiento());
		usuario.setFrecuenciaMax(dto.getFrecuenciaMax());
		usuario.setFrecuenciaReposo(dto.getFrecuenciaReposo());
		usuario.setNombre(dto.getNombre());
		usuario.setPeso(dto.getPeso());
		ArrayList<Reto> retos=new ArrayList<Reto>();
		ArrayList<SesionEntrenamiento> sesiones= new ArrayList<>();
		usuario.setRetosAceptados(retos);
		usuario.setSesiones(sesiones);
		return usuario;
	}
	
	public List<UsuarioDTO> usuariosToDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			dtos.add(this.usuarioToDTO(usuario));
		}
		
		return dtos;		
	}
}
