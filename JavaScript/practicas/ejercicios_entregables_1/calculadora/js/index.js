//capturar elementos
let input = document.querySelector("input");
let botonMas = document.querySelector("#botonMas");
let botonMenos = document.querySelector("#botonMenos");
let botonPor = document.querySelector("#botonPor");
let botonEntre = document.querySelector("#botonEntre");
let botonIgual = document.querySelector("#botonIgual");
let botonDelete = document.querySelector("#botonDelete");
let textArea = document.querySelector("textarea");

//dar escuchadores a los botones y capturar los operandos
let operando1=null;
let operando2=null;
let operador=null;

botonMas.addEventListener("click",(e) => {
    if(operando1 == null){
        operando1=parseInt(input.value);
        operador="+";
        input.value="";
    }
});
botonMenos.addEventListener("click",(e) => {
    if(operando1 == null){
        operando1=parseInt(input.value);
        operador="-";
        input.value="";
    }
});
botonPor.addEventListener("click",(e) => {
    if(operando1 == null){
        operando1=parseInt(input.value);
        operador="*";
        input.value="";
    }
});
botonEntre.addEventListener("click",(e) => {
    if(operando1 == null){
        operando1=parseInt(input.value);
        operador="/";
        input.value="";
    }
});
botonDelete.addEventListener("click",(e) => {
    if(input.value!=""){
        input.value=input.value.substring(0,input.value.length-1);
    }
})
botonIgual.addEventListener("click",(e) => {
    if(operando1 != null){
        operando2=parseInt(input.value);
        input.value="";
        textArea.value+=`\n${operando1} ${operador} ${operando2} = `;
        textArea.value+=obtenerResultado();
        reset();
    }
});

function obtenerResultado(){
    switch (operador) {
        case "+":return operando1+operando2;break;
        case "-":return operando1-operando2;break;
        case "*":return operando1*operando2;break;
        case "/":return operando1/operando2;break;
    }
}

function reset(){
    operando1=null;
    operando2=null;
    operador=null;
}