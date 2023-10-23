<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle Financeiro</title>
        <link rel="stylesheet" href="estilos/estilos.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="financeiro">           
            <section class="sla">
                <h3>CONSULTA FINANCEIRA</h3>
                <form>
                <label id="setor-bucar">Setor:</label>
                <input type="text" name="setor">
                <label id="data-inicial-busca">Data inicial:</label>
                <input type="date" name="data-inicial">
                <label id="data-final-busca">Data final:</label>
                <input type="date" name="data-final"><br>
                <button type="submit">Buscar</button>
                <button>Baixar relatório</button>
                </form>
             </section>                     
        </main>
    </body>
</html>
