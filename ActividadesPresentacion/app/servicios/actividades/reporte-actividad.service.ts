import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import {ReporteActividad} from "../../modelo/actividades/reporte-actividad";

@Injectable()
export class ReporteActividadService {
    
    constructor(private http: Http) { }

    private serviceUrl = 'http://localhost:8084/ActividadesWeb/rest/reporteactividad/registrar';

    reportarActividad(datosActividad: ReporteActividad):Observable<Boolean> {
        let datos = JSON.stringify(datosActividad);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let opciones = new RequestOptions({ headers: headers });
        return this.http.post(this.serviceUrl, datos, opciones)
            .map(this.construirResultado)
            .catch(this.menejarError);
    }

    private construirResultado() {
        return true;
    }

    private menejarError(error: any) {
        let errMsg = error.message || error.statusText || 'Error reportando actividad';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }

}