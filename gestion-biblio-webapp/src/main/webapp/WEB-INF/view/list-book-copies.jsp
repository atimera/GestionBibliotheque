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
        <h3>Liste des exemplaires</h3>
        <table>
            <tr>
                <th>Livre</th>
                <th>Référence exemplaire</th>
                <th>Date d'achat</th>
            </tr>

            <%-- redirect to Adding Address form --%>
            <input type="button" value="Ajouter"
                   onclick="window.location.href='showBookCopyForm'; return false;"
                   class="add-button" />

            <c:forEach var="copy" items="${copies}" >
                <tr>
                    <td>${copy.book.title}</td>
                    <td>${copy.reference}</td>
                    <td>${copy.dateOfPurchase}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</section>

</body>
</html>