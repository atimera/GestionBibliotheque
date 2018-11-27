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
        <h3>Ajouter une adresse</h3>

        <form:form action="saveAddress" modelAttribute="address" method="post">

            <table>
                <tbody>
                    <tr>
                        <td><label for="address">Adresse :</label></td>
                        <td><form:input path="address" id="address" /></td>
                        <td><form:errors path="address" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label for="address2">Adresse 2:</label></td>
                        <td><form:input path="address2" id="address2" /></td>
                        <td><form:errors path="address2" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label for="postalCode">Code postal :</label></td>
                        <td><form:input path="postalCode" id="postalCode"/></td>
                        <td><form:errors path="postalCode" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label for="city">Ville :</label></td>
                        <td><form:input path="city" id="city"/></td>
                        <td><form:errors path="city" cssClass="error"/></td>
                    </tr>

                </tbody>
            </table>

            <input type="submit" value="Ajouter" class="save"/>

        </form:form>

        <div style="clear: both;"></div>
        
        <p><a href="${pageContext.request.contextPath}/address/list">Retourà la liste</a></p>

    </div>
</section>

</body>
</html>