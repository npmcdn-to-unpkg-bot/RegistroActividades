package com.udea.servicios.ngc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbDocenteSemestreCurso;
import com.udea.servicios.dao.DocenteSemestreCursoDaoInt;

@RestController
@RequestMapping(value = "/dsc")
public class DocenteSemestreCursoNgc implements DocenteSemestreCursoNgcInt {

	@Autowired
	DocenteSemestreCursoDaoInt docenteSemestreCursoDao;

	public void setDocenteSemestreCursoDao(DocenteSemestreCursoDaoInt docenteSemestreCursoDao) {
		this.docenteSemestreCursoDao=docenteSemestreCursoDao;
	}
	
	@RequestMapping(value = "/consultar/{docente}/{semestre}", method = RequestMethod.GET)
	public @ResponseBody List<TbDocenteSemestreCurso> consultar(
			@PathVariable("docente") long docente
			,@PathVariable("semestre") int semestre) throws ExcepcionNgc {
		try {
			return docenteSemestreCursoDao.consultar(docente, semestre);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error consultado los docentes semestres cursos");
			throw expNgc;
		}
	}

}
