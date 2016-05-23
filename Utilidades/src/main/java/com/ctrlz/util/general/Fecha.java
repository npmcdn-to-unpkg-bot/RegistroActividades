package com.ctrlz.util.general;

import java.util.Calendar;
import java.util.Date;

public class Fecha {
	public static Date getFechaInicialSemana(Date fecha){
		Calendar calendario=Fecha.getCalendario(fecha);
		int numeroSemana=calendario.get(Calendar.WEEK_OF_YEAR);
		
		Calendar fechaInicialSemana=Fecha.getCalendario(numeroSemana);
		
		return fechaInicialSemana.getTime();
	}
	
	public static Date getFechaFinalSemana(Date fechaInicialSemana){
		Calendar calendario=Fecha.getCalendario(fechaInicialSemana);
		calendario.add(Calendar.DATE, 6);
		return calendario.getTime();
	}
	
	public static Calendar getCalendario(Date fecha){
		Calendar calendario=Calendar.getInstance();
		calendario.setFirstDayOfWeek(Calendar.SUNDAY);
		calendario.set(Calendar.HOUR_OF_DAY,0);
		calendario.set(Calendar.MINUTE,0);
		calendario.set(Calendar.SECOND,0);
		calendario.set(Calendar.MILLISECOND,0);
		calendario.setTime(fecha);
		return calendario;
	}
	
	public static Calendar getCalendario(int numeroSemana){
		Calendar calendario=Calendar.getInstance();
		calendario.setFirstDayOfWeek(Calendar.SUNDAY);
		calendario.set(Calendar.WEEK_OF_YEAR,numeroSemana);
		calendario.set(Calendar.HOUR_OF_DAY,0);
		calendario.set(Calendar.MINUTE,0);
		calendario.set(Calendar.SECOND,0);
		calendario.set(Calendar.MILLISECOND,0);
		return calendario;
	}
}
