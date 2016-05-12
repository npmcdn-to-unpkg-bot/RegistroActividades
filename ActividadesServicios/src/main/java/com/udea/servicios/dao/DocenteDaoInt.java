package com.udea.servicios.dao;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbDocente;

public interface DocenteDaoInt {
	public List<TbDocente> consultarDocentes() throws ExcepcionDao;
}
