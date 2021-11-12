package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.SesionEntrenamiento;

public class SesionEntrenamientoAssembler {
	private static SesionEntrenamientoAssembler instance;

	private SesionEntrenamientoAssembler() {}
		// TODO Auto-generated constructor stub
	
	public static SesionEntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new SesionEntrenamientoAssembler();
		}

		return instance;
	}

	public SesionEntrenamientoDTO sesionEntrenamientoToDTO(SesionEntrenamiento sesion) {
		SesionEntrenamientoDTO dto = new SesionEntrenamientoDTO();
		
		dto.setTitulo(sesion.getTitulo());
		dto.setDeporte(sesion.getDeporte());
		dto.setDistancia(sesion.getDistancia());
		dto.setFechaInicio(sesion.getFechaInicio());
		dto.setDuracion(sesion.getDuracion());
		
		
		
				
		return dto;
	}
	
	public SesionEntrenamiento DTOToSesion(SesionEntrenamientoDTO dto) {
		SesionEntrenamiento sesion= new SesionEntrenamiento();
		sesion.setDeporte(dto.getDeporte());
		sesion.setDistancia(dto.getDistancia());
		sesion.setDuracion(dto.getDuracion());
		sesion.setFechaInicio(dto.getFechaInicio());
		sesion.setTitulo(dto.getTitulo());
		return sesion;
	}
	
	public List<SesionEntrenamientoDTO> sesionesEntrenamientoToDTO(List<SesionEntrenamiento> sesiones) {
		List<SesionEntrenamientoDTO> dtos = new ArrayList<>();
		
		for (SesionEntrenamiento sesion : sesiones) {
			dtos.add(this.sesionEntrenamientoToDTO(sesion));
		}
		
		return dtos;		
	}
}
