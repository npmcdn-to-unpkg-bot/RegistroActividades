"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var reporte_actividad_1 = require('../../modelo/actividades/reporte-actividad');
var docente_service_1 = require('../../servicios/actividades/docente.service');
var tipo_actividad_service_1 = require('../../servicios/actividades/tipo-actividad.service');
var semestre_service_1 = require('../../servicios/actividades/semestre.service');
var dsc_service_1 = require('../../servicios/actividades/dsc.service');
var reporte_actividad_service_1 = require('../../servicios/actividades/reporte-actividad.service');
var RegistroActividadComponent = (function () {
    function RegistroActividadComponent(docenteService, tipoActividadService, semestreService, dscService, actividadService) {
        this.docenteService = docenteService;
        this.tipoActividadService = tipoActividadService;
        this.semestreService = semestreService;
        this.dscService = dscService;
        this.actividadService = actividadService;
        this.modelo = new reporte_actividad_1.ReporteActividad();
        this.activo = true;
    }
    RegistroActividadComponent.prototype.ngOnInit = function () {
        this.consultarDocentes();
        this.consultarTipoActividades();
        this.consultarSemestres();
    };
    RegistroActividadComponent.prototype.consultarDocentes = function () {
        var _this = this;
        this.docenteService.consultarDocentes()
            .subscribe(function (docentes) { return _this.docentes = docentes; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent.prototype.consultarTipoActividades = function () {
        var _this = this;
        this.tipoActividadService.consultaTipoActividades()
            .subscribe(function (tipoActividades) { return _this.tipoActividades = tipoActividades; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent.prototype.consultarSemestres = function () {
        var _this = this;
        this.semestreService.consultarSemestres()
            .subscribe(function (semestres) { return _this.semestres = semestres; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent.prototype.consultarCursosSemestre = function (docente, semestreCurso) {
        var _this = this;
        this.dscService.consultarCursosSemestre(docente, semestreCurso)
            .subscribe(function (semestreCursos) { return _this.semestreCursos = semestreCursos; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent.prototype.onDocenteSemestreChange = function () {
        if (this.idDocente != undefined && this.idSemestre != undefined) {
            if (this.idDocente > 0 && this.idSemestre > 0) {
                this.consultarCursosSemestre(this.idDocente, this.idSemestre);
            }
            else {
                this.borrarListadoCursosSemestre();
            }
        }
        else {
            this.borrarListadoCursosSemestre();
        }
    };
    RegistroActividadComponent.prototype.borrarListadoCursosSemestre = function () {
        if (this.semestreCursos != undefined && this.semestreCursos.length > 0) {
            this.semestreCursos.length = 0;
        }
    };
    RegistroActividadComponent.prototype.guardarRegistroActividad = function () {
        var _this = this;
        this.actividadService.reportarActividad(this.modelo)
            .subscribe(function (resultado) { return _this.resultadoGuardado = resultado; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent = __decorate([
        core_1.Component({
            selector: 'registro-actividad',
            templateUrl: 'app/modulos/actividades/registro-actividad.component.html',
            styleUrls: ['recursos/css/forms.css']
        }), 
        __metadata('design:paramtypes', [docente_service_1.DocenteService, tipo_actividad_service_1.TipoActividadService, semestre_service_1.SemestreService, dsc_service_1.DscService, reporte_actividad_service_1.ReporteActividadService])
    ], RegistroActividadComponent);
    return RegistroActividadComponent;
}());
exports.RegistroActividadComponent = RegistroActividadComponent;
//# sourceMappingURL=registro-actividad.component.js.map