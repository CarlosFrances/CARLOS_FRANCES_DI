let elementosAny = [];
const elementosPalabra = ["palabra 1", "palabra 2", "palabra 3", "palabra 4"];

// obtener elementos
//console.log(elementosPalabra[1]);
//console.log(elementosPalabra[5]);

// cambiar valores
//elementosPalabra[0] = "Palabra 1 modificada";
//elementosPalabra[2] = "Palabra 3 modificada";

//console.log(elementosPalabra[0]);
//console.log(elementosPalabra[2]);

// añadir
elementosPalabra.push("palabra nueva"); //->5
console.log(elementosPalabra.unshift("palabra inicio")); //->6

elementosPalabra.forEach((element, index) => {
  console.log(`${index} ${element}`);
});
//elementosPalabra.push("palabra 3");

// eliminar
console.log(elementosPalabra.pop()); //->palabra nueva
console.log(elementosPalabra.shift()); //->palabra inicio
