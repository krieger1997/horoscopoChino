<%@ page import="org.example.horoscopo.modelo.Horoscopo" %><%--
  Created by IntelliJ IDEA.
  User: Claud
  Date: 08/12/2024
  Time: 3:23 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/head.jsp"/>
<%
    Horoscopo horoscopo = (Horoscopo) session.getAttribute("horoscopo");
%>
<div class="container mt-5">
    <h1>Conoce a tu animal del horóscopo chino.</h1>
    <h2 class="mt-5">${user.getNombreCap()}, Tu animal es <strong> ${horoscopo.getAnimal()} </strong></h2>
</div>

<jsp:include page="template/foot.jsp"/>
