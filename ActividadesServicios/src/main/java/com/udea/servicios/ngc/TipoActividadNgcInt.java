package com.udea.servicios.ngc;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbTipoActividad;

public interface TipoActividadNgcInt {
	public List<TbTipoActividad> consultarTipoActividades() throws ExcepcionNgc;
}
