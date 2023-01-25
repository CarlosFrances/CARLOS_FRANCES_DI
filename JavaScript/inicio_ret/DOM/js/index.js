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

select.addEventListener("change", () => {
  console.log(select.value);
});

botonAdd.addEventListener("click", (event) => {
  //console.log("boton pulsado");
  //<li>Elemento nuevo</li>
  //lista1.innerHTML += '<li class="list-group-item">Elemento Prueba</li>';
  let nodoLI = document.createElement("li");
  nodoLI.textContent = "Elemento prueba";
  //nodoLI.className ="list-group-item"
  nodoLI.classList.add("list-group-item");
  nodoLI.addEventListener("click", () => {
    console.log("Ejemplo de cosa");
  });
  lista1.append(nodoLI);
});

botonBorrar.addEventListener("click", (event) => {
  console.log("boton pulsado");
});

/*elementosLi.forEach((element) => {
  console.log(element.innerHTML);
});*/
