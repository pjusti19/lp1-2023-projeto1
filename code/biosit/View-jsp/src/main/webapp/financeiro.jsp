<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle Financeiro</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/financeiro.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="financeiro">           
            <section class="sla">
                <h3>CONSULTA FINANCEIRA</h3>
                <form>
                    <label id="setor-bucar">Setor:<br>
                <input type="text" name="setor" >
                </label>
                    <label id="data-inicial-busca">Data inicial:<br>
                <input type="date" name="data-inicial">
                </label>
                    <label id="data-final-busca">Data final:<br>
                <input type="date" name="data-final">
                </label>
                <br>
                <button type="submit">Buscar</button>
                <button>Baixar relatório</button>
                </form>
             </section>                     
        </main>
    </body>
</html>
