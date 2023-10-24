<%-- 
    Document   : estoque
    Created on : 16 de out. de 2023, 15:18:46
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="estilos/estilos.css">
    <title>Cadastro de Equipamento</title>
</head>
<body>
    <%@include file="header.jsp" %>
    
    <div class="cinza" style="background-color: rgb(209, 209, 209);">
        <div class="cadastro" style="display: flex;">
            <div style="flex: 1; padding: 20px; background-color: white; margin: 2%; align-items: center;">
             <form action="Facade" method="GET" >
                <h3>Cadastro de Equipamento</h3>
                    <label id="nome-equipamento">Nome do Equipamento:</label><br>
                    <input type="text" id="nome" name="nome" required><br>

                    <label id="fornecedora-equipamento">Fornecedora:</label><br>
                    <input type="text" id="fornecedora" name="fornecedora" required><br>

                    <label id="data-aquiscao-equipamento">Data de Aquisição:</label><br>
                    <input type="date" id="data" name="data" required><br>

                    <label id="quantidade-equipamento">Quantidade:</label><br>
                    <input type="number" id="quantidade" name="quantidade" required><br><br>

                    <button id="cadastrar" type="submit" name="act" value="cadastrarEquipamento">Cadastrar</button>
                </form>
            </div>

        <div style="flex: 1; padding: 20px;" class="buscar">
            <h3>Busca de Equipamento</h3>
            <input type="text" class="buscar-nome-equipamentos" name="buscaNome" placeholder="Pesquisar..." ><br>
            <input type="text" class="buscar-nome-equipamento" name="buscaNome" placeholder="Nome:"><br>
            <input type="text" class="buscar-nome-equipamento" name="buscaNome" placeholder="Fornecedora:"><br>
            <input type="text" class="buscar-nome-equipamento" name="buscaNome" placeholder="Setor:">  
            <input type="text" class="buscar-nome-equipamento" name="buscaNome" placeholder="Data:"><br>
            <input type="text" class="buscar-nome-equipamento" name="buscaNome" placeholder="Quantidade:"><br><br>
        
            <button type="button" id="consultarHistorico">Consultar Histórico</button><br>
            <button type="button" id="removerEquipamento">Remover Equipamento</button>
        </div>
    </div>

    </div>

</body>
</html>