package com.udea.servicios.ngc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbReporteActividad;
import com.udea.servicios.dao.ReporteActividadDaoInt;

@RestController
@RequestMapping(value = "/reporteactividad")
public class ReporteActividadNgc implements ReporteActividadNgcInt {
	@Autowired
	ReporteActividadDaoInt reporteActividadDao;

	public void setReporteActividadDao(ReporteActividadDaoInt reporteActividadDao) {
		this.reporteActividadDao = reporteActividadDao;
	}
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public void registrar(@RequestBody TbReporteActividad reporteActividad) throws ExcepcionNgc {
		try {
			reporteActividadDao.registrar(reporteActividad);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error validando información de reporte actividad");
			throw expNgc;
		}
		
	}

}
