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
        <%@include file="header.jsp" %>
        <main>
            <div id="centro">
                <article id="calendario" class="sombreado">
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
                                <th>Sab</th>
                            </tr>
                        </thead>
                        <tbody id="corpoCalendario"></tbody>
                    </table>
                </article>
                <article id="agenda" class="sombreado">
                    <h1 id="dataPorExtenso"></h1>
                    <h3 id="diaDaSemana"></h3>
                    <form action="buscarConsulta" method="post">
                        <div class="botaoDeBusca">                      
                            <input type="text" id="inputBusca" placeholder="Digite sua busca">   
                            <button id="buscar"><img src="imgs/lupa.png"? id="iconeBuscar"></button>
                        </div>
                    </form>
                    <!-- não funciona ainda
                    <ul>
                        <c:forEach var="item" items="${dados}">
                            <li>${item.horario} ${item.nome}</li>
                            </c:forEach>
                        <c:forEach var="i" begin="0" end="${nomes.size() - 1}">
                            <li>${nomes[i]} ${horarios[i]}</li>
                            </c:forEach>
        
                    </ul>  -->

                </article>
            </div>
            <div id="divisao">
                <button id="agendar">Agendar Consulta</button>
            </div>
        </main>

    </body>
    <script src="scripts/calendario.js"></script>
    <script src="scripts/agenda.js"></script>

</html>
