import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import {DocenteSemestreCurso} from "../../modelo/actividades/docente-semestre-curso";

@Injectable()
export class DscService {
    // private semestreUrl = 'http://localhost:8084/ActividadesWeb/rest/dsc/{0}/{1}'; 
    
    constructor(private http: Http) { }
    
    consultarCursosSemestre(docente:Number,semestreCurso:Number): Observable<DocenteSemestreCurso[]> {
        
        var semestreUrl = `http://localhost:8084/ActividadesWeb/rest/dsc/consultar/${docente}/${semestreCurso}`; 
        return this.http.get(semestreUrl)
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