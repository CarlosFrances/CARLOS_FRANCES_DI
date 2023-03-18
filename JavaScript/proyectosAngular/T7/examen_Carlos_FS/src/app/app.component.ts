import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'examen_Carlos_FS';

  clickado = false

  constructor() {
    this.clickado = false
  }

  clickar() {
    this.clickado = true
  }
}
