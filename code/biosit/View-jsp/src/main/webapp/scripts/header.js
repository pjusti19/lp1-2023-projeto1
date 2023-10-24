
document.querySelector("#icone").addEventListener('click', () => location.href = "index.jsp");

let opcoesEl = document.querySelector("#opcoes");
let mostrarMenuEl = document.querySelector("#mostrar-menu");

mostrarMenuEl.addEventListener('click', () => {
    notificacoesEl.style.right = '-1000px';
    notificacoesEl.classList.add('menu-escondido');
    if (opcoesEl.classList.contains('menu-escondido')) {
        opcoesEl.style.right = '0';
        opcoesEl.classList.remove('menu-escondido');
        mostrarMenuEl.style.background = 'rgb(209, 209, 209)';
        mostrarNotificacoesEl.style.background = 'white';
    } else {
        opcoesEl.style.right = '-1000px';
        opcoesEl.classList.add('menu-escondido');
        mostrarMenuEl.style.background = 'white';
    }
});

let notificacoesEl = document.querySelector("#notificacoes");
let mostrarNotificacoesEl = document.querySelector("#mostrar-notificacoes");

mostrarNotificacoesEl.addEventListener('click', () => {
    opcoesEl.style.right = '-1000px';
    opcoesEl.classList.add('menu-escondido');
    if (notificacoesEl.classList.contains('menu-escondido')) {
        notificacoesEl.style.right = '0';
        notificacoesEl.classList.remove('menu-escondido');
        mostrarNotificacoesEl.style.background = 'rgb(209, 209, 209)';
        mostrarMenuEl.style.background = 'white';

    } else {
        notificacoesEl.style.right = '-1000px';
        notificacoesEl.classList.add('menu-escondido');
        mostrarNotificacoesEl.style.background = 'white';
    }
});
