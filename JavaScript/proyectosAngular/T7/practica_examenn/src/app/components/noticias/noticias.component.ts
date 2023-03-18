import { Component } from '@angular/core';
import { NoticiasService } from './../../service/noticias.service';
import { noticiaInterfaz } from '../../model/noticia_interfaz';



@Component({
  selector: 'practica-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.css']
})
export class NoticiasComponent {

  noticiasFiltradas: noticiaInterfaz[];

  constructor(private noticiasService: NoticiasService) {

    this.noticiasFiltradas = noticiasService.getAllNoticias()

  }


  filtrarNoticias(seccion: string) {
    this.noticiasFiltradas = this.noticiasService.getNoticiasSeccionId(seccion);
  }
}
