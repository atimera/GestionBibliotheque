<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>Gestion Biblio</title>
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

<hr>

<div class="container">
    <div class="content">
        <ul>
            <security:authorize access="hasAnyRole('ADMIN', 'MANAGER')" >
                <li><a href="${pageContext.request.contextPath}/showAdmins">Accès administrateurs</a></li>
            </security:authorize>

            <security:authorize access="hasAnyRole('ADMIN')">
                <li><a href="${pageContext.request.contextPath}/showLeaders">Accès leaders</a></li>
            </security:authorize>

            <security:authorize access="hasAnyRole('EMPLOYEE', 'USER')" >
                <li><a href="${pageContext.request.contextPath}/showEmployees">Accès employés</a></li>
            </security:authorize>
        </ul>
    </div>
    <div>
        <%-- display the name and the role --%>
        <p>
            Utilisateur :
            <security:authentication property="principal.username" />
            <br><br>
            Role(s) :
            <security:authentication property="principal.authorities" />
        </p>
    </div>
    <%-- Add a logout Button--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post" >
        <input type="submit" value="Se déconnecter" />
    </form:form>
</div>
</body>
</html>
