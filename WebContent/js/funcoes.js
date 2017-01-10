var btnFechar;

function iniciar(){
	btnFechar =  document.querySelector("#fecharalert");
	btnFechar.addEventListener("click",fecharAlert);
}

function fecharAlert(){
	var alert = document.querySelector(".card");
	alert.hidden = true;
}
window.addEventListener("load",iniciar);