<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/header.css">
    </head>
    <header>
        <div class="bloco">
            <img src="imgs/icone.png" id="icone">
            <div>
                <h1>HospitalLegal</h1>
                <h3>MEDICAL</h3>
            </div>
        </div>
        <div class="bloco" id="menu">
            <button id="mostrar-notificacoes"><img src="imgs/sino.png" id="sino"></button>
            <button id="mostrar-menu"><img src="imgs/iconemenu.png" id="sino"></button>

        </div>
    </header>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        function exibirNotificacao() {
            $.get("/ExibirNotificacao", function(data) {
                $("#resultado").html(data);
            });
        }
    </script>
    <section id="opcoes" class="menu-escondido">
        <h1>Menu</h1>
        <%

            HttpSession sessionObj = request.getSession(false);
            Object tipoUsuario = (sessionObj != null) ? sessionObj.getAttribute("tipoUsuario") : null;

            if (tipoUsuario != null && tipoUsuario.toString().contains("medico")) {

        %>
            <ul class="lista">
                <a href="encaminhamento.jsp"><li>Encaminhamento</li></a>
                <a href="exame.jsp"><li>Requisição de Exames</li></a>
            </ul>
        <% } 
           if (tipoUsuario != null && tipoUsuario.toString().contains("secretario")) {
        %>
            <ul class="lista">
                <a href="paciente.jsp"><li>Paciente</li></a>
            </ul>
        <% } 
           if (tipoUsuario != null && tipoUsuario.toString().contains("enfermeiro")) {
        %>
            <ul class="lista">
                <a href="encaminhamento.jsp"><li>Encaminhamento</li></a>
                <a href="exame.jsp"><li>Requisição de Exames</li></a>
            </ul>
        <% } 
           if (tipoUsuario != null && tipoUsuario.toString().contains("secretarioTriagem")) {
        %>

            <ul class="lista">
                <a href="triagem.jsp"><li>Triagem</li></a>
            </ul>
        <% }
           if (tipoUsuario != null && tipoUsuario.toString().contains("admin")) { 
        %>
            <ul class="lista">
                <a href="medicamento.jsp"><li>Medicamento</li></a>
                <a href="gerenciarProfissional.jsp"><li>Funcionários</li></a>
                <a href="equipamento.jsp"><li>Equipamentos</li></a>
                <a href="paciente.jsp"><li>Paciente</li></a>
                <a href="ExibirTriagem"><li>Triagem</li></a>
                <a href="ListagemInternacao"><li>Internacao</li></a>
                <a href="financeiro.jsp"><li>Financeiro</li></a>
                <a href="encaminhamento.jsp"><li>Encaminhamento</li></a>
                <a href="exame.jsp"><li>Requisição de Exames</li></a>
            </ul>
        <% } %>
    </section>
    <section id="notificacoes" class="menu-escondido">
        <h1>Notificações</h1>
        <button onclick="exibirNotificacao()">Exibir consultas recém cadastrados</button>

    <div id="resultado">
        
    </div>
    </section>
    <script src="scripts/header.js"></script>
</html>