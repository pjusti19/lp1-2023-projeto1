
document.querySelector("#icone").addEventListener('click', ()=> location.href="index.jsp");

opcoesEl = document.querySelector("#opcoes");

document.querySelector("#mostrar-menu").addEventListener('click', ()=>{
    notificacoesEl.style.right = '-1000px';
    notificacoesEl.classList.add('menu-escondido');
    if (opcoesEl.classList.contains('menu-escondido')) {
        opcoesEl.style.right = '0';
        opcoesEl.classList.remove('menu-escondido');
    } else {
        opcoesEl.style.right = '-1000px';
        opcoesEl.classList.add('menu-escondido');
    }
});

notificacoesEl = document.querySelector("#notificacoes");

document.querySelector("#mostrar-notificacoes").addEventListener('click', ()=>{
    opcoesEl.style.right = '-1000px';
    opcoesEl.classList.add('menu-escondido');
    if (notificacoesEl.classList.contains('menu-escondido')) {
        notificacoesEl.style.right = '0';
        notificacoesEl.classList.remove('menu-escondido');
    } else {
        notificacoesEl.style.right = '-1000px';
        notificacoesEl.classList.add('menu-escondido');
    }
});
