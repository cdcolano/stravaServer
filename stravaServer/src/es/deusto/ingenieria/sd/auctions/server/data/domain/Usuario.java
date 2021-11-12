package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
	private String email;
	private String nombre;
	private Date fechaNacimiento;
	private float peso;
	private float altura;
	private int frecuenciaMax;
	private int frecuenciaReposo;
	private String contrasena;
	private List<Reto> retosAceptados;
	private List<SesionEntrenamiento> sesiones;
	
	public void addSesion(SesionEntrenamiento sesion) {
		sesiones.add(sesion);
	}
	
	public List<SesionEntrenamiento> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<SesionEntrenamiento> sesiones) {
		this.sesiones = sesiones;
	}

	public Usuario() {
		retosAceptados= new ArrayList<>();
		sesiones= new ArrayList<SesionEntrenamiento>();
	}
	
	public void addReto(Reto reto) {
		retosAceptados.add(reto);
	}
	
	public void removeReto(Reto reto) {
		retosAceptados.remove(reto);
	}
	
	public List<Reto> getRetosAceptados() {
		return retosAceptados;
	}

	public void setRetosAceptados(List<Reto> retosAceptados) {
		this.retosAceptados = retosAceptados;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public int getFrecuenciaMax() {
		return frecuenciaMax;
	}
	public void setFrecuenciaMax(int frecuenciaMax) {
		this.frecuenciaMax = frecuenciaMax;
	}
	public int getFrecuenciaReposo() {
		return frecuenciaReposo;
	}
	public void setFrecuenciaReposo(int frecuenciaReposo) {
		this.frecuenciaReposo = frecuenciaReposo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean checkPassword(String contrasena) {
		return this.contrasena.contentEquals(contrasena);
	}
	
	public boolean equals(Usuario u) {
		if(u.getEmail().contentEquals(email)) {
			return true;
		}else {
			return false;
		}
	}
	
	public float calculateCumplimiento(Reto r) {
		int distancia=0;
		int tiempo=0;
		for(SesionEntrenamiento sesion : sesiones) {
			if (sesion.getFechaInicio().getTime()<r.getFechaFin().getTime() && sesion.getFechaInicio().getTime()>r.getFechaInicio().getTime()) {
				if (r.getDeporte()==sesion.getDeporte() || r.getDeporte()==Deporte.ambas) {
					distancia+=sesion.getDistancia();
					tiempo+=sesion.getDuracion();
				}
			}
		}
		float porcentaje;
		if (r.getDistanciaObjetivo()!=0) {
			porcentaje=distancia/r.getDistanciaObjetivo()*100;
		}else {
			porcentaje=tiempo/r.getTiempoObjetivo()*100;
		}
		
		return porcentaje;
	}
	
}
