<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requisição de exames</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/exames.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="exame">
            <section class="cadastro">
                <form action="Facade" method="GET">
                    <h3>Requisição de exame:</h3>
                    <label id="tipo-exame">Exame:<br>
                        <input type="text" name="tipo-exame" maxlength="50">
                    </label>
                    <label id="nome-cadastro">Paciente:<br>
                        <input type="text" name="paciente" maxlength="50">
                    </label>
                    <label id="data-hora">Data e hora disponíveis:<br>
                        <input type="text" name="data-hora" maxlength="100">
                    </label>
                    <button id="envia-cadastro" type="submit" name="act" value="requisitarExame">Requisitar exame</button>

                </form>
            </section>    
        </main>
    </body>
</html>
