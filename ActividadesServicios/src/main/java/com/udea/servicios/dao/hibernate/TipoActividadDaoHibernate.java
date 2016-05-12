package com.udea.servicios.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbDocente;
import com.udea.dominio.dto.TbTipoActividad;
import com.udea.servicios.dao.TipoActividadDaoInt;

public class TipoActividadDaoHibernate extends HibernateDaoSupport implements TipoActividadDaoInt {

	public List<TbTipoActividad> consultarTipoActividades() throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			List<TbTipoActividad> tipoActividades=session.createQuery("FROM TbTipoActividad").list();
			session.flush();
			return tipoActividades;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado docentes");
			throw expDao;
		}
		finally{
			//session.close();
		}
	}

}
