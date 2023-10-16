// definindo a data atual por extenso
let meses = [
            'janeiro', 'fevereiro', 'março', 'abril',
            'maio', 'junho', 'julho', 'agosto',
            'setembro', 'outubro', 'novembro', 'dezembro'
        ];

        let dataAtual = new Date();

        let dia = dataAtual.getDate();
        let mes = meses[dataAtual.getMonth()];
        let ano = dataAtual.getFullYear();

        let dataPorExtenso = `${dia} de ${mes} de ${ano}`;

        document.getElementById('dataPorExtenso').textContent = dataPorExtenso;
        
// definindo o dia da semana atual
let diasDaSemana = [
            'Domingo', 'Segunda-feira', 'Terça-feira', 'Quarta-feira',
            'Quinta-feira', 'Sexta-feira', 'Sábado'
        ];

        let indiceDiaDaSemana = dataAtual.getDay();

        let diaDaSemana = diasDaSemana[indiceDiaDaSemana];

        document.getElementById('diaDaSemana').textContent = diaDaSemana;