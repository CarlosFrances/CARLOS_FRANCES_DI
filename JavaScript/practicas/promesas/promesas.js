// Promise (acepto, rechazo)
/* let promesaInicial = new Promise((res, rej) => {
  // lógica de ejecucion
  setTimeout(() => {
    let numero = Math.random() * 101;
    if (numero >= 50) {
      res(numero);
    } else {
      rej("Promesa con resultado incorrecto");
    }
  }, 5000);
}); */

// res --> then definiendo la funcion del res
// rej --> catch definiendo la funcion del rej

/* promesaInicial
  .then((ok) => {
    // resultado correcto
    console.log(`La promesa ha contestado con un resultado de ${ok}`);
  })
  .catch((err) => {
    // resultao incorrecto
    console.log(`${err}`);
  })
  .finally(() => {
    console.log("Ejecucion en cualquiera de los casos");
  }); */

/* setInterval(() => {
  console.log("Ejecucion");
}, 2000); */

// cargar en un select todas las categorias de los productos
fetch("https://dummyjson.com/products")
  .then((ok) => ok.json())
  .then((ok1) => {
    console.log(ok1);
    ok1.products.forEach((element) => {
      console.log(element.title);
    });
  })
  .catch((err) => {
    console.log("Conexion incorrecta");
  });

let urlProductos = "https://dummyjson.com/products/category/";
let selectCategorias = document.querySelector("select");
let filaCartas = document.querySelectorAll(".row .row")[1];

selectCategorias.addEventListener("change", (e) => {
  consultarProductos(e.target.value);
});

let listaCarrito=document.getElementById("lista_carrito");
let totalCarrito=document.getElementById("total_carrito");
let numeroCompras=document.querySelector("h2");
let lista="";
let total=0;
let totalCompras=0;
function agregarALista(title,price){
    lista+=`<p style="text-align: center;">${title}  $${price}</p>`;
    if(ver)listaCarrito.innerHTML=lista;
    total+=price;
    totalCarrito.innerHTML=`<div class="col-8"><h2>Total: $${total}</h2></div>`;
    totalCompras++;
    numeroCompras.innerHTML=totalCompras;
}

function consultarProductos(categoria) {
  filaCartas.innerHTML = "";
  fetch(urlProductos + categoria)
    .then((ok) => {
      console.log(ok);
      return ok.json();
    })
    .then((ok1) => {
        let con=0;
        let elements=[]
      ok1.products.forEach((element) => {
        //console.log(element.title);
        // pintar cada carta en el innerHTML de la row
        elements.push(element)
        filaCartas.innerHTML += `<div class="col">
              <div class="card" style="width: 18rem">
                <img src="${element.images[0]}" class="card-img-top" alt="..." />
                <div class="card-body">
                  <h5 class="card-title">${element.title}</h5>
                  <h6 class="card-title">$${element.price}</h6>
                  <p class="card-text">
                   ${element.description}
                  </p>
                  <button class="btn btn-primary" id="boton${con}">Agregar a carrito</button>
                </div>
              </div>
            </div>`;
            con++;
      });
      for (let index = 0; index < con; index++) {
        let element = document.getElementById(`boton${index}`);
        element.addEventListener("click",(e) => {
            agregarALista(elements[index].title,elements[index].price);
        })       
      }
    })
    .catch((err) => {
      alert("Conexion incorrecta");
    });
}

//boton de eliminar lista
function borrarLista(){
    lista="";
    listaCarrito.innerHTML=lista;
    total=0;
    totalCarrito.innerHTML="";
    totalCompras=0;
    numeroCompras.innerHTML=totalCompras;

}

let botonBorrar = document.querySelector(".btn-danger");
botonBorrar.addEventListener("click",(e) =>{
    borrarLista();
});

//boton de mostrar lista

let botonVerLista = document.querySelector("#boton_ver");
let ver=true;
botonVerLista.addEventListener("click",(e) => {
    if(ver){
        botonVerLista.childNodes[0].nodeValue="See trolley";
        listaCarrito.innerHTML="";        
        ver=false;
    }else{
        botonVerLista.childNodes[0].nodeValue="Hide trolley";
        listaCarrito.innerHTML=lista;
        ver=true;
    }
})

fetch("https://dummyjson.com/products/categories")
  .then((ok) => ok.json())
  .then((ok1) => {
    ok1.forEach((element) => {
      selectCategorias.innerHTML += `<option>${element}</option>`;
    });
  });