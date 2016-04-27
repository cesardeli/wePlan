<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@ include file="menu.jsp" %>

<div class="container">

    <div class="card">

        <div class="card-content">
            <span class="card-title activator grey-text text-darken-4">Vous n'avez pas encore de compte? Cliquez ici pour vous inscrire!<i
                    class="material-icons right">more_vert</i></span>

            <div class="row">
                <form class="col s12">
                    <h3 class="center blue-text" style="font-weight: 300;">
                        Connexion
                    </h3>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="email" type="email" class="validate">
                            <label for="email">Adresse email @hei.fr</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="password" type="password" class="validate">
                            <label for="password">Mot de passe</label>
                        </div>
                    </div>
                    <a class="waves-effect waves-light btn">Connexion</a>

                </form>
            </div>

        </div>
        <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">Rentrez vos informations pour nous rejoindre <i
                    class="material-icons right">close</i></span>

            <div class="row">
                <form class="col s12" action="inscription" method="post">
                    <h3 class="center blue-text" style="font-weight: 300;">
                        Inscription
                    </h3>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="email" type="email" class="validate" name="utilisateur_mail" value="<c:out value="${param.utilisateur_mail}"/>">
                            <label for="email"> Adresse mail @hei.fr <span class="requis">*</span></label>
                            <span class="erreur">${erreurs['utilisateur_mail']}</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="password" type="password" class="validate" name="utilisateur_mdp" value="">
                            <label for="password">Mot de passe <span class="requis">*</span></label>
                            <span class="erreur">${erreurs['utilisateur_mdp']}</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="password" type="password" class="validate" name="confirmation" value="">
                            <label for="password">Confirmation  <span class="requis">*</span></label>
                            <span class="erreur">${erreurs['confirmation']}</span>
                        </div>
                    </div>
                    <button class="row waves-effect waves-light btn" type="submit" value="inscription" name="inscription">Incription
                    </button>

                    <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>

                </form>

            </div>


        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>

</body>

</html>
