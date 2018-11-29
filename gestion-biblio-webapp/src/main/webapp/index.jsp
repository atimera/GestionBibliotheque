<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Gestion Biblio</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<h2>Gestion Biblio</h2>
<hr>
<h3>Liens API REST</h3>
<hr>
<ul>
    <li><a href="${pageContext.request.contextPath}/test/hello">Hello world</a></li>
    <li><a href="${pageContext.request.contextPath}/api/members">Liste des membres</a></li>
    <li><a href="${pageContext.request.contextPath}/api/members/0">Premier membre de la list</a></li>
</ul>

<%--
<h3>Liens Application</h3>
<ul>
    <li><a href="address/showFormForAdd">Formulaire de saisie d'adresse</a></li>
    <li><a href="address/list">Liste des adresses</a></li>
    <li><a href="member/showForm">Formulaire d'un client</a></li>
    <li><a href="member/list">Liste des clients</a></li>
    <li><a href="library/showForm">Formulaire de saisie d'un bibliothèque</a></li>
    <li><a href="library/list">Liste des des bibliothèque</a></li>
    <li><a href="book/showBookForm">Ajouter un livre</a></li>
    <li><a href="book/list">Liste des livres</a></li>
    <li><a href="book/showBookCopyForm">Ajouter un exemplaire</a></li>
    <li><a href="book/copies">Liste des exemplaire</a></li>
</ul>
--%>


</body>
</html>
