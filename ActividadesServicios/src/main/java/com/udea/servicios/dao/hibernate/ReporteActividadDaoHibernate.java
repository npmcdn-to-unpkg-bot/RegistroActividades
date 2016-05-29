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
		try {
			session = getSession();
			if (reporteActividad.getNbId() <= 0) {
				session.save(reporteActividad);
			} else {
				session.update(reporteActividad);
			}

			session.flush();
		} catch (Exception e) {
			// Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error almacenando reporte actividad");
			throw expDao;
		} finally {
			session.close();
		}

	}

	public List<TbReporteActividad> consultar(Date fechaInicialSemana, Date fechaFinalSemana) throws ExcepcionDao {
		Session session = null;
		try {
			session = getSession();

			StringBuilder hqlString = new StringBuilder();
			hqlString.append("FROM TbReporteActividad as ra ");
			hqlString.append("WHERE ra.dtFecha BETWEEN :fechaInicial AND :fechaFinal ");
			hqlString.append("ORDER BY ra.dtFecha DESC");

			Query query = session.createQuery(hqlString.toString());
			query.setDate("fechaInicial", fechaInicialSemana);
			query.setDate("fechaFinal", fechaFinalSemana);

			List<TbReporteActividad> reporteActividades = query.list();

			session.flush();
			return reporteActividades;
		} catch (Exception e) {
			// Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado reporte de actividades");
			throw expDao;
		} finally {
			// session.close();
		}
	}

	public TbReporteActividad consultarPorId(long idActividad) throws ExcepcionDao {
		Session session = null;
		try {
			session = getSession();

			StringBuilder hqlString = new StringBuilder();
			hqlString.append("FROM TbReporteActividad as ra ");
			hqlString.append("WHERE ra.nbId=:id");

			Query query = session.createQuery(hqlString.toString());
			query.setLong("id", idActividad);

			List<TbReporteActividad> reporteActividades = query.list();
			TbReporteActividad reporteActividad = null;
			if (reporteActividades.size() > 0) {
				reporteActividad = reporteActividades.get(0);
			}
			session.flush();
			return reporteActividad;
		} catch (Exception e) {
			// Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado reporte de actividades");
			throw expDao;
		} finally {
			// session.close();

		}
	}

	public void eliminar(long idActividad) throws ExcepcionDao {
		Session session = null;
		try {
			session = getSession();
			TbReporteActividad reporteActividad = this.consultarPorId(idActividad);
			session.delete(reporteActividad);
			session.flush();
		} catch (Exception e) {
			// Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultado reporte de actividades");
			throw expDao;
		} finally {
			session.close();
		}
	}
}
