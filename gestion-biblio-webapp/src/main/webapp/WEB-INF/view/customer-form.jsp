<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Client</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div class="wrapper">
    <div class="header">
        <header>
            <h2>Gestion de bibliothèques</h2>
        </header>
    </div>
</div>


<h2>Saisie d'un client</h2>

<form:form action="processForm" modelAttribute="customer">

    <label for="firstName">Prénom:</label>
    <form:input path="firstName" id="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>

    <label for="lastName">Nom:</label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>

    <label for="email">Email:</label>
    <form:input path="email" id="email"/>
    <form:errors path="email" cssClass="error"/>
    <br><br>

    <input type="submit" value="Valider" />
</form:form>

</body>
</html>