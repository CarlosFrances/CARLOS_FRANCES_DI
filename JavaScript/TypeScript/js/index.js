//tsc index.ts --watch
var alumno = /** @class */ (function () {
    function alumno(nombre, apellido, dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    alumno.prototype.mostrarDatos = function () {
        console.log("Nombre: ".concat(this.nombre));
        console.log("Apellido: ".concat(this.apellido));
        console.log("DNI: ".concat(this.dni));
    };
    Object.defineProperty(alumno.prototype, "getNombre", {
        get: function () {
            return this.nombre;
        },
        enumerable: false,
        configurable: true
    });
    return alumno;
}());
var alumnoObjeto = new alumno("carlos", "frances", "48760807W");
console.log(alumnoObjeto.getNombre);
var nombre = "carlos";
var edad;
var experiencia;
var asignaturas;
var randy;
var sinValor;
console.log("Valor del nombre ".concat(nombre));
function sumar(param1, param2) {
    console.log("La suma de ".concat(param1, " y ").concat(param2, " es ").concat(param1 + param2));
}
function paramentrosOptativos(param1, param2, param3) {
    if (param3 === void 0) { param3 = 0; }
    console.log("Los parametros son: ".concat(param1, ", ").concat(param2, ", ").concat(param3));
}
function parametrosMultiple(param1, param2) {
    var param3 = [];
    for (var _i = 2; _i < arguments.length; _i++) {
        param3[_i - 2] = arguments[_i];
    }
    console.log("Los parametros son: ".concat(param1, ", ").concat(param2));
    param3.length > 0 && param3.forEach(function (element) {
        console.log(element);
    });
}
//sumar(3, 4);
//paramentrosOptativos("a", "b")
parametrosMultiple("uno", 2, 8, 7, 5, 4, 5, 6, false, true, "aaa");
