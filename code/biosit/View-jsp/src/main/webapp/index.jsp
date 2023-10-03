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
    <section>
        <h1>Menu</h1>
        <ul class="lista">
            <li><a href="estoque.jsp">Estoque</a></li>
            <li><a href="funcionarios.jsp">Funcionários</a></li>
            <li><a href="equipamentos.jsp">Equipamentos</a></li>
            <li><a href="clientes.jsp">Clientes</a></li>
            <li><a href="triagem.jsp">Triagem</a></li>
            <li><a href="financeiro.jsp">Financeiro</a></li>
            <li><a href="encaminhamento.jsp">Encaminhamento</a></li>
            <li><a href="requisicao.jsp">Requisição de Exames</a></li>
        </ul>
    </section>
    <main>
        <article>
            <table>
                <thead>
                    <tr>
                        <th colspan="2">aqui vem o mês</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>                        
                        <td>Seg</td>
                        <td>Ter</td>
                        <td>Qua</td>
                        <td>Qui</td>
                        <td>Sex</td>
                        <td>Sab</td>
                        <td>Dom</td>
                    </tr>
                    <tr>
                        <td>primeira semana</td>
                    </tr>
                    <tr>
                        <td>segunda semana</td>
                    </tr>
                    <tr>
                        <td>terceira semana</td>
                    </tr>
                    <tr>
                        <td>quarta semana</td>
                    </tr>
                    <tr>
                        <td>quinta semana</td>
                    </tr>
                </tbody>
            </table>
        </article>
        <article>.</article>
        <button>Agendar Consulta</button>
    </main>

</body>
<script src="scripts/calendario.js"></script>

</html>