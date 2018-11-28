<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Adresse</title>
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />--%>
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-address-style.css" />--%>
    <style type="text/css">
        .error{ color: red; }
    </style>
</head>
<body>

<div class="wrapper">
    <div class="header">
        <header>
            <h2>Gestion de bibliothèques</h2>
        </header>
    </div>
</div>

<section class="container">
    <div class="content">
        <h3>Connexion</h3>

        <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                   method="post">

            <table>
                <tbody>
                <tr><c:if test="${param.error != null }"><i class="error">Identifiant ou mot de passe incorrect</i></c:if> </tr>
                <tr>
                    <td><label for="username">Login :</label></td>
                    <td><input name="username" id="username" /></td>
                </tr>
                <tr>
                    <td><label for="password">Mot de passe :</label></td>
                    <td><input type="password" name="password" id="password" /></td>
                </tr>
                </tbody>
            </table>

            <input type="submit" value="Valider" class="save"/>

        </form:form>

    </div>
</section>

</body>
</html>