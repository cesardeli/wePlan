<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@ include file="menu.jsp" %>

<div class="container">

    <div class="card">
        <%=session.getId()%>


        <div class="card-content">
            <span class="card-title activator grey-text text-darken-4 flow-text">Vous n'avez pas encore de compte? Cliquez ici pour vous inscrire!<i
                    class="material-icons right">more_vert</i></span>

            <div class="row">
                <form class="col s12" method="post" name="connexion">
                    <h3 class="center blue-text flow-text" style="font-weight: 300;">
                        Connexion
                    </h3>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="email" type="email" class="validate" name="utilisateur_mail_connexion">
                            <label for="email">Adresse email @hei.fr</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="password" type="password" class="validate" name="utilisateur_mdp">
                            <label for="password">Mot de passe</label>
                        </div>
                    </div>

                    <div class="row">
                        <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2" type="submit" value="connexion"
                                name="bouton">Connexion
                        </button>
                    </div>
                    <%-- &lt;%&ndash; <c:if test="${!empty sessionScope.sessionUtilisateur}">
                          &lt;%&ndash; Si l'utilisateur existe en session, alors on affiche son adresse email. &ndash;%&gt;
                          <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.utilisateur_mail}</p>
                      </c:if&ndash;%&gt;>
  --%>

                </form>
            </div>

        </div>
        <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">Rentrez vos informations pour nous rejoindre <i
                    class="material-icons right">close</i></span>

            <div class="row">
                <form class="col s12" method="post" name="inscription">
                    <h3 class="center blue-text" style="font-weight: 300;">
                        Inscription
                    </h3>

                    <div class="row">
                        <div class="input-field col offset-m2 s12 m8">
                            <input id="email" type="email" class="validate" name="utilisateur_mail_inscription"/>
                            <label for="email"> Adresse mail @hei.fr <span class="requis">*</span></label>

                        </div>
                    </div>


                    <div class="row">
                        <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2" type="submit" value="inscription"
                                name="bouton">Incription
                        </button>
                    </div>


                </form>

            </div>


        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>

</body>

</html>
