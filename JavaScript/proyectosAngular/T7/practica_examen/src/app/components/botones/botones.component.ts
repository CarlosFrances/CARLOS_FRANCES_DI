import { Component } from '@angular/core';
import { Noticia } from 'src/app/model/Noticia';
import { NoticiasService } from 'src/app/services/noticias.service';
import { NoticiaComponent } from '../noticia/noticia.component';

@Component({
  selector: 'app-botones',
  templateUrl: './botones.component.html',
  styleUrls: ['./botones.component.css']
})
export class BotonesComponent {

  noticias: Noticia[] = [];
  noticiasFiltradas: Noticia[] = [];


  constructor(private servicio: NoticiasService) {
    this.noticias = servicio.noticias
    this.servicio.noticiaActual
  }

  pasarNoticia(noticia: Noticia) {
    this.servicio.setNoticia(noticia);
  }

  sacarNoticias(type: string) {
    this.noticiasFiltradas = [];
    this.noticiasFiltradas = this.noticias.filter((item) =>
      item.sectionId == type);

    console.log(this.noticiasFiltradas);
  }

}
