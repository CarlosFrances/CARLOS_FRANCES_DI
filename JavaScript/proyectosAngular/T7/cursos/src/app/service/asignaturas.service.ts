import { Injectable } from '@angular/core';
import { AsignaturaInterfaz } from '../model/asignatura_interfazz';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

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

  constructor() { }

  getAllAsignaturas(): AsignaturaInterfaz[] {
    return this.asignaturas
  }

  getAsignaturasCursoCiclo(): AsignaturasInterfaz[] {
    return this.asignaturas.filter((item) => item.curso.includes(curso) && item.ciclo == Number(ciclo))

  }
}
