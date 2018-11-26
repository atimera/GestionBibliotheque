<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation - Saisie Adresse</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

    <h2>Adresse saisie</h2>

    Adresse : ${address.address}
    <br>
    Adresse 2: ${address.address2}
    <br>
    Code postal: ${address.postalCode}
    <br>
    Ville: ${address.city}

</body>
</html>