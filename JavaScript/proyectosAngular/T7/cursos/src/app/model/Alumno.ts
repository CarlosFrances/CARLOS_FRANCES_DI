export class Alumno {
  nombre: string;
  apellido: string;
  edad: number;
  estudios: string;
  procedencia: string;
  destino: string;

  constructor(nombre: string, apellido: string, edad: number, estudios: string, procedencia: string, destino: string) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.estudios = estudios;
    this.procedencia = procedencia;
    this.destino = destino;
  }
}
