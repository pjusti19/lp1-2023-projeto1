let dataAtual = new Date();
let diaSemana = dataAtual.getDay();

document.getElementById("diaSemana").innerHTML = diaSemana.toDateString();
