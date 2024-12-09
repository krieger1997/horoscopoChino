<%@ page import="org.example.horoscopo.modelo.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 3:25 pm
  To change this template use File | Settings | File Templates.
--%>
<%
    // Recuperar el usuario de la sesión
    Usuario user = (Usuario) session.getAttribute("user");


%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <title>Horoscopo Chino</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script >


        function mensajeSuccess(text){
            Swal.fire({
                text,
                icon: 'success',
                confirmButtonText: 'Continuar😊'
            })
        }
        function mensajeError(text){
            Swal.fire({
                text,
                icon: 'error',
                confirmButtonText: 'OK😞'
            })
        }
    </script>
</head>

<body>

<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Yin_yang.svg/512px-Yin_yang.svg.png"
                 alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            <span class="h2">Horoscopo Chino</span>
        </a>

<%--        <% if (sesion != null) { %>--%>
<%
    if (user != null) {
        %>
        <a role="button" class="btn btn-light" href="/logout">Cerrar Sesión</a>
        <%

    }
%>

<%--        <% } %>--%>


    </div>
</nav>


