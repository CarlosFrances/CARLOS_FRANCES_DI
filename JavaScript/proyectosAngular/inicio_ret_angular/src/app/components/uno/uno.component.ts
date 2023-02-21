import { Component } from '@angular/core';

@Component({
  selector: 'app-uno',
  templateUrl: './uno.component.html',
  styleUrls: ['./uno.component.css']
})
export class UnoComponent {
  contador: number = 0;

  botones(numero: number) {
    if (numero == 0) this.contador = 0;
    else this.contador += numero;
  }

  botonesSet(number: string) {
    this.contador = Number(number);
  }
}
