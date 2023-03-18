export class Vehiculo {
  nombre: string
  marca: string
  cv: number
  tipo: string
  imagen: string

  constructor(nombre: string, marca: string, cv: number, tipo: string, imagen: string) {
    this.nombre = nombre
    this.marca = marca
    this.cv = cv
    this.tipo = tipo
    this.imagen = imagen
  }
}
