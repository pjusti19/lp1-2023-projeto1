
let btnGeral = document.querySelector("#sec-geral");
let btnPron = document.querySelector('#sec-pron');
let btnCons = document.querySelector('#sec-cons');
let btnExame = document.querySelector('#sec-exame');
let btnReceita = document.querySelector('#sec-receita');
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

btnExame.addEventListener('click', abreExame);
function abreExame() {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[3].classList.remove("secao-oculta");
    btnExame.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'exame');
}

btnReceita.addEventListener('click', abreReceita);
function abreReceita(){
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[4].classList.remove("secao-oculta");
    btnReceita.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'receita');
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
    } else if(sa === 'exame') {
        abreExame();
    } else if(sa === 'receita') {
        abreReceita();
    } 
}
init();


let arrayEditReg = document.querySelectorAll(".btn-edit-reg");
for(let i = 0; i < arrayEditReg.lenght; i++) {
    arrayEditReg[i].addEventListener('click', function(evt) {
        id = evt.target.dataset.id;
        document.querySelector("#id-reg-edit").value = id;
        
        document.querySelector("#containerwt").classList.add("display-total-off");
        document.querySelector("#container-editar-registro").remove("editar-off");
    });
}