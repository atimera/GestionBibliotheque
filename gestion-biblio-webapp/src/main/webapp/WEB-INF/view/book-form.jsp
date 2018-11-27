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
        <h3>Ajouter un livre</h3>

        <form:form action="saveBook" modelAttribute="book" method="post">

            <table>
                <tbody>
                <tr>
                    <td><label for="title">Titre :</label></td>
                    <td><form:input path="title" id="title" /></td>
                    <td><form:errors path="title" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="dateOfPublication">Date de publication:</label></td>
                    <td><form:input type="date" path="dateOfPublication" id="dateOfPublication" /></td>
                    <td><form:errors path="dateOfPublication" cssClass="error"/></td>
                </tr>

                </tbody>
            </table>

            <input type="submit" value="Ajouter" class="save"/>

        </form:form>

        <div style="clear: both;"></div>

        <p><a href="${pageContext.request.contextPath}/book/list">Retourà la liste</a></p>

    </div>
</section>

</body>
</html>