import { Component } from '@angular/core';
import { AsignaturaInterfaz } from 'src/app/model/asignatura_interfazz';

@Component({
  selector: 'cursos-app-asignaturas',
  templateUrl: './app-asignaturas.component.html',
  styleUrls: ['./app-asignaturas.component.css']
})
export class AppAsignaturasComponent {

  buscando = false;

  constructor() {
    this.asignaturasFiltradas = this.asignaturas;
  }

  asignaturasFiltradas: AsignaturaInterfaz[] = [
    {
      nombre: "Programacion...Multimedia",
      siglas: "PMDM",
      horas: 9,
      curso: "DAM",
      ciclo: 2,
      imagen: "",
      conocimientos: ["a", "e", "i"]
    },
    {
      nombre: "Programacion",
      siglas: "PRO",
      horas: 7,
      curso: "DAM|DAW",
      ciclo: 1,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["2", "j", "i"]
    }, {
      nombre: "Asiradas1",
      siglas: "AS1",
      horas: 4,
      curso: "ASIR",
      ciclo: 1,
      imagen: "",
      conocimientos: ["as", "ir", "mola"]
    },
    {
      nombre: "Asiradas2",
      siglas: "AS2",
      horas: 2,
      curso: "ASIR",
      ciclo: 2,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["asir", "no", "mola"]
    },
    {
      nombre: "Daweadas",
      siglas: "DAW1",
      horas: 9,
      curso: "DAW",
      ciclo: 1,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["daw", ",ola", "aa"]
    },
    {
      nombre: "Daweadas2",
      siglas: "DAW",
      horas: 6,
      curso: "DAW",
      ciclo: 2,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["yess", "noo", "t"]
    }
  ];

  filtrarConocimientos(conocimiento: string) {
    this.asignaturasFiltradas = this.asignaturasFiltradas.filter((item) => {
      return item.conocimientos.find((item2) => {
        return item2 == conocimiento;
      })
      /*return item.conocimientos.filter((item2)=>{
        return item2 == conocimiento;
      })*/
    })
  }

  filtrarAsignaturas(ciclo: string, curso: string) {
    this.asignaturasFiltradas = this.asignaturas.filter((item) => item.curso.includes(curso) && item.ciclo == Number(ciclo))
  }

  asignaturas: AsignaturaInterfaz[] = [
    {
      nombre: "Programacion...Multimedia",
      siglas: "PMDM",
      horas: 9,
      curso: "DAM",
      ciclo: 2,
      imagen: "",
      conocimientos: ["a", "e", "i"]
    },
    {
      nombre: "Programacion",
      siglas: "PRO",
      horas: 7,
      curso: "DAM|DAW",
      ciclo: 1,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["2", "j", "i"]
    }, {
      nombre: "Asiradas1",
      siglas: "AS1",
      horas: 4,
      curso: "ASIR",
      ciclo: 1,
      imagen: "",
      conocimientos: ["as", "ir", "mola"]
    },
    {
      nombre: "Asiradas2",
      siglas: "AS2",
      horas: 2,
      curso: "ASIR",
      ciclo: 2,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["asir", "no", "mola"]
    },
    {
      nombre: "Daweadas",
      siglas: "DAW1",
      horas: 9,
      curso: "DAW",
      ciclo: 1,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["daw", ",ola", "aa"]
    },
    {
      nombre: "Daweadas2",
      siglas: "DAW",
      horas: 6,
      curso: "DAW",
      ciclo: 2,
      imagen: "https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp",
      conocimientos: ["yess", "noo", "t"]
    }
  ]

}
