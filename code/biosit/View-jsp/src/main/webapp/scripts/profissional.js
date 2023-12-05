
let btnGeral = document.querySelector("#opcao-geral");
let btnMed = document.querySelector('#opcao-medico');
let btnAcesso = document.querySelector('#opcao-acesso');
let btnArray = document.querySelectorAll(".opcao-menu");
let secaoArray = document.querySelectorAll(".containersec");

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
if(btnMed != null) {
btnMed.addEventListener('click', abreMed);
    function abreMed() {
        for(let i = 0; i < btnArray.length; i++) {
            btnArray[i].classList.remove("selected");
            secaoArray[i].classList.remove("secao-oculta");
            secaoArray[i].classList.add("secao-oculta");
        }
        secaoArray[1].classList.remove("secao-oculta");
        btnMed.classList.add("selected");
        window.sessionStorage.setItem('sessaoAberta', 'medico');
    }
}

btnAcesso.addEventListener('click', abreAcesso);
function abreAcesso() {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    document.querySelector('#acesso').classList.remove("secao-oculta");
    btnAcesso.classList.add("selected");
    window.sessionStorage.setItem('sessaoAberta', 'acesso');
}

function init() {
    let sa = window.sessionStorage.getItem('sessaoAberta');
    if(sa == null) {
        return;
    } else if(sa === 'prontuario') {
        abrePron();
    } else if(sa === 'medico') {
        abrePron();
    } else if(sa === 'acesso') {
        abreAcesso();
    }
}
init();