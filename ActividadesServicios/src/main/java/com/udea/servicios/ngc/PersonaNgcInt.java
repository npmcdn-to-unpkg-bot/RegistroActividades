package com.udea.servicios.ngc;

import com.udea.dominio.dto.Persona;
import com.ctrlz.util.excepcion.ExcepcionNgc;

public interface PersonaNgcInt {
	public void crearPersona(Persona persona) throws ExcepcionNgc;
	public Persona consultarPersona(String identificacion) throws ExcepcionNgc;
}
