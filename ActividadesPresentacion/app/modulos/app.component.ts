import {Component} from '@angular/core';
import { RegistroActividadComponent } from './actividades/registro-actividad.component';
import { ConsultaActividadComponent  } from './actividades/consulta-actividad.component';
import {DocenteService} from "../servicios/actividades/docente.service";
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';
import { HTTP_PROVIDERS }    from '@angular/http';
@Component({
    selector: 'my-app',
    templateUrl:"app/modulos/app.component.html",
    directives: [ROUTER_DIRECTIVES],
	providers: [
	  ROUTER_PROVIDERS,DocenteService,HTTP_PROVIDERS
	]
})
@RouteConfig([
  {
	path: '/registroactividad',
	name: 'RegistroActividad',
	component: RegistroActividadComponent,
	useAsDefault: true
  },
  {
	path: '/consultaactividad',
	name: 'ConsultaActividad',
	component: ConsultaActividadComponent
  }
])
export class AppComponent { }