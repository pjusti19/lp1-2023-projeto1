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
        <link rel="stylesheet" href="estilos/prontuario.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="pron">
            <form id="frm" action="Facade" method="GET">
                <section id="att-dados">
                    <section id="dados-principais">
                        <label id="nome-att">Nome:<br>
                            <input type="text" name="nome">
                        </label>
                        <label id="cpf-att">CPF:<br>
                            <input type="number" name="cpf">
                        </label>
                        <label id="data-nascimento-att">Nascimento:<br>
                            <input type="date" name="data-nascimento">
                        </label>
                        <label id="endereco-att">Endereço:<br>
                            <input type="text" name="endereco">
                        </label>
                    </section>
                    <section id="prontuario">

                    </section>
                </section>
                <section id="att-btn">
                    <button id="atualiza-cadastro" type="submit" name="act" value="atualizaCadastro">Atualizar</button>
                    <button id="btn-voltar" onclick="window.history.back();">Voltar</button>
                </section>
            </form>
        </main>
    </body>
</html>
