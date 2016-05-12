package com.udea.servicios.ngc;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbDocente;

public interface DocenteNgcInt {
	public List<TbDocente> consultarDocentes() throws ExcepcionNgc;
}
