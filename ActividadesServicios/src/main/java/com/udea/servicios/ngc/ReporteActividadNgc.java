package com.udea.servicios.ngc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.ctrlz.util.general.Fecha;
import com.udea.dominio.dto.TbReporteActividad;
import com.udea.servicios.dao.ReporteActividadDaoInt;
import com.udea.servicios.model.ReporteActividadModel;

@RestController
@RequestMapping(value = "/reporteactividad")
public class ReporteActividadNgc implements ReporteActividadNgcInt {
	@Autowired
	ReporteActividadDaoInt reporteActividadDao;

	public void setReporteActividadDao(ReporteActividadDaoInt reporteActividadDao) {
		this.reporteActividadDao = reporteActividadDao;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public void registrar(@RequestBody ReporteActividadModel reporteActividad) throws ExcepcionNgc {
		try {
			TbReporteActividad reporteActividadDto=reporteActividad.toDto();
			reporteActividadDao.registrar(reporteActividadDto);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error validando información de reporte actividad");
			throw expNgc;
		}
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public List<TbReporteActividad> consultar(@RequestBody Date fecha) throws ExcepcionNgc {
		try {
			Date fechaInicial=Fecha.getFechaInicialSemana(fecha);
			Date fechaFinal=Fecha.getFechaFinalSemana(fechaInicial);
			return reporteActividadDao.consultar(fechaInicial,fechaFinal);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error consultado los reportes de actividades");
			throw expNgc;
		}
	}
}
