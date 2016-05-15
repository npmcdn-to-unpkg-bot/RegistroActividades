package com.udea.servicios.dao;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbDocenteSemestreCurso;

public interface DocenteSemestreCursoDaoInt {
	public List<TbDocenteSemestreCurso> consultar(long docente,int semestre) throws ExcepcionDao;
}
