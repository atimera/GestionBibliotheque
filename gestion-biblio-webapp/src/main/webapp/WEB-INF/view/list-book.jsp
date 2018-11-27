<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livres</title>
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

    <h2>Liste des livres</h2>

    <div class="content">
        <table>
            <tr>
                <th>Id</th>
                <th>Titre</th>
                <th>Date de publication</th>
                <th>Action à Faire</th>
            </tr>

            <%-- redirect to Adding Address form --%>
            <input type="button" value="Ajouter"
                   onclick="window.location.href='showBookFormAdd'; return false;"
                   class="add-button" />

            <c:forEach var="book" items="${books}" >
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.dateOfPublication}</td>
                    <td>
                        <input type="button"
                               value="Ajouter un exemplaire"
                               onclick="window.location.href='addBookCopyForm'; return; "/>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</section>



</body>
</html>