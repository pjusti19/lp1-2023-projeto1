<%-- 
    Document   : listagemPaciente
    Created on : 22 de out. de 2023, 21:46:00
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes Encontrados</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <%@ page import="br.cefetmg.biosit.dto.Paciente" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemPaciente">
            <section id="container-lista-paciente">
                <%
                        ArrayList<Paciente> pacientes = (ArrayList<Paciente>) request.getAttribute("pacientes");
                        if(pacientes.size() == 0) {
                %>
                    <div>Nenhum paciente encontrado.</div>
                <%
                        } else {
                            for (Paciente paciente: pacientes) {
                %>
                    <article class="unidadeListaPac" onclick="window.location='/biosit/Facade?act=exibirPaciente&cpfExibir=<%=paciente.getCPF()%>'">
                        <section class="cont-esq">
                            <div class="lpnome"><%=paciente.getNome()%></div>
                            <div class="lpendereco"><%=paciente.getEndereco()%></div>
                        </section>
                        <section class="cont-dir">
                            <div class="lpcpf"><%=paciente.getCPF()%></div>
                            <div class="lpnasc"><%=Util.converter(paciente.getNascimento())%></div>
                        </section>
                    </article>
                <%   }} %>
            </section>
            <button class="btn-voltar" onclick="window.location='/biosit/paciente.jsp'">Voltar</button>
        </main>
    </body>
</html>
