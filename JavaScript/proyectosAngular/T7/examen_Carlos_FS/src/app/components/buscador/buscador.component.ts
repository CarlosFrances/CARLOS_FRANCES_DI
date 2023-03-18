import { Component } from '@angular/core';
import { Vehiculo } from 'src/app/model/Vehiculo';
import { ServicioVehiculosService } from 'src/app/services/servicio-vehiculos.service';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent {

  marca: string = "";
  cv: number = -1;

  buscado = false;

  vehiculos: Vehiculo[] = []

  constructor(private servicio: ServicioVehiculosService) {
    this.buscado = false;
  }

  buscarVehiculos(marca: any, cv: any) {
    this.vehiculos = this.servicio.buscarVehiculos(marca, cv)
    this.buscado = true
  }

}
