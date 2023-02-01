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