// fun nombre(para){}

function nombreFuncion(p1, p2) {
  console.log("Ejemplo de funcion");
  console.log(p1 + p2);
}

function funcionConRetorno(p1, p2) {
  return p1 + p2;
}

let funcionFlecha = (p1, p2) => {
  console.log(p1 + p2);
};

function parametrosAdicionales(p1) {
  console.log(p1);

  for (let i = 0; i < arguments.length; i++) {
    console.log(arguments[i]);
  }
}

function parametroDefecto(p1, p2, p3 = 7) {
  console.log(p1 + p2 + p3);
}

function parametroDefectoDesorden(p1 = 8, p2, p3 = 7) {
  console.log(p1 + p2 + p3);
}

function funcionCallback(operacion, p1, p2) {
  operacion(p1, p2);
}

/*funcionCallback((p1,p2) => {
    console.log(p1+p2);
},6,9)

funcionCallback((p1,p2) => {
    console.log(p1*p2);
},6,9)*/

//nombreFuncion(1, 2, 3, 4, 5, 6, 7);
//console.log(funcionConRetorno(4, 5));
//funcionFlecha(3, 2);
//parametrosAdicionales(1, 2, 3, 4, "wertewe");
//parametroDefecto(1, 4);
//parametroDefecto(1, 4, 6);
//function parametroDefectoDesorden
setTimeout(() => {
  console.log("ejecucion tras empezar");
}, 4000);

setInterval(() => {
  console.log("Ejecucion con intervalo");
}, 2000);
