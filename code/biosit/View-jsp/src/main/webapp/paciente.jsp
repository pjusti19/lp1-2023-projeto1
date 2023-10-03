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
        <title>JSP Page</title>
    </head>
    <body>
        <header>hospital legal</header>
        <main>
            
            <form class="cadastro">
                <h3>Cadastrar Paciente</h3>
                <label id="nome-cadastro">Nome:<br>
                    <input type="text" name="nome">
                </label>
                <label id="cpf-cadastro">CPF:<br>
                    <input type="number" name="cpf">
                </label>
                <label id="data-nascimento-cadastro">Data de nascimento:<br>
                    <input type="date" name="data-nascimento">
                </label>
                <label id="endereco-cadastro">Endereço:<br>
                    <input type="text" name="endereco">
                </label>
                <button type="submit">Cadastrar</button>
            </form>
            
            <form class="buscar">
                <h3>Pesquisa</h3>
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
                </label>
                <button type="submit">Pesquisar</button>
            </form>
        </main>
    </body>
</html>
