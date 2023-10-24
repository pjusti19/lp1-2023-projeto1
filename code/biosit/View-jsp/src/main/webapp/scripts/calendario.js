document.addEventListener("DOMContentLoaded", function () {
    const dataAtual = new Date();
    let mesAtual = dataAtual.getMonth();
    let anoAtual = dataAtual.getFullYear();
    
    const mesAnoText = document.getElementById("mesAno");
    const corpoCalendario = document.getElementById("corpoCalendario");

    function updateCalendar() {
        mesAnoText.textContent = `${getMonthName(mesAtual)} ${anoAtual}`;
        corpoCalendario.innerHTML = "";

        const primeiroDia = new Date(anoAtual, mesAtual, 1).getDay();
        const ultimoDia = new Date(anoAtual, mesAtual + 1, 0).getDate();

        for (let i = 0; i < primeiroDia; i++) {
            const cell = document.createElement("td");
            corpoCalendario.appendChild(cell);
        }

        for (let dia = 1; dia <= ultimoDia; dia++) {
            const cell = document.createElement("td");
            cell.textContent = dia;

            if (anoAtual === dataAtual.getFullYear() && mesAtual === dataAtual.getMonth() && dia === dataAtual.getDate()) {
                cell.classList.add("hoje");
            }

            corpoCalendario.appendChild(cell);

            if ((primeiroDia + dia - 1) % 7 === 6) {
                const newRow = document.createElement("tr");
                corpoCalendario.appendChild(newRow);
            }
        }
    }

    function getMonthName(monthIndex) {
        const monthNames = [
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        ];
        return monthNames[monthIndex];
    }

    updateCalendar();
});
