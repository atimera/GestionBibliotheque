<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Adresse</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-address-style.css" />
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
        <h3>Ajouter un membre </h3>

        <form:form action="add" modelAttribute="member" method="post">

            <table>
                <tbody>
                <tr>
                    <td><label for="firstName">Prénom :</label></td>
                    <td><form:input path="firstName" id="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="firstName">Nom :</label></td>
                    <td><form:input path="lastName" id="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="email">Email :</label></td>
                    <td><form:input type="email" path="email" id="email"/></td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="password">Mot de passe :</label></td>
                    <td><form:input type="password" path="password" id="password"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Sexe :</td>
                    <td>
                        <label for="Homme">Homme</label>
                        <form:radiobutton path="gender" value="H" id="Homme"/>
                        <label for="Femme">Femme</label>
                        <form:radiobutton path="gender" value="F" id="Femme"/>
                        <form:errors path="gender" cssClass="error"/>
                    </td>
                </tr>

                </tbody>
            </table>

            <input type="submit" value="Ajouter" class="save"/>

        </form:form>

        <div style="clear: both;"></div>

        <p><a href="${pageContext.request.contextPath}/member/list">Retour à la liste</a></p>

    </div>
</section>

</body>
</html>