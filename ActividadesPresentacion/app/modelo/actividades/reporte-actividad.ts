import {DocenteSemestreCurso} from "./docente-semestre-curso";
import {TipoActividad} from "./tipo-actividad";

export class ReporteActividad{
    constructor(){
        this.tbDocenteSemestreCurso=new DocenteSemestreCurso();
        this.tbTipoActividad=new TipoActividad();
    }
    nbId:Number;
    tbDocenteSemestreCurso:DocenteSemestreCurso;
    tbTipoActividad:TipoActividad;
    dtFecha:Date;
    nbHoras:Number;
    vrDescripcion:String;
    
}