<%@ page import="org.example.horoscopo.modelo.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 4:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Recuperar el usuario de la sesión
    Usuario user = (Usuario) session.getAttribute("user");

    if (user == null) {
        // Si no hay usuario en sesión, redirigir al login
        response.sendRedirect("/");
        return;
    }
%>

<jsp:include page="template/head.jsp"/>

<div class="container mt-5">
    <h1>BIENVENID@, ${user.getNombre().toUpperCase()} </h1>
    <h2>¿Qué deseas hacer?</h2>

    <div class="row justify-content-center mt-5">
        <div class="col col-lg-3 d-flex justify-content-center">
            <a href="/horoscopo" style="min-width: 80%" role="button" class="btn btn-outline-dark">Conocer tu animal</a>
        </div>
        <div class="col col-lg-3 d-flex justify-content-center">
            <a href="/listaUsuarios" style="min-width: 80%" role="button" class="btn btn-outline-dark">Buscar usuarios</a>
        </div>
        <div class="col col-lg-3 d-flex justify-content-center">
            <a href="/modificaUsuario" style="min-width: 80%" role="button" class="btn btn-outline-dark">Modificar datos</a>
        </div>
        <div class="col col-lg-3 d-flex justify-content-center">
            <a href="/eliminaUsuario?id=${user.getId()}" style="min-width: 80%" role="button" class="btn btn-outline-dark">Eliminar cuenta</a>
        </div>

    </div>
</div>


<jsp:include page="template/foot.jsp"/>