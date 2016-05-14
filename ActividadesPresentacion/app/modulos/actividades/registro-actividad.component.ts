import { Component, OnInit } from '@angular/core';
import {Actividad} from '../../modelo/actividades/actividad';
import {Docente} from '../../modelo/actividades/docente';
import {DocenteService} from '../../servicios/actividades/docente.service';

@Component({
  selector: 'registro-actividad',
  templateUrl: 'app/modulos/actividades/registro-actividad.component.html',
  styleUrls: ['recursos/css/forms.css']
})
export class RegistroActividadComponent implements OnInit{
  
  constructor(private docenteService: DocenteService) { }
  
  modelo = new Actividad();
  activo = true;
  docentes:Docente[];
  mensajeError:string;
  
  ngOnInit() { this.consultarDocentes(); }
  
  consultarDocentes(){
    this.docenteService.consultarDocentes()
                        .subscribe(docentes=>this.docentes=docentes,
                                   error=> this.mensajeError=<any>error);
  }
}
