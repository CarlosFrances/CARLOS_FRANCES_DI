// Promise(acepto,rechazo)

/*let promesaInicial=new Promise((resolve,reject)=>{
    //logica de ejecucion
    setTimeout(()=>{
        let numero = Math.random()*101;

        if(numero >= 50 ){
            resolve(numero);
        }else{
            reject("Promesa con resultado incorrecto");
        }
        // > 49 --> resultado correcto resolve
        // < 50 --> resultado incorrecto reject
    },5000);

    setInterval(() =>{
        console.log("Ejecucion");
    })

});*/

//tratar promesa
// resolve --> then
// reject --> catch

/*promesaInicial.then((ok) => {
    //resultado correcto
    console.log(`La promesa ha contestado con un resultado de ${ok}`)
}).catch((err) => {
    //resultado incorrecto
    console.log(`${err}`)
}).finally(() =>{
    console.log("Ejecucion en cualquiera de los casos");
});*/

// cargar en un select todas las categorias de los productos

/*fetch("https://dummyjson.com/products/categories")
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.products.forEach((element) => {
            console.log(element);
            sel.innerHTML+=`<option>${element}</option>`;
        });
})
.catch((err) => {
        console.log("Conexion incorrecta");
});*/

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
/*https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={palabra} &amp;page-size={resultados}*/
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={covid}%20&amp;page-size={2}
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp&amp;section={sport}

fetch("https://dummyjson.com/products/categories")
.then((ok) => ok.json())
.then((ok1) => {
    ok1.forEach((element) =>{
        categorias[0].innerHTML+=`<option>${element}</select>`;
    });   
});

let categorias = document.querySelectorAll("select");
categorias[0].addEventListener("change",(e) =>{
    fetch(`https://dummyjson.com/products/category/${e.target.value}`)
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.products.forEach((element) => {
            categorias[1].innerHTML+=`<option>${element.title}</option>`;
        });
    }).catch((err) => {
        console.log(err);
    }).then(console.log("yessss"));
});

let div = document.querySelector("div");
categorias[1].addEventListener("change",(e) => {
    div.innerHTML+=`<div class="card" style="width: 18rem;">
    <div class="card-body">
      <h5 class="card-title">${e.target.value}</h5>
    </div>
  </div>`
})