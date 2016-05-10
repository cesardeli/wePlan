<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="msg" value="${sessionScope.sessionUtilisateur.utilisateur_mail}"/>
<c:set var="point" value="${fn:split(msg,'.')}"/>
<c:set var="prenom" value="${point[0]}"/>
<c:set var="reste" value="${point[1]}"/>
<c:set var="test" value="${fn:split(reste,'@')}"/>
<c:set var="nom" value="${test[0]}"/>

<c:set var="utilisateur_type" value="${sessionScope.sessionUtilisateur.utilisateur_type}"/>
<c:set var="responsable" value="${1}"/>


<ul id="Dropdown1" class="dropdown-content">
    <li style="height: 64px;"><a style="height: 64px; line-height: 64px; padding-top: 0px"
                                 href="#!">${sessionScope.sessionUtilisateur.utilisateur_mail}</a></li>
    <li style="height: 64px;"><a style="height: 64px; line-height: 64px; padding-top: 0px"
                                 href="/dashboard">Dashboard</a></li>
    <li style="height: 64px;"><a style="height: 64px; line-height: 64px; padding-top: 0px"
                                 href="/parametre">Paramètres</a></li>
    <li style="height: 64px;"><a style="height: 64px; line-height: 64px; padding-top: 0px" href="/deconnexion">Deconnexion</a>
    </li>
</ul>


<nav>
    <div class="nav-wrapper red">
        <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">


            <li>
                <a href="calendrier">Calendrier</a>
            </li>
            <c:choose>
                <c:when test="${utilisateur_type >= 1}">
                    <li>
                        <a href="ajouter"> Ajouter</a>
                    </li>

                    <li>
                        <a href="evenements"> Liste</a>
                    </li>
                </c:when>

            </c:choose>
            <li>
                <a class="dropdown-button" href="#!" data-activates="Dropdown1">
                    ${sessionScope.sessionUtilisateur.utilisateur_mail}<i
                        class="material-icons right">arrow_drop_down</i>
                </a>
            </li>
        </ul>
        <ul class="side-nav" id="mobile-demo">
            <li><a href="calendrier">Calendrier</a></li>
            <c:choose>
                <c:when test="${utilisateur_type >= 1}">

                    <li><a href="ajouter"> Ajouter</a></li>
                    <li><a href="evenements"> Liste</a></li>
                    <li><a href="/dashboard"> Dashboard</a></li>

                </c:when>
            </c:choose>
            <li><a href="/parametre"> Paramètres</a></li>
            <li><a href="/deconnexion"> Deconnexion</a></li>
        </ul>
    </div>
</nav>

<script>
    $(document).ready(function () {

        $(".button-collapse").sideNav();
    });
</script>