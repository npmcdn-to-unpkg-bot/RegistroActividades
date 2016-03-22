package com.udea.servicios.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.Persona;
import com.udea.servicios.dao.PersonaDaoInt;

public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDaoInt{

	public void crearPersona(Persona persona) throws ExcepcionDao {
		// TODO Auto-generated method stub
		
	}

	public Persona consultarPersona(String identificacion) throws ExcepcionDao{
		// TODO Auto-generated method stub
		return null;
	}

}
