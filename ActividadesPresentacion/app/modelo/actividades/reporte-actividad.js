"use strict";
var docente_semestre_curso_1 = require("./docente-semestre-curso");
var tipo_actividad_1 = require("./tipo-actividad");
var ReporteActividad = (function () {
    function ReporteActividad() {
        this.tbDocenteSemestreCurso = new docente_semestre_curso_1.DocenteSemestreCurso();
        this.tbTipoActividad = new tipo_actividad_1.TipoActividad();
    }
    return ReporteActividad;
}());
exports.ReporteActividad = ReporteActividad;
//# sourceMappingURL=reporte-actividad.js.map