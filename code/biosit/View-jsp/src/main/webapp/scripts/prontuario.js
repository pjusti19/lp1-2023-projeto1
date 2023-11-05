
let btnGeral = document.querySelector("#sec-geral");
let btnPron = document.querySelector('#sec-pron');
let btnCons = document.querySelector('#sec-cons');
let btnArray = document.querySelectorAll(".btn-secao");
let secaoArray = document.querySelectorAll(".secao-sel");

btnGeral.addEventListener('click', ()=> {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[0].classList.remove("secao-oculta");
    btnGeral.classList.add("selected");
});

btnPron.addEventListener('click', ()=> {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[1].classList.remove("secao-oculta");
    btnPron.classList.add("selected");
});


btnCons.addEventListener('click', ()=> {
    for(let i = 0; i < btnArray.length; i++) {
        btnArray[i].classList.remove("selected");
        secaoArray[i].classList.remove("secao-oculta");
        secaoArray[i].classList.add("secao-oculta");
    }
    secaoArray[2].classList.remove("secao-oculta");
    btnCons.classList.add("selected");
});