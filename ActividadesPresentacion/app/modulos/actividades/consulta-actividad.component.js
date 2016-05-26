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
var router_deprecated_1 = require('@angular/router-deprecated');
var reporte_actividad_service_1 = require('../../servicios/actividades/reporte-actividad.service');
var ConsultaActividadComponent = (function () {
    function ConsultaActividadComponent(actividadService, routeParams) {
        this.actividadService = actividadService;
        this.routeParams = routeParams;
    }
    ConsultaActividadComponent.prototype.ngOnInit = function () {
        var fechaActividad = new Date();
        if (this.routeParams.get("fechaActividad") != null) {
            fechaActividad = new Date(this.routeParams.get("fechaActividad"));
        }
        this.consultarActividades(fechaActividad);
    };
    ConsultaActividadComponent.prototype.consultarActividades = function (fechaActividad) {
        var _this = this;
        this.actividadService.consultarAcividades(fechaActividad)
            .subscribe(function (actividades) { return _this.actividades = actividades; }, function (error) { return _this.mensajeError = error; });
    };
    ConsultaActividadComponent = __decorate([
        core_1.Component({
            selector: 'consulta-actividad',
            templateUrl: 'app/modulos/actividades/consulta-actividad.component.html'
        }), 
        __metadata('design:paramtypes', [reporte_actividad_service_1.ReporteActividadService, router_deprecated_1.RouteParams])
    ], ConsultaActividadComponent);
    return ConsultaActividadComponent;
}());
exports.ConsultaActividadComponent = ConsultaActividadComponent;
//# sourceMappingURL=consulta-actividad.component.js.map