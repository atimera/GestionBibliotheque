<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Livre</title>
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
        <h3>Ajouter un exemplaire du livre</h3>

        <form:form action="addCopy" modelAttribute="copy" method="post">

            <table>
                <tbody>
                <tr>
                    <td><label>Titre du livre :</label></td>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <td><label for="reference">La référence:</label></td>
                    <td><form:input path="reference" id="reference" /></td>
                    <td><form:errors path="reference" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="dateOfPurchase">Date de publication:</label></td>
                    <td><form:input type="date" path="dateOfPurchase" id="dateOfPurchase" /></td>
                    <td><form:errors path="dateOfPurchase" cssClass="error"/></td>
                </tr>

                </tbody>
            </table>

            <input type="submit" value="Ajouter" class="save"/>

        </form:form>

        <div style="clear: both;"></div>

        <p><a href="${pageContext.request.contextPath}/book/list">Retour à la liste</a></p>

    </div>
</section>

</body>
</html>