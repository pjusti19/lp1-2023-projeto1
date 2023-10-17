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
                <form action="Facade" method="GET">
                    <h3>CADASTRO</h3>
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
                    <button type="submit" name="act" value="cadastrarPaciente">Cadastrar</button>
                </form>
            </section>
            
            <section class="buscar">
                <form action="Facade" method="GET">
                    <h3>PESQUISA</h3>
                    <label id="nome-bucar">Nome:<br>
                        <input type="text" name="nome">
                    </label>
                    <label id="cpf-busca">CPF:<br>
                        <input type="number" name="cpf">
                    </label>
                    <label id="data-nascimento-busca">Data de nascimento:<br>
                        <input type="date" name="data-nascimento">
                    </label>
                    <label id="endereco-busca">Endereço:<br>
                        <input type="text" name="endereco">
                    </label><br>
                    <button type="submit" name="act" value="BuscarPaciente">Pesquisar</button>
                </form>
            </section>    
        </main>
    </body>
</html>
