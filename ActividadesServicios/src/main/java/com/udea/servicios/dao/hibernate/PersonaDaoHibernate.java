package com.udea.servicios.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbPersona;
import com.udea.servicios.dao.PersonaDaoInt;

public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDaoInt {

	public void crearPersona(TbPersona persona) throws ExcepcionDao {
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

	public TbPersona consultarPersona(String identificacion) throws ExcepcionDao {
		// TODO Auto-generated method stub
		TbPersona persona = new TbPersona();
		persona.setNbId(99899);
		persona.setVrNombres("Arbey");
		persona.setVrApellidos("Villegas");
		return persona;
	}

	public List<TbPersona> consultarPersonas() throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			List<TbPersona> personas=session.createCriteria(TbPersona.class).list();
			session.flush(); 
			
			return personas;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error almacenando persona");
			throw expDao;
		}
	}

}
