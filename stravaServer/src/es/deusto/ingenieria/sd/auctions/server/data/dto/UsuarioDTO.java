package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.Date;

public class UsuarioDTO {
	
	private String email;
	private String nombre;
	private Date fechaNacimiento;
	private float peso;
	private float altura;
	private int frecuenciaMax;
	private int frecuenciaReposo;
	private String contrasena;
	
	
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
}
