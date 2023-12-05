<%-- 
    Document   : listagemProfissional
    Created on : 2 de dez. de 2023, 15:21:31
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/profissional.css">
        <%@ page import="br.cefetmg.biosit.dto.Profissional" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemPro">
            <section id="containerPro">
            <% 
                ArrayList<Profissional> lista = (ArrayList<Profissional>) request.getAttribute("profissionais");
                if(lista == null) {
            %>  Erro
            <script>
                setTimeout(function() {
                    window.location.href = "/biosit/index.jsp";
                }, 1000);
            </script>
            <%
                } else if(lista.size() == 0) {
            %> <div>Nenhum profissional encontrado</div>
            <% 
                } else {
                for(Profissional pro : lista) {
            %>
            <article class="unidadeListaPac" onclick="window.location='/biosit/Facade?act=exibirProfissional&cpfExibir=<%=pro.getCpf()%>'">
                <section class="cont-esq">
                    <div class="lpnome"><%=pro.getNome()%></div>
                    <div class="lpcargo"><%=pro.viewCargo()%></div>
                </section>
                <section class="cont-dir">
                    <div class="lpcpf"><%=pro.getCpf()%></div>
                    <div class="lpnasc"><%=Util.converter(pro.getNascimento())%></div>
                </section>
            </article>
            <% }} %>
            </section>
            <button class="btn-voltar" onclick="window.location='/biosit/gerenciarProfissional.jsp'">Voltar</button>
        </main>
    </body>
</html>
