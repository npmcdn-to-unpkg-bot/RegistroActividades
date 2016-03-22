package com.udea.servicios.dao;

import com.udea.dominio.dto.Persona;
import com.ctrlz.util.excepcion.ExcepcionDao;

public interface PersonaDaoInt {
	public void crearPersona(Persona persona)throws ExcepcionDao;
	public Persona consultarPersona(String identificacion) throws ExcepcionDao;
}
