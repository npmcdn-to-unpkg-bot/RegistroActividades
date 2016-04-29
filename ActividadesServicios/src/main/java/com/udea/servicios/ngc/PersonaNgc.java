package com.udea.servicios.ngc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.udea.servicios.dao.PersonaDaoInt;
import com.ctrlz.util.excepcion.ExcepcionDao;
import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbPersona;

@RestController
@RequestMapping(value = "/persona")
public class PersonaNgc implements PersonaNgcInt {

	@Autowired
	PersonaDaoInt personaDao;

	public void setPersonaDao(PersonaDaoInt personaDao) {
		this.personaDao = personaDao;
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public void crearPersona(@RequestBody TbPersona persona) throws ExcepcionNgc {
		try {
			personaDao.crearPersona(persona);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error validando información");
			throw expNgc;
		}
	}

	@RequestMapping(value = "/get/{identificacion}", method = RequestMethod.GET)
	public @ResponseBody TbPersona consultarPersona(@PathVariable("identificacion") String identificacion)
			throws ExcepcionNgc {
		try {
			return personaDao.consultarPersona(identificacion);
		} catch (ExcepcionDao e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			throw expNgc;
		} catch (Exception e) {
			ExcepcionNgc expNgc = new ExcepcionNgc(e);
			expNgc.setMensajeUsuario("Error validando información");
			throw expNgc;
		}
	}
}
