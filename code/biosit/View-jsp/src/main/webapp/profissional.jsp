<%-- 
    Document   : profissional
    Created on : 3 de dez. de 2023, 02:53:44
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profissional</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <link rel="stylesheet" href="estilos/profissional.css">
        <%@ page import="br.cefetmg.biosit.dto.*" %>
        <%@ page import="java.util.ArrayList" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            
            <%  
                Profissional pro = (Profissional) request.getAttribute("profissional");
                if(pro == null) {
            %>  <script>
                    window.location.href = "biosit/index.jsp";
                </script>
            <% } %>
            
            <form id="container" action="Facade" method="POST">
                
                <section id="menuu">
                    <div id="opcao-geral" class="opcao-menu selected">Dados Gerais</div>
                    <% if(pro.getCargo().equals("medico")) { %>
                        <div id="opcao-medico" class="opcao-menu">Dados Médicos</div>
                    <% } %>
                    <div id="opcao-acesso" class="opcao-menu">Acesso</div>
                </section>
                    
                <section id="dados-gerais" class="containersec">
                    <section id="principal">
                        <label id="att-nome">Nome:<br>
                            <input type="text" name="nome" value="<%= pro.getNome() %>">
                        </label>
                        <label id="att-nascimento">Nascimento:<br>
                            <input type="date" name="nascimento" value="<%= pro.getNascimento() %>">
                        </label>
                        <label id="att-cpf">CPF:<br>
                            <input type="number" name="cpf" value="<%= pro.getCpf() %>" readonly>
                        </label>
                        <label id="att-tel">Telefone:<br>
                            <input type="tel" name="tel" value="<%= pro.getTel() %>">
                        </label>
                        <label id="att-email">Email:<br>
                            <input type="text" name="email" value="<%= pro.getEmail() %>">
                        </label>
                    </section>
                    <section id="funcional">
                        <label id="att-rg">RG:<br>
                            <input type="text" name="rg" value="<%= pro.getRG() %>">
                        </label>
                        <label id="att-dataAdmissao">Admissão:<br>
                            <input type="text" readonly name="dataAdmissao" value="<%= pro.getAdmissao() %>">
                        </label>
                        <label id="att-cargo">Cargo:<br>
                            <input type="text" name="" value="<%= pro.viewCargo() %>" readonly>
                            <input name="cargo" type="hidden" value="<%= pro.getCargo() %>">
                        </label>
                        <label id="att-salario">Salário:<br>
                            <input type="number" name="salario" value="<%= pro.getSalario() %>">
                        </label>
                    </section>
                    <button id="exc" name="act" value="excluirProfissional">Excluir</button>
                    <button id="att" name="act" value="atualizarProfissional">Atualizar</button>
                </section>
                
                <% if(pro.getCargo().equals("medico")) { %>
                <section id="dados-medicos" class="containersec secao-oculta">
                    <section id="medic">
                        <label id="att-registro">Registro:<br>
                            <input type="text" name="registro" value="<%= pro.getRegistro() %>">
                        </label>
                        <label id="att-especializacao">Especialização:<br>
                            <input type="text" name="especializacao" value="<%= pro.getEspecialidade() %>">
                        </label>
                        <label id="att-graduacao">Instituição de Graduação:<br>
                            <input type="text" name="instituicao" value="<%= pro.getInstituicao() %>">
                        </label>
                        <label id="att-anograd">Ano de Graduação:
                            <input type="number" name="ano-grad" value="<%= pro.getAnoGrad() %>">
                        </label>
                    </section>
                    <button id="exc2" name="act" value="excluirProfissional">Excluir</button>
                    <button id="att2" name="act" value="atualizarProfissional">Atualizar</button>
                </section>
                <% } %>
                
                <section id="acesso" class="containersec secao-oculta">
                    Acesso
                </section>
            </form>
                <% String erro = (String) request.getAttribute("error");
                    if (erro != null && !erro.isEmpty()) {
                %>
                    <div class="mensagem-erro">
                        <%= erro %>
                    </div>
                <%
                    }
                %>
        </main>
        <script src="scripts/profissional.js"></script>
    </body>
</html>
