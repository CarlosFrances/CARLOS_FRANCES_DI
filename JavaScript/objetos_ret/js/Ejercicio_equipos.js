class Jugador {
  nombre;
  posicion;
  valor;

  constructor(nombre, posicion, valor) {
    this.nombre = nombre;
    this.posicion = posicion;
    this.valor = valor;
  }
}

class Equipo {
  nombre;
  plantilla;
  presupuesto;

  constructor(nombre, plantilla, presupuesto) {
    this.nombre = nombre;
    this.plantilla = plantilla;
    this.presupuesto = presupuesto;
  }

  addJugador(jugador) {
    this.plantilla.push(jugador);
    this.presupuesto -= jugador.valor;
  }

  listarEquipo = () => {
    console.log("Nombre: " + this.nombre);
    this.listarPlantilla();
    console.log("Presupuesto: " + this.presupuesto);
  };

  listarPlantilla = () => {
    this.plantilla.forEach((jugador) => {
      console.log(jugador.nombre);
      console.log(jugador.posicion);
      console.log(jugador.valor);
    });
  };

  listarPosicion = (posicion) => {
    this.plantilla.forEach((jugador) => {
      jugador.posicion == posicion && console.log("defensa: " + jugador.nombre);
    });
  };
}

let equipoMadrid = new Equipo("Madrid", [], 100000);
let jugador1 = new Jugador("Carlos", "defensa", 12345);
let jugador2 = new Jugador("juan", "delantero", 54321);
let jugador3 = new Jugador("nico", "defensa", 54321);
let jugador4 = new Jugador("alon", "delantero", 54321);
let jugador5 = new Jugador("guille", "medio", 54321);
let jugador6 = new Jugador("berro", "medio", 54321);

equipoMadrid.addJugador(jugador1);
equipoMadrid.addJugador(jugador2);
equipoMadrid.addJugador(jugador3);
equipoMadrid.addJugador(jugador4);
equipoMadrid.addJugador(jugador5);
equipoMadrid.addJugador(jugador6);
console.log("--------------------------");
equipoMadrid.listarEquipo();
console.log("--------------------------");
equipoMadrid.listarPlantilla(equipoMadrid);
console.log("--------------------------");
equipoMadrid.listarPosicion("defensa");
console.log("--------------------------");
