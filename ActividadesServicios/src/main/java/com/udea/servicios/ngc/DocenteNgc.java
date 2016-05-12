package com.udea.servicios.ngc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbDocente;
import com.udea.servicios.dao.DocenteDaoInt;

@RestController
@RequestMapping(value = "/docente")
public class DocenteNgc implements DocenteNgcInt {

	@Autowired
	DocenteDaoInt docenteDao;

	public void setDocenteDao(DocenteDaoInt docenteDao) {
		this.docenteDao = docenteDao;
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public @ResponseBody List<TbDocente> consultarDocentes() throws ExcepcionNgc {
		try {
			return docenteDao.consultarDocentes();
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error consultado los docentes");
			throw expNgc;
		}
	}

}
