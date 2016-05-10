<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="../WEB-INF/header.jsp" %>

<body class="grey lighten-4">

<%@ include file="menu.jsp" %>

<div class="container">

    <div class="card-panel white">
        <p>Un email de confirmation vous a été envoyé, il contient votre mot de passe.</p>

        <div class="row">
            <a href="/">
                <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2">Connexion!</button>
            </a>
        </div>
    </div>

</div>

<%@ include file="../WEB-INF/footer.jsp" %>

</body>


</html>
