<%-- 
    Document   : paciente
    Created on : 3 de out. de 2023, 09:43:08
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de paciente</title>
        <link rel="stylesheet" href="estilos/estilos.css">
        <link rel="stylesheet" href="estilos/paciente.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="paciente">
            <section class="cadastro">
                <form action="Facade" method="POST">
                    <h3>CADASTRO</h3>
                    <label id="nome-cadastro">Nome:<br>
                        <input type="text" name="nome" maxlength="50">
                    </label>
                    <label id="cpf-cadastro">CPF:<br>
                        <input type="number" name="cpf">
                    </label>
                    <label id="data-nascimento-cadastro">Nascimento:<br>
                        <input type="date" name="data-nascimento">
                    </label>
                    <label id="endereco-cadastro">Endereço:<br>
                        <input type="text" name="endereco" maxlength="100">
                    </label>
                    <button id="envia-cadastro" type="submit" name="act" value="cadastrarPaciente">Cadastrar</button>
                    <%
                    String error = (String) request.getAttribute("error");
                    if (error != null && !error.isEmpty()) {
                    %>
                    <div class="mensagem-erro">
                        <%= error %>
                    </div>
                    <%
                    }
                    %>
                </form>
            </section>
            
            <section class="buscar">
                <form action="Facade" method="POST">
                    <h3>PESQUISA</h3>
                    <label id="nome-bucar">Nome:<br>
                        <input type="text" name="nome" maxlength="50">
                    </label>
                    <label id="cpf-busca">CPF:<br>
                        <input type="number" name="cpf">
                    </label>
                    <label id="data-nascimento-busca">Nascimento:<br>
                        <input type="date" name="data-nascimento">
                    </label>
                    <label id="endereco-busca">Endereço:<br>
                        <input type="text" name="endereco" maxlength="100">
                    </label><br>
                    <button type="submit" name="act" value="BuscarPaciente">Pesquisar</button>
                </form>
            </section>    
        </main>
        <!--<script>-->
            <!--document.querySelector("#envia-cadastro").addEventListener('click', ()=>location.href="/Facade");-->
        <!--</script>-->
    </body>
</html>
