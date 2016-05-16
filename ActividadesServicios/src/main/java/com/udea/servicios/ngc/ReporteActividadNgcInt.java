package com.udea.servicios.ngc;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbReporteActividad;

public interface ReporteActividadNgcInt {
	public void registrar(TbReporteActividad reporteActividad) throws ExcepcionNgc;
}
