
document.querySelector("#icone").addEventListener('click', ()=> location.href="index.jsp");

document.querySelector("#mostrar-menu").addEventListener('click', ()=>{
    document.querySelector("#opcoes").classList.toggle('menu-escondido');
});