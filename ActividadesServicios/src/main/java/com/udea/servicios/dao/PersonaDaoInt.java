package com.udea.servicios.dao;

import com.udea.dominio.dto.TbPersona;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionDao;

public interface PersonaDaoInt {
	public void crearPersona(TbPersona persona)throws ExcepcionDao;
	public TbPersona consultarPersona(String identificacion) throws ExcepcionDao;
	public List<TbPersona> consultarPersonas() throws ExcepcionDao;
}
