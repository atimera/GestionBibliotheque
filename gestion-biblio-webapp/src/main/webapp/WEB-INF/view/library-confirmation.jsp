<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation - Saisie Bibliothèque</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<h2>Bibliothèque</h2>

Nom : ${library.name}
<br>
Addresse : ${library.address.address} ${library.address.address2} ${library.address.postalCode} ${library.address.city}


</body>
</html>