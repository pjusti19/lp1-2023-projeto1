<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipamentos Encontrados</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/equipamento.css">
        <%@ page import="br.cefetmg.biosit.dto.Equipamento" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemEquipamento">
            <section id="container-lista-equipamento">
                <%
                        ArrayList<Equipamento> equipamentos = (ArrayList<Equipamento>) request.getAttribute("pacientes");
                        if(equipamentos.size() == 0) {
                %>
                    <div>Nenhum equipamento encontrado.</div>
                <%
                        } else {
                            for (Equipamento equipamento: equipamentos) {
                %>
                    <article class="unidadeListaEquip" onclick="window.location='/biosit/Facade?act=exibirEquipamento&nomeExibir=<%=equipamento.getNome()%>'">
                        <section class="cont-esq">
                            <div class="lpnome"><%=equipamento.getNome()%></div>
                            <div class="lpfornecedora"><%=equipamento.getFornecedora()%></div>
                        </section>
                        <section class="cont-dir">
                            <div class="lpdata"><%=Util.converter(equipamento.getData())%></div>
                            <div class="lpquantidade"><%=Util.converter(equipamento.getData())%></div>
                            <div class="lpsetor"><%=equipamento.getSetor()%></div>
               
                        </section>
                    </article>
                <%   }} %>
            </section>
            <button class="btn-voltar" onclick="window.location='/biosit/equipamento.jsp'">Voltar</button>
        </main>
    </body>
</html>