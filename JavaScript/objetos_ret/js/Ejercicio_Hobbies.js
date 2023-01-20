let obj1 = {
  nombre: "Valor correcto",
  apellido: "Apellido correcto",
  edad: 23,
  hobbies: ["Futbol", "Series", "Videojuegos", "Cine"],
};

let obj2 = {
  nombre: "Valor",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Television"],
};

let usuarios = [obj1, obj2];

usuarios.forEach((item) => {
  item.nombre == "Valor correcto" && console.log(item.hobbies);
});
