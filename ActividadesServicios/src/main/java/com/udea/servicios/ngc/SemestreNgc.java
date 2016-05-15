package com.udea.servicios.ngc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbSemestre;
import com.udea.servicios.dao.SemestreDaoInt;

@RestController
@RequestMapping(value = "/semestre")
public class SemestreNgc implements SemestreNgcInt {

	@Autowired
	SemestreDaoInt semestreDao;

	public void setSemestreDao(SemestreDaoInt semestreDao) {
		this.semestreDao=semestreDao;
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public @ResponseBody List<TbSemestre> consultarSemestres() throws ExcepcionNgc {
		try {
			return semestreDao.consultar();
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error consultado los semestres");
			throw expNgc;
		}
	}

}
