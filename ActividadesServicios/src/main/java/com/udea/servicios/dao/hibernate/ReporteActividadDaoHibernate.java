package com.udea.servicios.dao.hibernate;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbReporteActividad;
import com.udea.servicios.dao.ReporteActividadDaoInt;

public class ReporteActividadDaoHibernate extends HibernateDaoSupport implements ReporteActividadDaoInt {

	public void registrar(TbReporteActividad reporteActividad) throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			session.save(reporteActividad);
			session.flush(); 
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error almacenando reporte actividad");
			throw expDao;
		}
		finally{
			session.close();
		}
		
	}

}
