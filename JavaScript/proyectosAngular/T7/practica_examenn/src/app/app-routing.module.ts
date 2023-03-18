import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { DetalleComponent } from './components/detalle/detalle.component';

const routes: Routes = [
  { path: '', redirectTo: '/noticias', pathMatch: 'full' },
  { path: 'noticias', component: NoticiasComponent },
  { path: 'noticias/:id', component: DetalleComponent } // añadir la ruta con par. id
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
