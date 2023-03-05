import { Component } from '@angular/core';
import { AsignaturasService } from 'src/app/service/asignaturas.service';
import { AlumnoInterfaz } from 'src/app/model/alumno_interfaz';
import { Alumno } from 'src/app/model/Alumno';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent {

  ciclos: string[];
  universidad: string[];
  bachiller: string[];
  opcion: number = 0;
  alumnos: Alumno[] = []

  constructor(private servicio: AsignaturasService) {
    this.ciclos = servicio.getAllCiclos();
    this.universidad = servicio.getAllUniversidad();
    this.bachiller = servicio.getAllBachiller();
  }



  cambioRadio(evento: any) {
    this.opcion = Number(evento.target.value)
  }

  agregarAlumno(nombre: string, apellido: string, edad: string, estudios: string, procedencia: string, destino: string) {
    let nedad = Number(edad);
    this.alumnos.push(new Alumno(nombre, apellido, nedad, estudios, procedencia, destino));
    console.log(this.alumnos)
  }

  contar(estudios: string) {
    return this.alumnos.filter(
      (item) => item.estudios == estudios
    ).length;
  }
}
