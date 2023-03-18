import { Component } from '@angular/core';
import { Noticia } from 'src/app/model/Noticia';
import { NoticiasService } from 'src/app/services/noticias.service';
import { BotonesComponent } from '../botones/botones.component';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.css']
})
export class NoticiaComponent {


  noticia: Noticia;

  constructor(private servicio: NoticiasService) {
    this.noticia = servicio.getNoticia()
    console.log(this.noticia)
  }

}
