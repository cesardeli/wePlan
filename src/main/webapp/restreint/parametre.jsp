<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 09/05/16
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="../WEB-INF/header.jsp" %>

<body class="grey lighten-4">

<%@include file="menu.jsp" %>


<div class="container">

    <div class="row">
        <div class="col s12 l6 offset-l3">
            <div class="card-panel white">

                <form method="post" name="modifiermdp" action="modifiermdp">
                    <h3 class="center blue-text flow-text" style="font-weight: 300;">
                        Modifier le mot de passe
                    </h3>


                    <input type="hidden" name="utilisateur_mail"
                           value="${sessionScope.sessionUtilisateur.utilisateur_mail}">

                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" name="utilisateur_ancien_mdp">
                            <label for="password">Ancien mot de passe</label>
                        </div>
                    </div>
                    <span class="erreur">${form.erreurs['utilisateur_ancien_mdp']}</span>


                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" name="utilisateur_nouveau_mdp">
                            <label for="password">Nouveau mot de passe</label>
                        </div>
                    </div>
                    <span class="erreur">${form.erreurs['utilisateur_nouveau_mdp']}</span>


                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" name="utilisateur_confirmation_mdp">
                            <label for="password">Confirmation mot de pass</label>
                        </div>
                    </div>
                    <span class="erreur">${form.erreurs['utilisateur_confirmation_mdp']}</span>

                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

                    <div class="row">
                        <button class="waves-effect waves-light btn col offset-m4 s12 m4 " type="submit"
                                value="Modifier"
                                name="bouton">Modfier
                        </button>
                    </div>
                    <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>

                </form>
            </div>
        </div>
    </div>


</div>

<%@ include file="../WEB-INF/footer.jsp" %>

<script src='js/fullcalendar.js'></script>
<script type="text/javascript" src="js/qtip-1.0.0.min.js"></script>
<script src='js/lang-all.js'></script>

</body>
</html>
