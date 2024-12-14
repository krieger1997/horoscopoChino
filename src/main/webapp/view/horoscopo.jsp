<%@ page import="org.example.horoscopo.dto.UsuarioDTO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/head.jsp"/>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("user");
%>
<div class="container mt-5">
    <h1>Conoce a tu animal del horóscopo chino.</h1>
    <h2 class="mt-5">${user.getNombreCap()}, Tu animal es <strong> ${user.getAnimal()} </strong></h2>
</div>

<jsp:include page="template/foot.jsp"/>
