//coger los inputs
let inputNombre = document.querySelector("input");
let inputApellido = document.querySelectorAll("input")[1];
let inputTelefono = document.querySelectorAll("input")[2];
let inputDNI = document.querySelectorAll("input")[3];


//añadir eventlistener al boton
let boton = document.querySelector("button");
boton.addEventListener("click", (e) => {
    //comprobar si los imputs estan vacios
    let nombre=inputNombre.value;
    let apellido=inputApellido.value;
    let telefono=inputTelefono.value;
    let dni=inputDNI.value;
    if(nombre=="" || apellido=="" || telefono=="" || dni=="") window.alert("Rellena todos los campos") ;
    else {
        //añadir resumen al dom
        if(inputTelefono.checkValidity() && inputDNI.checkValidity()){
            console.log("valido");
            let resumen=document.querySelector("#resumen");
            //resumen.innerHTML=`${nombre} - ${apellido} - ${telefono} - ${dni}`;
            let existsUl = document.querySelector("ol");
            if(existsUl==null){
                let ul = document.createElement("ol");
                resumen.appendChild(ul);
            } 
            let ul = document.querySelector("ol");
            let li = document.createElement("li");
            li.textContent=`${nombre} - ${apellido} - ${telefono} - ${dni}`;
            ul.appendChild(li);


            
        }else window.alert("Telefono o DNI incorrectos")
    }
    //console.log(inputNombre.value);
})