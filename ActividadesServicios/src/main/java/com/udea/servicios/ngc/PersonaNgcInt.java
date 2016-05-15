package com.udea.servicios.ngc;

import com.udea.dominio.dto.TbPersona;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;

public interface PersonaNgcInt {
	public void crearPersona(TbPersona persona) throws ExcepcionNgc;
	public TbPersona consultarPersona(String identificacion) throws ExcepcionNgc;
	public List<TbPersona> consultarPersona() throws ExcepcionNgc;
}
