let fecha = new Date();
let palabra = new String("ejemplo");
let cosas = [];

class Persona {
  nombre;
  apellido;
  correo;
  edad;

  constructor(nombre, apellido, correo, edad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.edad = edad;
  }

  // fucntion : nombre(){}
  mostrarDatos() {
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Apellido: ${this.apellido}`);
    console.log(`Correo: ${this.correo}`);
    console.log(`Edad: ${this.edad}`);
  }

  get getNombre() {
    return this.nombre;
  }

  get getApellido() {
    return this.apellido;
  }

  get getCorreo() {
    return this.correo;
  }

  get getEdad() {
    return this.edad;
  }

  set setApellido(apellido) {
    this.apellido = apellido;
  }
}

class Trabajador extends Persona {
  salario;
  pagas;

  constructor(nombre, apellido, correo, edad, salario, pagas) {
    super(nombre, apellido, correo, edad);
    this.salario = salario;
    this.pagas = pagas;
  }

  mostrarDatos() {
    super.mostrarDatos();
    console.log(`Salario: ${this.salario}`);
    console.log(`Pagas: ${this.pagas}`);
  }

  calcularNetoMes(retencion) {
    let brutoMes = this.salario / this.pagas;
    let netoMes = brutoMes - brutoMes * retencion;
    console.log(netoMes);
  }
}


