
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/equipamentos.css">
        <title>Cadastro de Equipamento</title>
    </head>
    <body>


    <%@include file="header.jsp" %>

    <main id="equipamento">
        <section class="cadastro">

            <div class="cadastro">
                <div>
                    <form action="Facade" method="GET" >
                        <h3>Cadastro de Equipamento</h3>
                        <label id="nome-equipamento">
                            Nome do Equipamento:
                            <input type="text" id="nome" name="nome" required>
                        </label>
                        <label id="fornecedora-equipamento">
                            Fornecedora:
                            <br>
                            <input type="text" id="fornecedora" name="fornecedora" required>
                        </label>


                        <label id="data-aquiscao-equipamento">
                            Data de Aquisição:
                            <br>
                            <input type="date" id="data" name="data" required>
                        </label>

                        <label id="quantidade-equipamento">
                            Quantidade:
                            <br>
                            <input type="number" id="quantidade" name="quantidade" required>
                        </label>
                        <label id="setor-equipamento">
                            Setor:
                            <br>
                            <input type="text" id="setor" name="setor" required>
                        </label>


                        <button id="cadastrar" type="submit" name="act" value="cadastrarEquipamento">Cadastrar</button>
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
                    <input type="text" name="fornecedora">
                </label>
                <label id="data-buscar">Data de aquisição:<br>
                    <input type="date" name="data">
                </label>
                <label id="quantidade-buscar">Quantidade:<br>
                    <input type="text" name="quantidade" maxlength="100">
                </label>
                <label id="setor-buscar">Setor:<br>
                    <input type="text" name="setor" maxlength="100">
                </label><br>
                <button type="submit" name="act" value="buscarEquipamento">Pesquisar</button>
            </form>
        </section>
    </main>
</body>
</html>
