<%@ page import="org.example.horoscopo.dto.UsuarioDTO" %><%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 13/12/2024
  Time: 9:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/head.jsp"/>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("user");
%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Modifica tu perfil
                </div>
                <div class="card-body">
                    <form method="post" action="/editUser">
                        <div class="mb-3">
                            <label for="name" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="name" name="name" value="<%= usuario.getNombre() %>">

                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username" value="<%= usuario.getUsername() %>">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%= usuario.getEmail() %>">
                        </div>
                        <div class="mb-3">
                            <label for="fechaNacimiento" class="form-label">Fecha Nacimiento</label>
                            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<%= usuario.getFechaNacimiento() %>">
                        </div>

                        <input type="text" style="display: none"   name="id" value="<%= usuario.getId() %>">
                        <button type="submit" class="btn btn-primary">Modificar</button>
                    </form>

                </div>
            </div>
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
    });
</script>


<jsp:include page="template/foot.jsp"/>