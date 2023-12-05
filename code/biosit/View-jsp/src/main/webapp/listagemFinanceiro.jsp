<%-- 
    Document   : listagemFinanceiro
    Author     : David Eller
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>u</title>
        <%@ page import="br.cefetmg.biosit.dto.Financeiro" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="java.text.DateFormat" %>
        <%@ page import="java.text.SimpleDateFormat" %>
        <%@ page import="java.time.LocalDate" %>
        <%@ page import="java.time.format.DateTimeFormatter" %>
        <%@ page import="java.util.Calendar" %>
        <%@ page import="java.util.Date" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>
        <style ref="estilos/financeiro.css"></style>
    </head>
    <body>
        <%
                        ArrayList<Financeiro> valores = (ArrayList<Financeiro>) request.getAttribute("valores");
                        if(valores.size() == 0) {
        %>
        <div>Nenhum paciente encontrado.</div>
        <%
                        } else { 
                        String pattern = "MM/dd/yyyy";
                        DateFormat df = new SimpleDateFormat(pattern);%>
        <table>
            <thead>
                <tr>
                    <th>Valor</th>
                    <th>Categoria</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <% for (Financeiro financeiro : valores) { %>
                <tr>
                    <td><%= financeiro.getValor() %></td>
                    <td><%= financeiro.getCategoria() %></td>
                    <td><%= df.format(financeiro.getData()) %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <%   } %>
    </body>
</html>
