<%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 3:22 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/head.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Bienvenid@, Registrate
                </div>
                <div class="card-body">
                    <form method="post" action="/register">
                        <div class="mb-3">
                            <label for="name" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="mb-3">
                            <label for="fechaNacimiento" class="form-label">Fecha Nacimiento</label>
                            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="mb-3">
                            <label for="rePassword" class="form-label">Repita Contraseña</label>
                            <input type="password" class="form-control" id="rePassword" name="rePassword">
                        </div>
                        <button type="submit" class="btn btn-primary">Registrarse</button>
                    </form>
                    <p class="mt-3">Si ya tienes cuenta, <a href="/">haz click aquí</a>.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    window.addEventListener("load", function (event) {
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        mensajeError("<%= error %>");
        <%
            }
        %>
    });
</script>


<jsp:include page="template/foot.jsp"/>