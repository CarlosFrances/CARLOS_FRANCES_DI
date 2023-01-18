// generar un array de cartas de la baraja francesa (1-13)
// generar palos de corazones, trboles, diamantes y picas

let baraja = [];
let palos = ["C", "T", "D", "P"];

for (let i = 0; i < palos.length; i++) {
  for (let j = 1; j < 14; j++) {
    baraja.push(j + palos[i]);
  }
}

baraja = _.shuffle(baraja); // desordenar la baraja

// todos los corazones
baraja
  .filter((item) =>
    // predicado
    item.includes("C")
  )
  .forEach((item) => {
    console.log(item);
  }); //-> lista de los elementos que cumplan la condicion

let elementoEncontrado = baraja.find((value) => {
  return value.includes("D");
}); //-> primer elemento que coincide con el predicado

console.log("primero: " + elementoEncontrado);

// Obtener baraja que no tenga el elemento 1C
let barajaSin1C = baraja.filter((item) => item != "1C");

barajaSin1C.forEach((element) => {
  console.log(element);
});
