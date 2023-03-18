import { noticiaInterfaz } from './../model/noticia_interfaz';
import { Injectable } from '@angular/core';
// importar interfaz objeto (nombre, siglas...)
@Injectable({
  providedIn: 'root',
})
export class NoticiasService {

 constructor() {
    // consulta y llenado de arrays
    // promesa
    /* fetch("asdasd",{method:"POST",body:{}}) */
  }


  // lista de objetos tipo noticia_interfaz
  noticias: noticiaInterfaz[] = [
    // cada objeto de la lista es una implementacion de noticia_interfaz

    {

      id: "politics/live/2023/mar/14/rishi-sunak-illegal-migration-bill-tory-revolt-robert-buckland-warns-uk-politics-live",
      type: "liveblog",
      sectionId: "politics",
      webPublicationDate: "2023-03-14T09:24:34Z",
      webTitle: "Sunak will have to water down illegal migration bill to avoid Tory revolt, former minister warns - UK politics live",
      pillarName: "News"
    },
    {

      id: "sport/live/2023/mar/14/bangladesh-v-england-third-t20-international-live",
      type: "liveblog",
      sectionId: "sport",
      webPublicationDate: "2023-03-14T09:24:13Z",
      webTitle: "Bangladesh v England: third T20 international - live",
      pillarName: "News"
    },
    {
      id: "business/2023/mar/14/uk-wage-growth-inflation-employment-ons",
      type: "article",
      sectionId: "business",
      webPublicationDate: "2023-03-14T09:22:54Z",
      webTitle: "UK wage growth slows, adding to inflation squeeze on households",
      pillarName: "News"

    },
    {

      id: "business/live/2023/mar/14/global-markets-silicon-valley-bank-collapse-banking-shares-boj-ecb-business-live",
      type: "liveblog",
      sectionId: "business",
      webPublicationDate: "2023-03-14T09:18:40Z",
      webTitle:"Global markets gripped by Silicon Valley Bank collapse as banking shares slide - business live",
      pillarName: "News"

    },
    {

      id: "books/2023/mar/14/international-booker-prize-announces-longlist-to-celebrate-ambition-and-panache",
      type:"article",
      sectionId: "books",
      webPublicationDate: "2023-03-14T09:00:43Z",
      webTitle:"International Booker prize announces longlist to celebrate ‘ambition and panache’",
      pillarName: "Arts"
    },
    {
      id: "books/2023/mar/14/the-martha-mills-prize-london-review-bookshop-young-writers-award",
      type: "article",
      sectionId: "books",
      webPublicationDate: "2023-03-14T09:00:43Z",
      webTitle: "Martha Mills prize: new award for young writers launched by London Review Bookshop",
      pillarName: "Arts"

    }

  ];

  // devolver array de objetos asignatura_interfaz para pasarlo al componente ts
  getAllNoticias(): noticiaInterfaz[] {
    console.log('Noticia llamado');

    return this.noticias;
  }


  // metes un conocimiento, lo busca y devuelve lista de objetos asignatura_interfaz que lo tengan
  getNoticiasSeccionId(seccion: string): noticiaInterfaz[] {

    return this.noticias.filter((item) => {

        return item.sectionId == seccion;
      });
    }

    getNoticiaById(id: string): noticiaInterfaz | undefined {
      return this.noticias.find(noticia => noticia.id === id);
    }


}
