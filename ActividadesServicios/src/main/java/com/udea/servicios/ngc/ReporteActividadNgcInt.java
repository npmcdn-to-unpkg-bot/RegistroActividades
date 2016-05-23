package com.udea.servicios.ngc;

import java.util.Date;
import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbReporteActividad;
import com.udea.servicios.model.ReporteActividadModel;

public interface ReporteActividadNgcInt {
	public void registrar(ReporteActividadModel reporteActividad) throws ExcepcionNgc;
	public List<TbReporteActividad> consultar(Date fecha) throws ExcepcionNgc;
}
