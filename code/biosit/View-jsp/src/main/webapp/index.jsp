<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>biosit</title>
    <link rel="stylesheet" href="estilos/estilos.css">
</head>

<body>
    <header>
        <div class="bloco">
            <img src="imgs/icone.png" id="icone">
            <div>
                <h1>HospitalLegal</h1>
                <h3>MEDICAL</h3>
            </div>
        </div>
        <div class="bloco" id="menu">
            <button><img src="imgs/sino.png" id="sino"></button>
            <button>☰</button>
        </div>
    </header>
    <section id="opcoes">
        <h1>Menu</h1>
        <ul class="lista">
            <li><a href="estoque.jsp">Estoque</a></li>
            <li><a href="funcionarios.jsp">Funcionários</a></li>
            <li><a href="equipamentos.jsp">Equipamentos</a></li>
            <li><a href="paciente.jsp">Clientes</a></li>
            <li><a href="triagem.jsp">Triagem</a></li>
            <li><a href="financeiro.jsp">Financeiro</a></li>
            <li><a href="encaminhamento.jsp">Encaminhamento</a></li>
            <li><a href="requisicao.jsp">Requisição de Exames</a></li>
        </ul>
    </section>
    <main>
        <div id="centro">
        <article id="calendario">
            <div id="cabecalhoCalendario">
                <h1 id="mesAno"></h1>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Dom</th>
                        <th>Seg</th>
                        <th>Ter</th>
                        <th>Qua</th>
                        <th>Qui</th>
                        <th>Sex</th>
                        <th>Sáb</th>
                    </tr>
                </thead>
                <tbody id="corpoCalendario"></tbody>
            </table>
        </article>
    </div>
        <article id="agenda">
            <h1 id="dataAtual"></h1>
            <h3 id="diaSemana"></h3>
        </article>
        <button id="agendar">Agendar Consulta</button>
    </main>

</body>
<script src="scripts/calendario.js"></script>

</html>
