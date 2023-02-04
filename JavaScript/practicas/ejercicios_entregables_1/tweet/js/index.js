// capturar elementos
let inputTexto=document.querySelector("textarea");
let boton=document.querySelector("button");
let contador=document.querySelector("h4");

//capturar el tamaño del texto en el contador
inputTexto.addEventListener("input",(e) => {
    console.log(inputTexto.value.length);
    contador.innerHTML=`${inputTexto.value.length}/255`;
})

//dar escuchador al boton para que lance la secencia de dialogos
boton.addEventListener("click",(e) => {
    if(confirm("¿Quieres enviar el tweet?")){
        window.alert("Tweet enviado");
        console.log(inputTexto.value);
        inputTexto.innerHTML="";
    }else{
        window.alert("Tweet no enviado");
    }
});


/*confirm(
    `${nombre}, ¿quieres ver todas las operaciones entre ${operador1} y ${operador2}?.`
    )*/
