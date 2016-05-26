import { Component,OnInit } from '@angular/core';
import { RouteParams } from '@angular/router-deprecated';

import {ReporteActividadService} from '../../servicios/actividades/reporte-actividad.service';
import {ReporteActividad} from '../../modelo/actividades/reporte-actividad';

@Component({
  selector: 'consulta-actividad',
  templateUrl: 'app/modulos/actividades/consulta-actividad.component.html'
})
export class ConsultaActividadComponent implements OnInit{
  constructor(
    private actividadService:ReporteActividadService,
	  private routeParams: RouteParams) {	}
  
  actividades:ReporteActividad[];
  mensajeError: string;
  
  ngOnInit() {
    let fechaActividad=new Date();
    if(this.routeParams.get("fechaActividad")!=null){
       fechaActividad=new Date(this.routeParams.get("fechaActividad"));
    }
    this.consultarActividades(fechaActividad);
  }
  
  consultarActividades(fechaActividad:Date){
    this.actividadService.consultarAcividades(fechaActividad)
        .subscribe(actividades=>this.actividades=actividades,
                  error=>this.mensajeError=error);
        
  }  
}