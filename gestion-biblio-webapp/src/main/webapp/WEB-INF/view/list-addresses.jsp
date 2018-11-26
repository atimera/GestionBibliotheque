<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adresse - Liste</title>
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

<section class="container">

    <h2>Liste des adresses</h2>

    <div class="content">
        <table>
            <tr>
                <th>Adresse</th>
                <th>Code Postal</th>
                <th>Ville</th>
            </tr>

            <%-- redirect to Adding Address form --%>
            <input type="button" value="Ajouter"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button" />

            <c:forEach var="address" items="${addresses}" >
                <tr>
                    <td>${address.address} <br> ${address.address2}</td>
                    <td>${address.postalCode}</td>
                    <td>${address.city}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</section>



</body>
</html>