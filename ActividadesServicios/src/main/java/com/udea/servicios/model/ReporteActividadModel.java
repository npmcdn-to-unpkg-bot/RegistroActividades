package com.udea.servicios.model;

import java.math.BigDecimal;
import java.util.Date;

import com.udea.dominio.dto.TbDocenteSemestreCurso;
import com.udea.dominio.dto.TbReporteActividad;
import com.udea.dominio.dto.TbTipoActividad;


public class ReporteActividadModel implements java.io.Serializable {
	
	private BigDecimal nbId;
	private int idDocenteSemestreCurso;
	private int idTipoActividad;
	private Date dtFecha;
	private BigDecimal nbHoras;
	private String vrDescripcion;
	public BigDecimal getNbId() {
		return nbId;
	}
	public void setNbId(BigDecimal nbId) {
		this.nbId = nbId;
	}
	public int getIdDocenteSemestreCurso() {
		return idDocenteSemestreCurso;
	}
	public void setIdDocenteSemestreCurso(int idDocenteSemestreCurso) {
		this.idDocenteSemestreCurso = idDocenteSemestreCurso;
	}
	public int getIdTipoActividad() {
		return idTipoActividad;
	}
	public void setIdTipoActividad(int idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}
	public Date getDtFecha() {
		return dtFecha;
	}
	public void setDtFecha(Date dtFecha) {
		this.dtFecha = dtFecha;
	}
	public BigDecimal getNbHoras() {
		return nbHoras;
	}
	public void setNbHoras(BigDecimal nbHoras) {
		this.nbHoras = nbHoras;
	}
	public String getVrDescripcion() {
		return vrDescripcion;
	}
	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	
	public TbReporteActividad toDto(){
		TbReporteActividad reporteActividad=new TbReporteActividad();
		reporteActividad.setTbDocenteSemestreCurso(new TbDocenteSemestreCurso());
		reporteActividad.setTbTipoActividad(new TbTipoActividad());
		
		reporteActividad.getTbDocenteSemestreCurso().setNbId(this.idDocenteSemestreCurso);
		reporteActividad.getTbTipoActividad().setNbId(this.idTipoActividad);
		reporteActividad.setDtFecha(this.dtFecha);
		reporteActividad.setNbHoras(this.nbHoras);
		reporteActividad.setVrDescripcion(this.vrDescripcion);
		
		return reporteActividad;
	}
	
}
