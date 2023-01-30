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

let rowhtml = document.querySelector(".row").innerHTML;
let row = document.querySelector(".row");

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

let profesores = [
  {
    nombre: "Fernando",
    apellido: "Sánchez",
    correo: "fernando@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion",
        horas: 8,
        siglas: "PRO",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Bases de datos",
        horas: 6,
        siglas: "BD",
        ciclo: "DAM",
        curso: 1,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Carlos",
    apellido: "Sánchez",
    correo: "carlos@gmail.com",
    asignaturas: [
      {
        nombre: "Entornos de Desarrollo",
        horas: 3,
        siglas: "ED",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Sistemas de Gestion Empresarial",
        horas: 3,
        siglas: "SGE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
];

function crearCarta(div) {}

profesores.forEach((profesor) => {
  let nombre = profesor.nombre;
  let apellido = profesor.apellido;
  let correo = profesor.correo;
  //capturar cada asignatura del profesor en cuestion
  let subjects = [];
  profesor.asignaturas.forEach((asignatura) => {
    subjects.push(asignatura.nombre)
  })
  //transformar las asignaturas en elementos <li>
  let asignaturasTexto=""
  subjects.forEach((asignatura) => {
    asignaturasTexto+=`<li>`+asignatura+`</li>`;
  })
  function agregarUl(){
    let nuevoUl = document.createElement("ul")
    subjects.forEach((asignatura) => {
    let nuevoLi= document.createElement("li");
    nuevoLi.appendChild(document.createTextNode(asignatura));
    nuevoUl.appendChild(nuevoLi);
    })
  let card = document.querySelector(".card-text");
  document.appendChild(nuevoUl);
  }
  
  //crear una carta con los datos de cada profesor y colocarla en el row
  row.innerHTML += `<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${nombre}</h5>
    <h6 class="card-subtitle">${apellido}</h5>
    <p class="card-text">${correo}</p>`+
    asignaturasTexto//añadir elementos al html
    +`<ul class="card-ul">
    </ul>
  </div>
</div>`;
/*row.innerHTML += `<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${nombre}</h5>
    <h6 class="card-subtitle">${apellido}</h5>
    <p class="card-text">${correo}</p>
  </div>
</div>`;*/

  /*//foreach de las asignaturas item.asignaturas --> agregarlas en la ul
  //document.create element para crear la ul
  let nodoLista = document.createElement("ul");
  let carta = document.querySelector("card");
  nodoLista.innerHTML.append("ul");*/
});
