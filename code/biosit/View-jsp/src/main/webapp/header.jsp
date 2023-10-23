<%-- 
    Document   : header
    Created on : 3 de out. de 2023, 18:45:04
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <div class="bloco">
            <img src="imgs/icone.png" id="icone">
            <div>
                <h1>HospitalLegal</h1>
                <h3>MEDICAL</h3>
            </div>
        </div>
        <div class="bloco" id="menu">
            <button><img src="imgs/sino.png" id="sino"></button>
            <button id="mostrar-menu">☰</button>
        </div>
    </header>
    <section id="opcoes" class="menu-escondido">
        <h1>Menu</h1>
        <ul class="lista">
            <li><a href="estoque.jsp">Estoque</a></li>
            <li><a href="funcionarios.jsp">Funcionários</a></li>
            <li><a href="equipamentos.jsp">Equipamentos</a></li>
            <li><a href="paciente.jsp">Paciente</a></li>
            <li><a href="triagem.jsp">Triagem</a></li>
            <li><a href="financeiro.jsp">Financeiro</a></li>
            <li><a href="encaminhamento.jsp">Encaminhamento</a></li>
            <li><a href="requisicao.jsp">Requisição de Exames</a></li>
        </ul>
    </section>
    <script src="scripts/header.js"></script>
</html>
