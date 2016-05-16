package com.udea.servicios.dao;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbReporteActividad;

public interface ReporteActividadDaoInt {
	public void registrar(TbReporteActividad reporteActividad) throws ExcepcionDao;
}
