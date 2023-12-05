<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle Financeiro</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/financeiro.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="financeiro">           
            <section class="sla">
                <h3>CONSULTA FINANCEIRA</h3>
                <form action="Facade" method="GET">
                    <label id="setor-bucar">Setor:<br>
                        <input type="text" name="categoria" >
                    </label>
                    <label id="data-inicial-busca">Data inicial:<br>
                        <input type="date" name="data-inicial">
                    </label>
                    <label id="data-final-busca">Data final:<br>
                        <input type="date" name="data-final">
                    </label>
                    <br>
                    <div id="planilha"><%if(request.getAttribute("valores") != null){%><%@include file="listagemFinanceiro.jsp"%><%} %>
                        <%
                        
                        String erro = (String) request.getAttribute("error");
                        if (erro != null && !erro.isEmpty()) {
                        %>
                        <div class="mensagem-erro">
                            <%= erro %>
                        </div></div><%
                    } %>
                    <button type="submit" id="buscar-financeiro" name="act" value="buscarFinanceiro">Buscar</button>
                </form>

                <%if(request.getAttribute("valores") != null){
                ArrayList<Financeiro> valores = (ArrayList<Financeiro>) request.getAttribute("valores");
                %>
                <form action="SeuServlet" method="post">
                    <input type="hidden" name="suaVariavel" value="<%= valores %>">                    
                    <button type="submit" id="baixar-financeiro" name="act" value="baixarRelatório">Baixar relatório</button>
                </form>
                <%} %>
            </section>                     
        </main>
    </body>
</html>
