//tsc index.ts --watch

class alumno {

    constructor(private nombre, private apellido, private dni) { }
    mostrarDatos() {
        console.log(`Nombre: ${this.nombre}`);
        console.log(`Apellido: ${this.apellido}`);
        console.log(`DNI: ${this.dni}`);
    }

    get getNombre(): string {
        return this.nombre
    }

}

let alumnoObjeto = new alumno("carlos", "frances", "48760807W");
console.log(alumnoObjeto.getNombre);

let nombre: string = "carlos";
let edad: number;
let experiencia: boolean;
let asignaturas: string[];
let randy: any[];
let sinValor: undefined;

console.log(`Valor del nombre ${nombre}`);

function sumar(param1: number, param2: number) {
    console.log(`La suma de ${param1} y ${param2} es ${param1 + param2}`);
}

function paramentrosOptativos(param1: string, param2: string, param3: number = 0) {
    console.log(`Los parametros son: ${param1}, ${param2}, ${param3}`);
}

function parametrosMultiple(param1: string, param2: number, ...param3: any[]) {
    console.log(`Los parametros son: ${param1}, ${param2}`);
    param3.length > 0 && param3.forEach(element => {
        console.log(element);
    });
}

//sumar(3, 4);
//paramentrosOptativos("a", "b")
parametrosMultiple("uno", 2, 8, 7, 5, 4, 5, 6, false, true, "aaa")