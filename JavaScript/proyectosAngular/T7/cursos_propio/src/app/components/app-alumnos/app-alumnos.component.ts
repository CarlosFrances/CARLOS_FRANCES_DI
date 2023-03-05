import { Component } from '@angular/core';

@Component({
  selector: 'cursos-app-alumnos',
  templateUrl: './app-alumnos.component.html',
  styleUrls: ['./app-alumnos.component.css']
})
export class AppAlumnosComponent {
  opcion: number = 0;

  cambioRadio(evento: any) {
    this.opcion = Number(evento.target.value)
  }
}
