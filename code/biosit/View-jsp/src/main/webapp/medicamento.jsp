<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="estilos/mae.css">
    <link rel="stylesheet" href="estilos/medicamentos.css">
    <title>Cadastro de Medicamento</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <main id="medicamento">
         <section class="cadastro">
            
                <div class="cadastro">
                    <div>
                     <form action="Facade" method="GET" >
                        <h3>Cadastro de medicamentos</h3>
                            <label id="nome-medicamento">Nome do medicamento:</label><br>
                            <input type="text" id="nome" name="nome" required><br>

                            <label id="fornecedora-medicamento">Fornecedora:</label><br>
                            <input type="text" id="fornecedora" name="fornecedora" required><br>

                            <label id="validade-medicamento">Data de Aquisição:</label><br>
                            <input type="date" id="data" name="data" required><br>

                            <label id="quantidade-medicamento">Quantidade:</label><br>
                            <input type="number" id="quantidade" name="quantidade" required><br><br>
                            
                             <label id="lote-medicamento">Lote:</label><br>
                            <input type="number" id="lote" name="lote" required><br><br>

                            <button id="cadastrar" type="submit" name="act" value="cadastrarMedicamento">Cadastrar</button>
                        </form>
                    </div>
        </section>

       <section class="buscar">
                <form action="Facade" method="GET">
                    <h3>PESQUISA</h3>
                    <label id="nome-buscar">Nome:<br>
                        <input type="text" name="nome" maxlength="50">
                    </label>
                    <label id="fornecedora-buscar">Fornecedora:<br>
                        <input type="number" name="fornecedora">
                    </label>
                    <label id="data-buscar">Validade:<br>
                        <input type="date" name="validade">
                    </label>
                    <label id="quantidade-buscar">Quantidade restante:<br>
                        <input type="text" name="quantidade" maxlength="100">
                    </label><br>
                    <label id="lote-buscar">Lote:<br>
                        <input type="text" name="lote" maxlength="100">
                    </label><br>

                    <button type="submit" name="act" value="buscarMedicamento">Pesquisar</button>
                </form>
            </section>
    </main>
</body>
</html>
