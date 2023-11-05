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
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <link rel="stylesheet" href="estilos/prontuario.css">
        <%@ page import="br.cefetmg.biosit.dto.Paciente" %>
        <%@ page import="java.util.ArrayList" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="pron">
            <section id="containerwt">
            <form id="frm" action="Facade" method="GET">
                <section id="att-dados">
                    <section id="menu-att-paciente">
                        <div id="sec-geral" class="btn-secao selected">Dados Gerais</div>
                        <div id="sec-pron" class="btn-secao">Prontuário</div>
                        <div id="sec-cons" class="btn-secao">Exibir Consultas</div>
                    </section>
                    <% Paciente paciente = (Paciente) request.getAttribute("paciente_exib");
                    if(paciente.getRG() == null) paciente.setRG("");
                    if(paciente.getTel() == null) paciente.setTel("");
                    %>
                    <section id="dados-gerais" class="secao-sel">
                        <section id="dados-principais">
                            <label id="nome-att">Nome:<br>
                                <input type="text" name="nome" value='<%=paciente.getNome()%>'>
                            </label>
                            <label id="cpf-att">CPF:<br>
                                <input type="number" name="cpf" readonly value=<%=paciente.getCPF()%>>
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
                    </section>
                    <section id="prontuario" class="secao-sel secao-oculta">
                        <section>Prontuario</section>
                    </section>
                    <section class="secao-sel secao-oculta">
                        <section>Consultas</section>
                    </section>
                </section>
                <section id="att-btn">
                    <a id="btn-voltar" onclick="location.href = 'paciente.jsp'">Voltar</a>
                    <button id="atualiza-cadastro" type="submit" name="act" value="atualizaPaciente">Atualizar</button>
                    <a id="btn-delete" onclick="window.location='/biosit/Facade?act=excluirPaciente&cpfExcluir=<%=paciente.getCPF()%>'">Excluir</a>
                </section>
                <%
                    String erro = (String) request.getAttribute("error");
                    if (erro != null && !erro.isEmpty()) {
                    %>
                    <div class="mensagem-erro">
                        <%= erro %>
                    </div>
                    <%
                    } else {
                        String sucess = (String) request.getAttribute("sucess");
                        if(sucess != null && !sucess.isEmpty()) {
                    %>
                    <div class="mensagem-sucesso">
                        <%= sucess %>
                    </div>
                    <%
                        } }
                    %>
            </form>
            </section>
        </main>
        <script src="scripts/prontuario.js"></script>
    </body>
</html>
