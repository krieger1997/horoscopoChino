<%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 3:17 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="template/head.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Bienvenid@, Inicia Sesión
                </div>
                <div class="card-body">
                    <form method="post" action="/login">
                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                    </form>
                    <p class="mt-3">Es necesario iniciar sesión para revisar tu horóscopo chino. Si todavía no tienes
                        cuenta, <a href="register">haz click aquí</a>.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    window.addEventListener("load", (event) => {
        // Swal.fire({
        //     title: 'Error!',
        //     text: 'Do you want to continue',
        //     icon: 'error',
        //     confirmButtonText: 'Cool'
        // })
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
    });
</script>


<jsp:include page="template/foot.jsp"/>
