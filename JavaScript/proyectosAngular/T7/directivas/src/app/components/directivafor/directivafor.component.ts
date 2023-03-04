import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css']
})
export class DirectivaforComponent {

  coleccionElementos: string[] = [
    "elemento 1",
    "elemento 2",
    "elemento 3",
    "elemento 4",
    "elemento 5",
    "elemento 6",
    "elemento 3",
    "elemento 4",
    "elemento 5",
    "elemento 6",
    "elemento 3",
    "elemento 4",
    "elemento 5",
    "elemento 6",
  ]

  coleccionFiltrada: string[] = []
  texto: string = ""

  agregar(input: string) {
    this.coleccionElementos.unshift(input)
  }

  filtrar(input: string) {
    this.filtrando = true;
    this.coleccionFiltrada = []
    this.coleccionFiltrada = this.coleccionElementos.filter((item) => item.includes(input.toString()))
    this.texto = this.coleccionFiltrada.length.toString()
  }

  filtrando = false;

}
