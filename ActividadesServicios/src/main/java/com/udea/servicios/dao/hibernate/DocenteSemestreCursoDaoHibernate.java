package com.udea.servicios.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ctrlz.util.excepcion.ExcepcionDao;
import com.udea.dominio.dto.TbDocenteSemestreCurso;
import com.udea.servicios.dao.DocenteSemestreCursoDaoInt;

public class DocenteSemestreCursoDaoHibernate extends HibernateDaoSupport implements DocenteSemestreCursoDaoInt {

	public List<TbDocenteSemestreCurso> consultar(long docente, int semestre) throws ExcepcionDao {
		Session session = null;
		try{
			session = getSession();
			StringBuilder hqlString=new StringBuilder();
			hqlString.append("FROM TbDocenteSemestreCurso dsc");
			hqlString.append(" WHERE dsc.tbSemestreCurso.nbId=:idSemestre");
			hqlString.append(" AND dsc.tbDocente.nbId=:idDocente");
			Query query = session.createQuery(hqlString.toString());
			query.setInteger("idSemestre", semestre);
			query.setLong("idDocente",docente);
			List<TbDocenteSemestreCurso> cursos=query.list();
			session.flush(); 
			return cursos;
		}catch(Exception e){
			//Rollback
			ExcepcionDao expDao = new ExcepcionDao();
			expDao.setExcepcionOrigen(e);
			expDao.setMensajeUsuario("Error consultando docente semestre curso");
			throw expDao;
		}
	}

}
