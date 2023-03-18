import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { VehiculosComponent } from './components/vehiculos/vehiculos.component';

const routes: Routes = [
  { path: 'vehiculos/:tipo', component: VehiculosComponent },
  { path: 'buscador', component: BuscadorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
