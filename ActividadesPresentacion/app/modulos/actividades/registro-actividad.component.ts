import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router-deprecated';

import {Actividad} from '../../modelo/actividades/actividad';
import {Docente} from '../../modelo/actividades/docente';
import {TipoActividad} from '../../modelo/actividades/tipo-actividad';
import {Semestre} from '../../modelo/actividades/semestre';
import {DocenteSemestreCurso} from '../../modelo/actividades/docente-semestre-curso';
import {ReporteActividadLight} from '../../modelo/actividades/reporte-actividad-light';

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
    , private actividadService:ReporteActividadService
    , private router:Router) {
        this.construirModelo();
     }

  modelo:ReporteActividadLight;
  idDocente:Number;
  idSemestre:Number;
  activo = true;
  resultadoGuardado:Boolean;

  docentes: Docente[];
  tipoActividades: TipoActividad[];
  semestres: Semestre[];
  semestreCursos: DocenteSemestreCurso[];

  mensajeError: string;
  mensajeSatisfactorio:string;

  ngOnInit() {
    this.consultarDocentes();
    this.consultarTipoActividades();
    this.consultarSemestres();
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
    this.dscService.consultarCursosSemestre(docente,semestreCurso)
      .subscribe(semestreCursos => this.semestreCursos = semestreCursos,
      error => this.mensajeError = <any>error);
  }
  
  onDocenteSemestreChange(){
    if(this.idDocente != undefined && this.idSemestre!=undefined){
      if(this.idDocente>0 && this.idSemestre>0){
        this.consultarCursosSemestre(this.idDocente,this.idSemestre);
      }else{
        this.borrarListadoCursosSemestre();
      }
    }else{
      this.borrarListadoCursosSemestre();
    }
  }
  
  private borrarListadoCursosSemestre(){
      if(this.semestreCursos!=undefined && this.semestreCursos.length>0){
        this.semestreCursos.length=0;
      }
  }
  
  guardarRegistroActividad(){
      this.ocultarMensajeError();
      this.actividadService.reportarActividad(this.modelo)
            .subscribe(resultado=>this.mostrarMensajeGuardadoSatisfactorio(resultado),
                       error=>this.mostrarMensajeError(error));
  }
  
  private mostrarMensajeGuardadoSatisfactorio(resultado){
    this.resultadoGuardado=resultado;
    this.construirModelo();
    this.router.navigate(["ConsultaActividad"]);
    // setTimeout(()=>this.ocultarMensajeGuardadoSatisfactorio(),5000);
  }
  
  private ocultarMensajeGuardadoSatisfactorio(){
    this.resultadoGuardado=null;
  }
  
  private mostrarMensajeError(mensajeError){
    this.mensajeError=mensajeError;
  }
  
  private ocultarMensajeError(){
    this.mensajeError=null;
  }
  
  private construirModelo(){
    this.modelo=new ReporteActividadLight();
    this.idDocente=null;
    this.idSemestre=null;
  }
  
}
