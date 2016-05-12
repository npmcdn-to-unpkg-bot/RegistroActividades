package com.udea.servicios.dao;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbTipoActividad;

public interface TipoActividadDaoInt {
	public List<TbTipoActividad> consultarTipoActividades() throws ExcepcionDao;
}
