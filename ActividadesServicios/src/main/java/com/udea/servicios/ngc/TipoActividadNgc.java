package com.udea.servicios.ngc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbTipoActividad;
import com.udea.servicios.dao.TipoActividadDaoInt;


@RestController
@RequestMapping(value = "/tipoactividad")
public class TipoActividadNgc implements TipoActividadNgcInt {

	@Autowired
	TipoActividadDaoInt tipoActividadDao;

	public void setTipoActividadDao(TipoActividadDaoInt tipoActividadDao) {
		this.tipoActividadDao=tipoActividadDao;
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public @ResponseBody List<TbTipoActividad> consultarTipoActividades() throws ExcepcionNgc {
		try {
			return tipoActividadDao.consultarTipoActividades();
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error consultado los tipos de actividad");
			throw expNgc;
		}
	}

}
