<%-- 
    Document   : listagemPaciente
    Created on : 22 de out. de 2023, 21:46:00
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes Encontrados</title>
        <link rel="stylesheet" href="estilos/estilos.css">
        <link rel="stylesheet" href="estilos/paciente.css">

    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemPaciente">
            <section>
                <article>
                    <div>Nome Foda</div>
                    <div>111.111.111-11</div>
                </article>
                <article>
                    <div>Nome Foda</div>
                    <div>111.111.111-11</div>
                </article> 
            </section>
            <button class="btn-voltar" onclick="window.history.back();'">Voltar</button>
        </main>
    </body>
</html>
