package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.Date;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

public class RetoDTO {
	private Date fechaInicio;
	private Date fechaFin;
	private int distanciaObjetivo;
	private String nombre;
	private int tiempoObjetivo;
	private Deporte deporte;
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getDistanciaObjetivo() {
		return distanciaObjetivo;
	}
	public void setDistanciaObjetivo(int distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTiempoObjetivo() {
		return tiempoObjetivo;
	}
	public void setTiempoObjetivo(int tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
}
