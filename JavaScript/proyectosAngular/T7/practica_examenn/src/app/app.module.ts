import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { DetalleComponent } from './components/detalle/detalle.component';

@NgModule({
  declarations: [
    AppComponent,
    NoticiasComponent,
    DetalleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
