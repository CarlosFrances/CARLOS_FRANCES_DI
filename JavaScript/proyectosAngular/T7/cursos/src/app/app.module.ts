import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppComponentComponent } from './components/app-component/app-component.component';
import { AppCursosComponent } from './components/app-cursos/app-cursos.component';
import { AppAlumnosComponent } from './components/app-alumnos/app-alumnos.component';
import { AppAsignaturasComponent } from './components/app-asignaturas/app-asignaturas.component';

@NgModule({
  declarations: [
    AppComponent,
    AppComponentComponent,
    AppCursosComponent,
    AppAlumnosComponent,
    AppAsignaturasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
