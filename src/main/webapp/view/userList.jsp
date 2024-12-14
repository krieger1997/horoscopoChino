<%@ page import="org.example.horoscopo.dto.UsuarioDTO" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/head.jsp"/>
<%

    // Recuperar el usuario de la sesión
    UsuarioDTO user = (UsuarioDTO) session.getAttribute("user");

    if (user == null) {
        // Si no hay usuario en sesión, redirigir al login
        response.sendRedirect("/");
        return;
    }
    //    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("user");
    List<UsuarioDTO> usuariosLista = (List<UsuarioDTO>) request.getAttribute("userList");

%>
<div class="container mt-5">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Fecha Nacimiento</th>
            <th scope="col">Animal</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (usuariosLista != null) {
                for (UsuarioDTO usuario : usuariosLista) {
        %>
            <tr>
                <td><%= usuario.getId()%></td>
                <td><%= usuario.getNombre()%></td>
                <td><%= usuario.getUsername()%></td>
                <td><%= usuario.getEmail()%></td>
                <td><%= usuario.getFechaNacimiento()%></td>
                <td><%= usuario.getAnimal()%></td>
            </tr>

        <%
                }
            }
        %>

        </tbody>
    </table>


</div>

<jsp:include page="template/foot.jsp"/>
