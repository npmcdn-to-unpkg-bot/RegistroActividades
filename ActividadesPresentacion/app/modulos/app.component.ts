import {Component} from '@angular/core';
import { RegistroActividadComponent } from './actividades/registro-actividad.component';
import { ConsultaActividadComponent  } from './actividades/consulta-actividad.component';
import {DocenteService} from "../servicios/actividades/docente.service";
import {TipoActividadService} from "../servicios/actividades/tipo-actividad.service";
import {SemestreService} from "../servicios/actividades/semestre.service";
import {DscService} from "../servicios/actividades/dsc.service";
import {ReporteActividadService} from "../servicios/actividades/reporte-actividad.service";
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';
import { HTTP_PROVIDERS }    from '@angular/http';
@Component({
    selector: 'my-app',
    templateUrl:"app/modulos/app.component.html",
    directives: [ROUTER_DIRECTIVES],
	providers: [
	  ROUTER_PROVIDERS
		,HTTP_PROVIDERS
		,DocenteService
		,TipoActividadService
		,SemestreService
		,DscService
		,ReporteActividadService
	]
})
@RouteConfig([
  {
	path: '/registroactividad',
	name: 'RegistroActividad',
	component: RegistroActividadComponent
  },
  {
	path: '/consultaactividad',
	name: 'ConsultaActividad',
	component: ConsultaActividadComponent
  },
	{
	path: '/consultaactividadfecha/:id',
	name: 'ConsultaActividadFecha',
	component: ConsultaActividadComponent
  },
])
export class AppComponent { }