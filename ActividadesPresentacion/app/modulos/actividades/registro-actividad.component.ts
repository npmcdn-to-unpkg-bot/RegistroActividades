import { Component, OnInit } from '@angular/core';
import { RouteParams, Router } from '@angular/router-deprecated';

import {Actividad} from '../../modelo/actividades/actividad';
import {Docente} from '../../modelo/actividades/docente';
import {TipoActividad} from '../../modelo/actividades/tipo-actividad';
import {Semestre} from '../../modelo/actividades/semestre';
import {DocenteSemestreCurso} from '../../modelo/actividades/docente-semestre-curso';
import {ReporteActividadLight} from '../../modelo/actividades/reporte-actividad-light';
import {ReporteActividad} from '../../modelo/actividades/reporte-actividad';

import {DocenteService} from '../../servicios/actividades/docente.service';
import {TipoActividadService} from '../../servicios/actividades/tipo-actividad.service';
import {SemestreService} from '../../servicios/actividades/semestre.service';
import {DscService} from '../../servicios/actividades/dsc.service';
import {ReporteActividadService} from '../../servicios/actividades/reporte-actividad.service';



@Component({
  selector: 'registro-actividad',
  templateUrl: 'app/modulos/actividades/registro-actividad.component.html',
  styleUrls: ['recursos/css/forms.css']
})
export class RegistroActividadComponent implements OnInit {

  constructor(private docenteService: DocenteService
    , private tipoActividadService: TipoActividadService
    , private semestreService: SemestreService
    , private dscService: DscService
    , private actividadService: ReporteActividadService
    , private router: Router
    , private routeParams: RouteParams) {
    this.construirModelo();
  }

  modelo: ReporteActividadLight;
  reporteActividad: ReporteActividad;
  idDocente: Number;
  idSemestre: Number;
  activo = true;

  docentes: Docente[];
  tipoActividades: TipoActividad[];
  semestres: Semestre[];
  semestreCursos: DocenteSemestreCurso[];

  mensajeError: string;
  mensajeSatisfactorio: string;

  esEdicion: Boolean;
  idActividad: Number;

  ngOnInit() {
    this.esEdicion = this.establecerFormularioParaEdicion();
    if (this.esEdicion == true) {
      this.consultarActividadPorId();
    }
    this.consultarDocentes();
    this.consultarTipoActividades();
    this.consultarSemestres();

  }

  establecerFormularioParaEdicion(): Boolean {
    let esEdicion = false;
    if (this.routeParams.get("id") != null) {
      this.idActividad = new Number(this.routeParams.get("id"));
      esEdicion = true;
    }

    return esEdicion;
  }

  consultarDocentes() {
    this.docenteService.consultarDocentes()
      .subscribe(docentes => this.docentes = docentes,
      error => this.mensajeError = <any>error);
  }

  consultarTipoActividades() {
    this.tipoActividadService.consultaTipoActividades()
      .subscribe(tipoActividades => this.tipoActividades = tipoActividades,
      error => this.mensajeError = <any>error);
  }

  consultarSemestres() {
    this.semestreService.consultarSemestres()
      .subscribe(semestres => this.semestres = semestres,
      error => this.mensajeError = <any>error);
  }

  consultarCursosSemestre(docente: Number, semestreCurso: Number) {
    this.dscService.consultarCursosSemestre(docente, semestreCurso)
      .subscribe(semestreCursos => this.postConsultarCursosSemestre(semestreCursos),
      error => this.mensajeError = <any>error);
  }

  postConsultarCursosSemestre(semestres: DocenteSemestreCurso[]) {
    this.semestreCursos = semestres;
    if (this.esEdicion == true) {
      this.cargarModeloReporteActividadEdicion();
    }
  }

  onDocenteSemestreChange() {
    if (this.idDocente != undefined && this.idSemestre != undefined) {
      if (this.idDocente > 0 && this.idSemestre > 0) {
        this.consultarCursosSemestre(this.idDocente, this.idSemestre);
      } else {
        this.borrarListadoCursosSemestre();
      }
    } else {
      this.borrarListadoCursosSemestre();
    }
  }

  guardarRegistroActividad() {
    this.ocultarMensajeError();
    let fecha = new Date(this.modelo.dtFecha.toString());
    this.modelo.dtFecha = new Date((fecha.getTime() + (1000 * 60 * 60 * 24)));
    this.actividadService.reportarActividad(this.modelo)
      .subscribe(resultado => this.postGuardarRegistroActividad(resultado),
      error => this.mostrarMensajeError(error));
  }

  consultarActividadPorId() {
    this.actividadService.consultarActividadPorId(this.idActividad).subscribe(
      actividad => this.postConsultaActividadPorId(actividad)
      , error => this.mostrarMensajeError(error)
    )
  }

  private cargarModeloReporteActividadEdicion() {
     this.idDocente=this.reporteActividad.tbDocenteSemestreCurso.tbDocente.nbId;
     this.idSemestre=this.reporteActividad.tbDocenteSemestreCurso.tbSemestreCurso.tbSemestre.nbId;
     
     this.modelo=new ReporteActividadLight();
     this.modelo.nbId=this.reporteActividad.nbId;
     this.modelo.idDocenteSemestreCurso=this.reporteActividad.tbDocenteSemestreCurso.nbId;
     this.modelo.idTipoActividad=this.reporteActividad.tbTipoActividad.nbId;
     this.modelo.dtFecha=this.reporteActividad.dtFecha;
     this.modelo.nbHoras=this.reporteActividad.nbHoras;
     this.modelo.vrDescripcion=this.reporteActividad.vrDescripcion;     
  }

  private borrarListadoCursosSemestre() {
    if (this.semestreCursos != undefined && this.semestreCursos.length > 0) {
      this.semestreCursos.length = 0;
    }
  }

  private postConsultaActividadPorId(actividad: ReporteActividad) {
    this.reporteActividad = actividad;
    this.consultarCursosSemestre(this.reporteActividad.tbDocenteSemestreCurso.tbDocente.nbId
      , this.reporteActividad.tbDocenteSemestreCurso.tbSemestreCurso.tbSemestre.nbId);
  }

  private postGuardarRegistroActividad(resultado) {
    let fechaString = this.modelo.dtFecha.toString();
    let fecha = new Date(fechaString);
    this.router.navigate(["ConsultaActividadFecha", { fecha: fecha.getTime() }]);
  }

  private mostrarMensajeError(mensajeError) {
    this.mensajeError = mensajeError;
  }

  private ocultarMensajeError() {
    this.mensajeError = null;
  }

  private construirModelo() {
    this.modelo = new ReporteActividadLight();
    this.idDocente = null;
    this.idSemestre = null;
  }

}
