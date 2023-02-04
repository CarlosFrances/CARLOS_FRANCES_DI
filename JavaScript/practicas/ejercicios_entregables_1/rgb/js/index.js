//capturar los elementos
let inputR=document.querySelectorAll("input")[0];
let inputG=document.querySelectorAll("input")[1];
let inputB=document.querySelectorAll("input")[2];
let texto=document.querySelector("h2");

//guardar los cambios de rgb en variables
let r,g,b;
inputR.addEventListener("change",(e) => {
    r=inputR.value;
    g=inputG.value;
    b=inputB.value;
    texto.innerHTML=`<h2 width="400px" height="400px" style="text-align: center;background-color:rgb(${r},${g},${b});">RGB : ${r} / ${g} / ${b}</h2>`;
});
inputG.addEventListener("change",(e) => {
    r=inputR.value;
    g=inputG.value;
    b=inputB.value;
    texto.innerHTML=`<h2 width="400px" height="400px" style="text-align: center;background-color:rgb(${r},${g},${b});">RGB : ${r} / ${g} / ${b}</h2>`;
});
inputB.addEventListener("change",(e) => {
    r=inputR.value;
    g=inputG.value;
    b=inputB.value;
    texto.innerHTML=`<h2 width="400px" height="400px" style="text-align: center;background-color:rgb(${r},${g},${b});">RGB : ${r} / ${g} / ${b}</h2>`;
});
