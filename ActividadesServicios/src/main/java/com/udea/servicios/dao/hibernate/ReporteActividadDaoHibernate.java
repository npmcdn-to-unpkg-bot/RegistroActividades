package com.udea.servicios.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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

	public List<TbReporteActividad> consultar(Date fechaInicialSemana,Date fechaFinalSemana) throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			
			StringBuilder hqlString=new StringBuilder();
			hqlString.append("FROM TbTipoActividad ");
			hqlString.append("WHERE dtFecha BETWEEN :fechaInicial AND :fechaFinal");
			
			Query query=session.createQuery(hqlString.toString());
			query.setDate("fechaInicial", fechaInicialSemana);
			query.setDate("fechaFinal", fechaFinalSemana);
			
			List<TbReporteActividad> tipoActividades=query.list();
			
			session.flush();
			return tipoActividades;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado reporte de actividades");
			throw expDao;
		}
		finally{
			//session.close();
		}
	}

}
