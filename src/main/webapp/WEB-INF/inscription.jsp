<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>

<body class="grey lighten-4">


<nav>
    <div class="nav-wrapper red">
    </div>
</nav>

<div class="container">

    <div class="card-panel white">
        <div class="row">
            <form class="col s12" method="post" name="inscription">
                <h3 class="center blue-text flow-text" style="font-weight: 300;">
                    Inscription
                </h3>


                <div class="row">
                    <div class="input-field col offset-m2 s12 m8">


                        <label for="nom">Adresse email @hei.fr <span class="requis">*</span></label>
                        <input class="validate" type="email" id="email" name="utilisateur_mail_inscription"
                               value="<c:out value="${utilisateur.utilisateur_mail}"/>"
                               size="20" maxlength="60"/>
                        <span class="erreur">${erreurs['utilisateur_mail_inscription']}</span>
                    </div>
                </div>

                <div class="row">
                    <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2" type="submit"
                            value="Inscription"
                            name="bouton">Inscription
                    </button>
                </div>

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse
                        : ${sessionScope.sessionUtilisateur.utilisateur_mail}</p>
                </c:if>
            </form>

        </div>
    </div>
    <div class="row center">
        <a class="blue-text" href="/">Déjà un compte? Connecte-toi</a>
    </div>
</div>


<%@ include file="footer.jsp" %>

</body>

</html>
