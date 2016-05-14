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
var actividad_1 = require('../../modelo/actividades/actividad');
var docente_service_1 = require('../../servicios/actividades/docente.service');
var RegistroActividadComponent = (function () {
    function RegistroActividadComponent(docenteService) {
        this.docenteService = docenteService;
        this.modelo = new actividad_1.Actividad();
        this.activo = true;
    }
    RegistroActividadComponent.prototype.ngOnInit = function () { this.consultarDocentes(); };
    RegistroActividadComponent.prototype.consultarDocentes = function () {
        var _this = this;
        this.docenteService.consultarDocentes()
            .subscribe(function (docentes) { return _this.docentes = docentes; }, function (error) { return _this.mensajeError = error; });
    };
    RegistroActividadComponent = __decorate([
        core_1.Component({
            selector: 'registro-actividad',
            templateUrl: 'app/modulos/actividades/registro-actividad.component.html',
            styleUrls: ['recursos/css/forms.css']
        }), 
        __metadata('design:paramtypes', [docente_service_1.DocenteService])
    ], RegistroActividadComponent);
    return RegistroActividadComponent;
}());
exports.RegistroActividadComponent = RegistroActividadComponent;
//# sourceMappingURL=registro-actividad.component.js.map