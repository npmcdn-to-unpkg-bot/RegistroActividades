package com.udea.servicios.model;

import java.io.Serializable;
import java.util.Date;

public class Semana implements Serializable {

	private Date fechaInicial;
	private Date fechaFinal;
	private short numeroSemana;
	private short anio;
	
	public short getAnio() {
		return anio;
	}
	public void setAnio(short anio) {
		this.anio = anio;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public short getNumeroSemana() {
		return numeroSemana;
	}
	public void setNumeroSemana(short numeroSemana) {
		this.numeroSemana = numeroSemana;
	}
}
