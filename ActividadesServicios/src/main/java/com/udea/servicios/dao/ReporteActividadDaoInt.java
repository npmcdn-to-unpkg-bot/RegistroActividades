package com.udea.servicios.dao;

import java.util.Date;
import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbReporteActividad;

public interface ReporteActividadDaoInt {
	public void registrar(TbReporteActividad reporteActividad) throws ExcepcionDao;
	public List<TbReporteActividad> consultar(Date fechaInicial,Date fechaFinal) throws ExcepcionDao;
}
