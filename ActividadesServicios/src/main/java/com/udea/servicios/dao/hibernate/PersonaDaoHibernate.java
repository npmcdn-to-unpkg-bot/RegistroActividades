package com.udea.servicios.dao.hibernate;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.Persona;
import com.udea.servicios.dao.PersonaDaoInt;

public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDaoInt {

	public void crearPersona(Persona persona) throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			session.save(persona);
			session.flush(); 
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error almacenando persona");
			throw expDao;
		}
		finally{
			session.close();
		}
	}

	public Persona consultarPersona(String identificacion) throws ExcepcionDao {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setIdn(9869567);
		persona.setVrNombre("Arbey");
		persona.setVrApellido("Villegas");
		return persona;
	}

}
