import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Vehiculo } from 'src/app/model/Vehiculo';
import { ServicioVehiculosService } from 'src/app/services/servicio-vehiculos.service';

@Component({
  selector: 'app-vehiculos',
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css']
})
export class VehiculosComponent {

  tipo!: string;

  vehiculos: Vehiculo[] = []

  constructor(private gestorRutas: ActivatedRoute, private servicio: ServicioVehiculosService) {
    this.gestorRutas.params.subscribe((parametros: Params) => {
      this.tipo = parametros["tipo"];

    })
    this.getVehiculos()
  }



  getVehiculos() {
    this.vehiculos = []
    this.vehiculos = this.servicio.getVehiculos(this.tipo)
    console.log(this.vehiculos)
  }

}
