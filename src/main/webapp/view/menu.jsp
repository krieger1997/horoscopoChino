<%@ page import="org.example.horoscopo.dto.UsuarioDTO" %><%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 4:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Recuperar el usuario de la sesión
    UsuarioDTO user = (UsuarioDTO) session.getAttribute("user");

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
            <a href="/userList" style="min-width: 80%" role="button" class="btn btn-outline-dark">Buscar usuarios</a>
        </div>
        <div class="col col-lg-3 d-flex justify-content-center">
            <a href="/editUser" style="min-width: 80%" role="button" class="btn btn-outline-dark">Modificar datos</a>
        </div>
        <div class="col col-lg-3 d-flex justify-content-center">
            <a  id="eliminaUsuario" style="min-width: 80%" role="button"
               class="btn btn-outline-dark">Eliminar cuenta</a>
        </div>

    </div>
</div>

<script>
    window.addEventListener("load", (event) => {

        <%
            String error = (String) request.getAttribute("error");
            String success = (String) request.getAttribute("success");
            if (error != null) {
        %>
        <%--alert("<%= error %>");--%>
        mensajeError("<%= error %>")
        <%
            }else if(success!=null){
              %>
        <%--alert("<%= success %>");--%>
        mensajeSuccess("<%= success %>")
        <%
            }
        %>

        document.getElementById("eliminaUsuario").addEventListener("click", (event) => {
            event.preventDefault();
            Swal.fire({
                title: 'Estas seguro?',
                text: "No podras revertir esta accion!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, Eliminar!'
            }).then((result) => {
                if (result.isConfirmed) {

                    window.location.href = "/deleteUser?id=${user.getId()}";
                }
            })
        })
    });
</script>
<jsp:include page="template/foot.jsp"/>