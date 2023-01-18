let elemento = [1, 2, 3, 4, 5, 6, 7, 8, 9, "opcion"];

elemento.forEach((item, index) => {
  index % 2 && console.log(item);
  //index % 2 == 1 ? console.log(item) : console.log("impar");
});
