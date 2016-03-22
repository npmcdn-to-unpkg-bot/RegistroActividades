package com.udea.dominio.dto;
// default package
// Generated 12/03/2016 11:41:36 AM by Hibernate Tools 4.3.1.Final

/**
 * Persona generated by hbm2java
 */
public class Persona implements java.io.Serializable {

	private long idn;
	private String vrNombre;
	private String vrApellido;

	public Persona() {
	}

	public Persona(long idn) {
		this.idn = idn;
	}

	public Persona(long idn, String vrNombre, String vrApellido) {
		this.idn = idn;
		this.vrNombre = vrNombre;
		this.vrApellido = vrApellido;
	}

	public long getIdn() {
		return this.idn;
	}

	public void setIdn(long idn) {
		this.idn = idn;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public String getVrApellido() {
		return this.vrApellido;
	}

	public void setVrApellido(String vrApellido) {
		this.vrApellido = vrApellido;
	}

}
