// selectores

// document.querySelector --> HTMLElement -> Button --> Primera ocurrendcia
// document.querySelectorAll --> Nodelist -> List<Button> --> Lista completa de elementos

//let boton = document.querySelector("button"); busca un elemento de tipo button
//let boton = document.querySelector("#boton_borrar"); busca un elemento con el id boton_borrar
//let boton = document.querySelector(".btn"); busca un elemento de clase boton
//let lista = document.querySelector("ul.elemento") busca un elemento de tipo ul con clase elemento
//let lista = document.querySelector("div.container ul.elemento") busca un elemento div de clase container que tenga dentro un elemento ul de clase elemento
//let elementosLi = document.querySelector("ul").querySelectorAll("li"); busca todos los li dentro de el primer elemento ul
//let elementosLi = document.querySelectorAll("ul.elemento li"); //busca todos los li dentro de un elemento ul de clase elemento

let botonAdd = document.querySelector("#boton_agregar");
let botonBorrar = document.querySelector("#boton_borrar");

let lista1 = document.querySelector("#lista1");
let lista2 = document.querySelector("#lista2");

let select = document.querySelector("#select_lista");

let texto = document.querySelector("#input_texto");

select.addEventListener("change", (e) => {
  opcion = e.target.value;
  console.log(e.target);
});

function agregarDato(dato, lista) {
  lista.innerHTML += `<li class='list-group-item'>${dato}</li>`;
}

botonAdd.addEventListener("click", (event) => {
  if (input_texto.value != "") {
    select.value == 1
      ? agregarDato(input_texto.value, lista1)
      : agregarDato(input_texto.value, lista2);
  } else {
    alert("Rellena el formulario");
  }
});

botonBorrar.addEventListener("click", (event) => {
  console.log("boton pulsado");
});

/*elementosLi.forEach((element) => {
  console.log(element.innerHTML);
});*/
