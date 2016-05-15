import { Component, OnInit } from '@angular/core';
import {Actividad} from '../../modelo/actividades/actividad';
import {Docente} from '../../modelo/actividades/docente';
import {DocenteService} from '../../servicios/actividades/docente.service';
import {TipoActividad} from '../../modelo/actividades/tipo-actividad';
import {TipoActividadService} from '../../servicios/actividades/tipo-actividad.service';

@Component({
  selector: 'registro-actividad',
  templateUrl: 'app/modulos/actividades/registro-actividad.component.html',
  styleUrls: ['recursos/css/forms.css']
})
export class RegistroActividadComponent implements OnInit {

  constructor(private docenteService: DocenteService, private tipoActividadService: TipoActividadService) { }

  modelo = new Actividad();
  activo = true;
  docentes: Docente[];
  tipoActividades:TipoActividad[];
  mensajeError: string;

  ngOnInit() {
    this.consultarDocentes();
    this.consultarTipoActividades();
  }

  consultarDocentes() {
    this.docenteService.consultarDocentes()
      .subscribe(docentes => this.docentes = docentes,
      error => this.mensajeError = <any>error);
  }
  
  consultarTipoActividades(){
    this.tipoActividadService.consultaTipoActividades()
      .subscribe(tipoActividades => this.tipoActividades = tipoActividades,
      error => this.mensajeError = <any>error);
  }
}
