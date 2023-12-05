
let btnGeral = document.querySelector("#sec-geral");
let btnPron = document.querySelector('#sec-pron');
let btnCons = document.querySelector('#sec-cons');
let btnArray = document.querySelectorAll(".btn-secao");
let secaoArray = document.querySelectorAll(".secao-sel");

btnGeral.addEventListener('click', abreGeral);
function abreGeral() {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[0].classList.remove("secao-oculta");
    btnGeral.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'geral');
}

btnPron.addEventListener('click', abrePron);
function abrePron() {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[1].classList.remove("secao-oculta");
    btnPron.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'prontuario');
}


btnCons.addEventListener('click', abreCons);
function abreCons() {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[2].classList.remove("secao-oculta");
    btnCons.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'consulta');
}


function init() {
    let sa = window.sessionStorage.getItem('sessaoAberta');
    if(sa == null) {
        return;
    } else if(sa === 'prontuario') {
        abrePron();
    } else if(sa === 'geral') {
        abreGeral();
    } else if(sa === 'consulta') {
        abreCons();
    }
}
init();


let arrayEditReg = document.querySelectorAll(".btn-edit-reg");
arrayEditReg.forEach(function(btn) {
    btn.addEventListener('click', function(evt) {
        titulo = evt.target.dataset.titulo;
        descricao = evt.target.dataset.descricao;
        id = evt.target.dataset.id;
        document.querySelector("#id-reg-edit").value = id;
        document.querySelector("#title-pron-edit input").value = titulo;
        document.querySelector("#desc-pron-edit textarea").value = descricao;
        
        document.querySelector("#containerwt").classList.add("display-total-off");
        document.querySelector("#container-editar-registro").classList.remove("editar-off");
    });
});


//for(let i = 0; i < arrayEditReg.lenght; i++) {;
//    console.log(i);
//    arrayEditReg[i].addEventListener('click', function(evt) {
//        id = evt.target.dataset.id;
//        document.querySelector("#id-reg-edit").value = id;
//        
//        document.querySelector("#containerwt").classList.add("display-total-off");
//        document.querySelector("#container-editar-registro").remove("editar-off");
//    });
//}

let btnFecharEdicao = document.querySelector("#fechar-edicao");
btnFecharEdicao.addEventListener('click', ()=> {
    document.querySelector("#containerwt").classList.remove("display-total-off");
    document.querySelector("#container-editar-registro").classList.add("editar-off");
});