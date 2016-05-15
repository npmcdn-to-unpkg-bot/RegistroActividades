package com.udea.servicios.dao;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbSemestre;

public interface SemestreDaoInt {
	public List<TbSemestre> consultar() throws ExcepcionDao;
}
