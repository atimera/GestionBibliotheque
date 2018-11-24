<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adresse - Liste</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <header>Liste des Adresses</header>
    </div>
</div>

${addresses}

<section id="container">
    <div id="content">
        <table>
            <tr>
                <th>Adresse</th>
                <th>Code Postal</th>
                <th>Ville</th>
            </tr>


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