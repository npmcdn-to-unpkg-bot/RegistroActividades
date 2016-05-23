import { Component } from '@angular/core';
import { RouteParams } from '@angular/router-deprecated';

@Component({
  selector: 'consulta-actividad',
  templateUrl: 'app/modulos/actividades/consulta-actividad.component.html'
})
export class ConsultaActividadComponent{
  constructor(
	  private _routeParams: RouteParams) {	}
  
}