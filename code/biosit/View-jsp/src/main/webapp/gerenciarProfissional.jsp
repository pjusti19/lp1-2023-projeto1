<%-- 
    Document   : gerenciarProfissional
    Created on : 15 de nov. de 2023, 21:57:36
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profissionais da saúde</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <section>
                <form>
                    <h3>Cadastro</h3>
                    <label>Nome: <br>
                        <input type="text" name="nome">
                    </label>
                    <label>CPF: <br>
                        <input type="number" name="cpf">
                    </label>
                    <label>Nascimento: <br>
                        <input type="text" name="nascimento">
                    </label>
                    <label>Email: <br>
                        <input type="email" name="email">
                    </label>
                    <label>Registro: <br>
                        <input type="text" name="registro">
                    </label>
                    <label>Cargo: <br>
                        <select name="cargo">
                            <option value="gerente">Gerente</option>
                            <option value="secretario">Secretário</option>
                            <option value="medico">Médico</option>
                        </select>
                    </label>
<!--                    <label>Especialidade: <br>
                        <select name="especialidade">
                            <option value="cardiologia">Cardiologia</option>
                            <option value="cirurgia">Cirurgia</option>
                            <option value="pediatria">Pediatria</option>
                        </select>
                    </label>-->
                </form>
                <form>
                    <h3>Pesquisar</h3>
                </form>
            </section>
        </main>
    </body>
</html>
