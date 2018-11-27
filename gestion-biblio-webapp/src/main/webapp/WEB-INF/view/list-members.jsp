<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Members</title>
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
    <h3>Liste des clients</h3>
    <div class="content">
        <table>
            <tr>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Email</th>
            </tr>

            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.firstName}</td>
                    <td>${member.lastName}</td>
                    <td>${member.email}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</section>


</body>
</html>