import { Component, OnInit } from '@angular/core';
import { RouteParams, Router } from '@angular/router-deprecated';

import {ReporteActividadService} from '../../servicios/actividades/reporte-actividad.service';
import {ReporteActividad} from '../../modelo/actividades/reporte-actividad';
import {Semana} from '../../modelo/actividades/semana';

@Component({
  selector: 'consulta-actividad',
  templateUrl: 'app/modulos/actividades/consulta-actividad.component.html'
})
export class ConsultaActividadComponent implements OnInit {

  actividades: ReporteActividad[];
  mensajeError: string;
  semana: Semana;

  constructor(
    private actividadService: ReporteActividadService
    , private routeParams: RouteParams
    , private router: Router) {
    this.semana = new Semana();
  }



  ngOnInit() {
    let fechaActividad = new Date();
    if (this.routeParams.get("fecha") != null) {
      fechaActividad = new Date(this.routeParams.get("fecha"));
    }
    this.consultar(fechaActividad, 0);
  }

  consultarActividades(fechaActividad: Date) {
    this.actividadService.consultarAcividades(fechaActividad)
      .subscribe(actividades => this.actividades = actividades,
      error => this.mensajeError = error);

  }

  consultarSemana(fechaActividad: Date) {
    this.actividadService.consultarSemana(fechaActividad)
      .subscribe(semana => this.semana = semana,
      error => this.mensajeError = error);
  }

  consultar(fechaActividad: any, incrementar: any) {
    let milisegundos: any;
    if (fechaActividad.getTime) {
      milisegundos = fechaActividad.getTime() + (incrementar * 1000 * 60 * 60 * 24);
    } else {
      milisegundos = fechaActividad + (incrementar * 1000 * 60 * 60 * 24);
    }
    let fechaModificada = new Date(milisegundos);
    this.consultarActividades(fechaModificada);
    this.consultarSemana(fechaModificada);
  }

  editar(idActividad: Number) {
    this.router.navigate(["EdicionActividad", { id: idActividad }]);
  }

  eliminar(idActividad: Number) {
    if (confirm("¿Esta seguro que desea eliminar la actividad?")) {
      this.actividadService.eliminarActividad(idActividad).subscribe(
        resultado => this.postEliminar(resultado)
        , error => this.mensajeError = error
      )
    }
  }

  private postEliminar(resultado: Boolean) {
    this.consultarActividades(this.semana.fechaFinal);
  }
}