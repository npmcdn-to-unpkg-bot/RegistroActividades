package com.udea.servicios.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbDocente;
import com.udea.servicios.dao.DocenteDaoInt;

public class DocenteDaoHibernate extends HibernateDaoSupport implements DocenteDaoInt {

	public List<TbDocente> consultarDocentes() throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			List<TbDocente> docentes=session.createQuery("FROM TbDocente").list();
			session.flush();
			return docentes;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado docentes");
			throw expDao;
		}
		finally{
			session.close();
		}
	}

}
