import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NoticiaComponent } from './components/noticia/noticia.component';

const routes: Routes = [
  {
    path: "noticia/:noticia", component: NoticiaComponent
  },
  {
    path: "**", component: HomeComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
