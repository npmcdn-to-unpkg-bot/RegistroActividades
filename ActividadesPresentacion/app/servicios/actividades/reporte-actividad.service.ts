import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import {ReporteActividad} from "../../modelo/actividades/reporte-actividad";
import {ReporteActividadLight} from "../../modelo/actividades/reporte-actividad-light";
import {Semana} from "../../modelo/actividades/semana";

@Injectable()
export class ReporteActividadService {
    
    constructor(private http: Http) { }

    private serviceUrl = 'http://localhost:8084/ActividadesWeb/rest/reporteactividad/registrar';
    private serviceUrlConsultar='http://localhost:8084/ActividadesWeb/rest/reporteactividad/consultar';
    private serviceUrlConsultarSemana='http://localhost:8084/ActividadesWeb/rest/reporteactividad/consultarSemana';
    reportarActividad(datosActividad: ReporteActividadLight):Observable<Boolean> {
        let datos = JSON.stringify(datosActividad);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let opciones = new RequestOptions({ headers: headers });
        return this.http.post(this.serviceUrl, datos, opciones)
            .map(this.construirResultadoReportar)
            .catch(this.menejarError);
    }

    private construirResultadoReportar() {
        return true;
    }

    private menejarError(error: any) {
        let errMsg = error.message || error.statusText || 'Error en servicio de actividades';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
    
    consultarAcividades(fecha:Date): Observable<ReporteActividad[]>{
        let datos = JSON.stringify(fecha);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let opciones = new RequestOptions({ headers: headers });
        return this.http.post(this.serviceUrlConsultar, datos, opciones)
            .map(this.construirResultadoListado)
            .catch(this.menejarError);
    }
    
    private construirResultadoListado(res:Response){
        if (res.status < 200 || res.status >= 300) {
            throw new Error('Bad response status: ' + res.status);
        }
        let body = res.json();
        return body || [];
    }
    
    consultarSemana(fecha:Date):Observable<Semana>
    {
        let datos = JSON.stringify(fecha);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let opciones = new RequestOptions({ headers: headers });
        return this.http.post(this.serviceUrlConsultarSemana, datos, opciones)
            .map(this.construirResultadoEntidad)
            .catch(this.menejarError);
    }
    
    private construirResultadoEntidad(res:Response){
        if (res.status < 200 || res.status >= 300) {
            throw new Error('Bad response status: ' + res.status);
        }
        let body = res.json();
        return body || {};
    }

}