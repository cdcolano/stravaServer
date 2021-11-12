package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.Date;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Deporte;

public class SesionEntrenamientoDTO {
	private String titulo;
	private Deporte deporte;
	private int distancia;
	private Date fechaInicio;
	private int duracion;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
