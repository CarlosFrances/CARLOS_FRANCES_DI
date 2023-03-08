import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { AsignaturaInterfaz } from 'src/app/model/asignatura_interfaz';
import { AsignaturasService } from 'src/app/service/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  // ActivatedRoute

  curso: string = ""
  asignaturas: AsignaturaInterfaz[] = []

  constructor(private gestorRutas: ActivatedRoute, private servicio: AsignaturasService) {
    gestorRutas.params.subscribe((parametros: Params) => {
      this.curso = parametros["curso"];
      this.asignaturas = servicio.getAsignaturasCiclo(this.curso);
      console.log(this.curso);
    })
  }

}
