/*https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={palabra} &amp;page-size={resultados}*/
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={covid}%20&amp;page-size={2}
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp&amp;section={sport}
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&q=madrid&page-size=10


document.querySelector("#formulario_boton").addEventListener("click",(e) =>{
    let noticia = document.querySelector("#formulario_texto").value
    let numeroNoticias =  document.querySelector("#formulario_numero").value
    if(noticia == "" || isNaN(numeroNoticias) || numeroNoticias <= 0) window.alert("Datos de búsqueda erroneos");
    else{
        buscarPorNoticia(noticia,numeroNoticias);
    }
});

function buscarPorNoticia(noticia, numeroNoticias){
    let url = `https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&q=${noticia}&page-size=${numeroNoticias}`;
    let cards = document.querySelector("#cartas");

    cards.innerHTML="";

    fetch(url)
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.response.results.forEach((element) =>{
            cards.innerHTML+=`<div class="card" style="width: 15rem;margin:30px;"><div class="card-body"><h4>${element.webTitle}</h4><a href="${element.webUrl}" class="btn btn-primary">Go somewhere</a></button></div></div>`
        });
    })
};

document.querySelector("#categorias_boton").addEventListener("click",(e) =>{
    let categoria = document.querySelector("#categorias_select").value
    if(categoria == "") window.alert("Datos de búsqueda erroneos");
    else{
        buscarPorCategoria(categoria);
    }
});

function buscarPorCategoria(categoria){
    let url = `https://content.guardianapis.com/search?api-key=fe0767e4-aab7-4908-ba72-b444332b658d&section=${categoria}`;
    let cards = document.querySelector("#cartas");

    cards.innerHTML="";

    fetch(url)
    .then((ok) => ok.json())
    .then((ok1) => {
        ok1.response.results.forEach((element) =>{
            cards.innerHTML+=`<div class="card" style="width: 18rem;margin:30px;"><div class="card-body"><h4>${element.webTitle}</h4><a href="${element.webUrl}" class="btn btn-primary">Go somewhere</a></button></div></div>`
        });
    })
    .catch(console.log("Error de conexión"));
}