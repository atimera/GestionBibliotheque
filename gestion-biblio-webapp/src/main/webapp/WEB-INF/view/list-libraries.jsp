<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bibibliothèques</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <header>Liste des Bibliothèques</header>
    </div>
</div>

<section id="container">
    <div id="content">

        <c:forEach var="library" items="${libraries}">

            <p>
            Nom : ${library.name}
            <br>
            Adresse : ${library.address.address} ${library.address.postalCode} ${library.address.city}
            </p>
        </c:forEach>

<%--
        <table>
            <tr>
                <th>Adresse</th>
                <th>Code Postal</th>
                <th>Ville</th>
            </tr>


            <c:forEach var="address" items="${}" >
                <tr>
                    <td>${address.address} <br> ${address.address2}</td>
                    <td>${address.postalCode}</td>
                    <td>${address.city}</td>
                </tr>
            </c:forEach>

        </table>
        --%>
    </div>
</section>



</body>
</html>