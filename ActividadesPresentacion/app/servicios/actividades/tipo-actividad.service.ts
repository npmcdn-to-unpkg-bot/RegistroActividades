import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import {TipoActividad} from "../../modelo/actividades/tipo-actividad";
@Injectable()
export class TipoActividadService {
    constructor(private http: Http) { }

    private tipoActividadUrl = 'http://localhost:8084/ActividadesWeb/tipoactividad/tipoactividad/consultar';  // URL to web api

    consultaTipoActividades(): Observable<TipoActividad[]> {
        return this.http.get(this.tipoActividadUrl)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        if (res.status < 200 || res.status >= 300) {
            throw new Error('Bad response status: ' + res.status);
        }
        let body = res.json();
        return body || [];
    }
    private handleError(error: any) {
        // In a real world app, we might send the error to remote logging infrastructure
        let errMsg = error.message || 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}