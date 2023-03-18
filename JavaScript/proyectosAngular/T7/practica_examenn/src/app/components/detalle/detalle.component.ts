import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { noticiaInterfaz } from '../../model/noticia_interfaz';
import { NoticiasService } from '../../service/noticias.service';

@Component({
  selector: 'practica-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})

export class DetalleComponent {
  id!: string;

  noticia?: noticiaInterfaz;


  constructor(private gestorRutas: ActivatedRoute, private servicio: NoticiasService) {}

  ngOnInit(): void {
    this.gestorRutas.params.subscribe((parametros: Params) => {
      this.id = parametros['id'];
      this.noticia = this.servicio.getNoticiaById(this.id);
    });
  }
}
