//recoger los elementos del dom
let body = document.querySelector("body");
let calendario = document.querySelector("input");

//añadir escuchador al calendario
let fecha;
calendario.addEventListener("change",(e) => {
    fecha=calendario.value;
    console.log(fecha);
    body.style.backgroundColor=cambiarColor(fecha);
});

function cambiarColor(fecha){
    let mes = parseInt(fecha.substring(5,7));
    console.log(mes);
    if(mes >= 1 && mes <=2) return "#99ffff";
    else if(mes >= 03 && mes <= 6) return "#009900";
    else if(mes >= 7 && mes <= 9) return "#aaaa00";
    else if(mes >= 10 && mes <= 12) return "E1C16E";
}