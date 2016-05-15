package com.udea.servicios.ngc;

import java.util.List;

import com.ctrlz.util.excepcion.ExcepcionNgc;
import com.udea.dominio.dto.TbDocenteSemestreCurso;

public interface DocenteSemestreCursoNgcInt {
	public List<TbDocenteSemestreCurso> consultar(long docente,int semestre) throws ExcepcionNgc;
}
