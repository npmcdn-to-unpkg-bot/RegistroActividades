package com.udea.servicios.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbSemestre;
import com.udea.servicios.dao.SemestreDaoInt;

public class SemestreDaoHibernate extends HibernateDaoSupport implements SemestreDaoInt {

	public List<TbSemestre> consultar() throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			List<TbSemestre> semestres=session.createCriteria(TbSemestre.class).list();
			session.flush();
			return semestres;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado semestres");
			throw expDao;
		}
		
	}

}
