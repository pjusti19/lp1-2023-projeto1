<%-- 
    Document   : prontuario
    Created on : 22 de out. de 2023, 22:55:27
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Paciente/Prontuário</title>
        <link rel="stylesheet" href="estilos/estilos.css">
        <link rel="stylesheet" href="estilos/paciente.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <section class="cadastro">
                <form action="Facade" method="GET">
                    <label id="nome-cadastro">Nome:<br>
                        <input type="text" name="nome">
                    </label>
                    <label id="cpf-cadastro">CPF:<br>
                        <input type="number" name="cpf">
                    </label>
                    <label id="data-nascimento-cadastro">Nascimento:<br>
                        <input type="date" name="data-nascimento">
                    </label>
                    <label id="endereco-cadastro">Endereço:<br>
                        <input type="text" name="endereco">
                    </label>
                    <button id="envia-cadastro" type="submit" name="act" value="atualizaCadastro">Cadastrar</button>
                </form>
            </section>
            <button onclick="window.history.back();">Voltar</button>
        </main>
    </body>
</html>
