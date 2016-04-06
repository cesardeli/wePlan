<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@ include file="menu.jsp" %>

<div class="container">

    <div class="card-panel white">
        <div class="card">

            <div class="card-content">
                <span class="card-title activator grey-text text-darken-4">Inscription<i class="material-icons right">more_vert</i></span>
                <div class="row">
                    <form class="col s12">
                         <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="email" class="validate">
                                <label for="email">Email</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" class="validate">
                                <label for="password">Password</label>
                            </div>
                        </div>

                    </form>
                </div>
                <a class="waves-effect waves-light btn">Valider les informations</a>

            </div>
            <div class="card-reveal">
                <span class="card-title grey-text text-darken-4">Connexion<i class="material-icons right">close</i></span>


                <p>Déjà un compte? Connectez-vous</p>
            </div>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>

</body>

</html>
