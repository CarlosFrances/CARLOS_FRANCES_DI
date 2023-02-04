let urlCategorias = "https://dummyjson.com/products/categories";
let selectCategorias = document.querySelector("select");


//cargar categorias en el select
fetch(urlCategorias)
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.forEach((categoria) => {
            selectCategorias.innerHTML+=`<option>${categoria}</option>`;
        })
    }).catch((error) => {
        console.log(error);
    }).finally(console.log("bieeen"));

//eventlistener para que cargue productos cuando selecciones categoria
let categoriaSeleccionada;
selectCategorias.addEventListener("change",(e) =>{
    categoriaSeleccionada=e.target.value;
    traerProductos();
});

//cargar las cards con los productos de la categoria seleccionada
let urlProductos="https://dummyjson.com/products/category/"
let cartas=document.querySelectorAll(".row .row")[1];
let productos=[]

function traerProductos(){
    let con=0;
    fetch(urlProductos+categoriaSeleccionada)
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.products.forEach((element) => {
            productos.push(element);
            cartas.innerHTML+=`<div class="col-6">
            <div class="card" style="width: 15rem">
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
        })
        for (let i = 0; i < con; i++) {
            let boton = document.querySelector(`#boton${i}`);
            boton.addEventListener("click",(e) => {
                agregarAlCarrito(productos[i].title , productos[i].price);
            });
        }
    })
}

//agregar productos al carrito
let listaCarrito = document.querySelectorAll(".col-4 .row")[2];
let totalCarrito = document.querySelectorAll(".col-4 .row")[3];
let total=0;
function agregarAlCarrito(titulo,precio){
    listaCarrito.innerHTML+=`<h5>${titulo}  $${precio}</h5>`;
    total+=precio;
    totalCarrito.innerHTML=`<h2>$${total}</h2>`;
}

//boton de eliminar carrito
let botonBorrar=document.querySelector(".btn-danger");
botonBorrar.addEventListener("click",(e) => {
    console.log("vaciado");
});