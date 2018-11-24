<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Adresse</title>

    <style type="text/css">
        .error{ color: red; }
    </style>
</head>
<body>

<h2>Saisie d'une adresse</h2>

<form:form action="processForm" modelAttribute="address">

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

    <input type="submit" value="Valider" />
</form:form>

</body>
</html>