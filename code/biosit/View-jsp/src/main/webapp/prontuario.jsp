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
        <%@ page import="br.cefetmg.biosit.dto.Paciente" %>
        <%@ page import="java.util.ArrayList" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="pron">
            <form id="frm" action="Facade" method="GET">
                <section id="att-dados">
                    <% Paciente paciente = (Paciente) request.getAttribute("paciente_exib"); %>
                    <section id="dados-principais">
                        <label id="nome-att">Nome:<br>
                            <input type="text" name="nome" value='<%=paciente.getNome()%>'>
                        </label>
                        <label id="cpf-att">CPF:<br>
                            <input type="number" name="cpf" value=<%=paciente.getCPF()%>>
                        </label>
                        <label id="data-nascimento-att">Nascimento:<br>
                            <input type="date" name="data-nascimento" value="<%=paciente.getNascimento()%>">
                        </label>
                        <label id="endereco-att">Endereço:<br>
                            <input type="text" name="endereco" value='<%=paciente.getEndereco()%>'>
                        </label>
                    </section>
                    <section id="dados-secundarios">
                        <label id="rg-att">RG:<br>
                            <input type="text" name="rg" value='<%=paciente.getRG()%>'>
                        </label>
                        <label id="tel-att">Tel:<br>
                            <input type="text" name="tel" value='<%=paciente.getTel()%>'>
                        </label>
                    </section>
                    <section id="prontuario">

                    </section>
                </section>
                <section id="att-btn">
                    <button id="atualiza-cadastro" type="submit" name="act" value="atualizaCadastro">Atualizar</button>
                    <button id="btn-voltar" onclick="window.location='/biosit/index.jsp'">Voltar</button>
                </section>
            </form>
        </main>
    </body>
</html>
