package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;

	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setDeporte(reto.getDeporte());
		dto.setDistanciaObjetivo(reto.getDistanciaObjetivo());
		dto.setFechaFin(reto.getFechaFin());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setTiempoObjetivo(reto.getTiempoObjetivo());
		
				
		return dto;
	}
	
	
	public Reto DTOToReto (RetoDTO dto) {
		Reto reto= new Reto();
		reto.setDeporte(dto.getDeporte());
		reto.setDistanciaObjetivo(dto.getDistanciaObjetivo());
		reto.setFechaFin(dto.getFechaFin());
		reto.setFechaInicio(dto.getFechaInicio());
		reto.setNombre(dto.getNombre());
		reto.setTiempoObjetivo(dto.getTiempoObjetivo());
		reto.setUsuario(dto.getUsuario());
		return reto;
	}
	
	
	public List<RetoDTO> retosToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;		
	}
}
