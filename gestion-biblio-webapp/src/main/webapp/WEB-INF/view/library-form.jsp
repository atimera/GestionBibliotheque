<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Adresse</title>
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


<h3>Saisie d'une adresse</h3>


<form:form action="processForm" modelAttribute="library">

    <label for="name">Nom:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name" cssClass="error"/>
    <br><br>

<%--
    <label for="postalCode">Adresse:</label>
    <form:input path="address" id="address"/>
    <form:errors path="address" cssClass="error"/>
    <br><br>

    <label for="postalCode">Adresse 2:</label>
    <form:input path="address2" id="address2"/>
    <form:errors path="address2" cssClass="error"/>
    <br><br>

    <label for="postalCode">Code postal:</label>
    <form:input path="postalCode" id="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>

    <label for="postalCode">Ville:</label>
    <form:input path="city" id="city"/>
    <form:errors path="city" cssClass="error"/>
    <br><br>
--%>

    <input type="submit" value="Valider" />
</form:form>

</body>
</html>