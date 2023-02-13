/*https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={palabra} &amp;page-size={resultados}*/
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp;q={covid}%20&amp;page-size={2}
//https://content.guardianapis.com/search?api-key=f7654c56-99cf-4770-9e4e-c14e1a2ecbba&amp&amp;section={sport}

boton = document.querySelector("#boton_empezar");

boton.addEventListener("click",(e) =>{
    if(document.querySelector("#formulario_nombre").value == "" || document.querySelector("#formulario_apellido").value == "")
    window.alert("faltan datos en el formulario");
    else{
        obtenerAlert(document.querySelector("#formulario_checkbox").checked)
    }
})

function obtenerAlert(param){
    if(param){
        document.querySelector("#div_alert").innerHTML='<div class="alert alert-primary" style="height:300px;width:700px;" role="alert">Perfecto! estas preparado para empezar</div>';
        setTimeout(() => {
            window.location.href = "pagina2.html";
          }, 2000);
    } 
    else{
        document.querySelector("#div_alert").innerHTML='<div class="alert alert-warning" style="height:300px;width:700px;" role="alert">Así no vamos bien</div>';
    }  
}