import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'rutas';

  constructor(private navegador: Router) {

  }

  navegar(curso: string) {
    // Router
    this.navegador.navigate(["cursos", curso]);
  }
}
