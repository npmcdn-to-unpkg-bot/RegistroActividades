package com.udea.servicios.ngc;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbSemestre;

public interface SemestreNgcInt {
	public List<TbSemestre> consultarSemestres() throws ExcepcionNgc;
}
