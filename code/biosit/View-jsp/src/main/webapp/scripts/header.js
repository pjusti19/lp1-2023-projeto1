
document.querySelector("#icone").addEventListener('click', ()=> location.href="index.jsp");

opcoesEl = document.querySelector("#opcoes");

document.querySelector("#mostrar-menu").addEventListener('click', ()=>{
    if (opcoesEl.classList.contains('menu-escondido')) {
        opcoesEl.style.right = '0';
        opcoesEl.classList.remove('menu-escondido');
    } else {
        opcoesEl.style.right = '-1000px';
        opcoesEl.classList.add('menu-escondido');
    }
});