<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>


<body class="grey lighten-4">

<%@include file="menu.jsp" %>


<div class="container">

    <div class="card-panel grey lighten-4" style="box-shadow: none; margin-bottom: 0;">
        <div class="row">
            <h2 class="blue-text col offset-m1" style="font-weight: 300; margin: 0;">
                Bonjour Pierre,
            </h2>
        </div>

        <div class="row">
            <p class="flow-text col offset-m1" style="margin: 0;">
                Voici le programme des événements
            </p>
        </div>
    </div>


    <c:forEach var="evenements" items="${evenements}" varStatus="pStatus">
    <form:input path="evenements[${pStatus.index}].evenement_id"/>
    <form:input path="evenements[${pStatus.index}].evenement_nom"/>


    <div class="card-panel white">


        <div class="row">

            <div class="col">
                <a href="modifier?id=${evenements.evenement_id}" class="btn-floating green modal-trigger"><i
                        class="material-icons">mode_edit</i></a>
            </div>


            <div class="col">
                <button type="button" class="modal-trigger btn-floating red" data-target="modalSupprimer"
                        data-dismiss="modal" data-id="${evenements.evenement_id}"
                        name="delete_event">
                    <i class="material-icons">delete</i>
                </button>
            </div>


                <%--<form method="get" action="supprimer">
                    <input "type="hidden" name="ID" value="${evenements.evenement_id}">

                    <div class="col">
                        <button type="button" class="modal-trigger btn-floating red" data-target="modalSupprimer" data-dismiss="modal" data-id="${evenements.evenement_id}"
                                name="delete_event">
                            <i class="material-icons">delete</i>
                        </button>
                    </div>
                </form>--%>
        </div>


        <!-- -----------TEST------------- -->

        <p>Sans modal pour confirmer :</p>
        <a href="supprimer?id=${evenements.evenement_id}">Supprimer</a>


        <!-- ---------FIN TEST------------ -->


        <p>
            ID : ${evenements.evenement_id},
        </p>

        <p>
            Nom : ${evenements.evenement_nom},
        </p>

        <p>
            Date début: ${evenements.evenement_date_debut},
            Heure début : ${evenements.evenement_heure_debut} ,
        </p>

        <p>
            Date fin : ${evenements.evenement_date_fin },
            Heure fin : ${evenements.evenement_heure_fin },
        </p>

        <c:if test="${not evenement.evenement_prive}">Evenement prive Lieu : ${evenements.evenement_lieu }</c:if>


        <p>
            Lieu : ${evenements.evenement_lieu }

        <p>

        <p>
            Description: ${evenements.evenement_description}
        </p>


    </div>

    <!-- Modal Structure -->
    <div id="modalSupprimer" class="modal modal-fixed-footer">
        <input type="hidden" name="evenementId"/>

        <div class="modal-content">
            <h4 class="modal-title">Supprimer</h4>

            <p>Voulez vous vraiment supprimer l'événement : ${evenements.evenement_nom}</p>
        </div>


        < class="modal-footer">

        <a href="supprimer?id=${evenements.evenement_id}"
           class="modal-action modal-close waves-effect waves-green btn-flat ">Oui</a>
        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat ">TEST</a>

        <form method="get" action="supprimer">
            <input "type="hidden" name="ID" value="${evenements.evenement_id}">


            <a href="supprimer?id="
            class="modal-action modal-close waves-effect waves-green btn-flat ">Supprimer</a>

            <a  type="button" class="modal-trigger btn-floating red" data-target="modalSupprimer"
                    data-dismiss="modal" data-id="${evenements.evenement_id}"
                    name="delete_event">
                <i class="material-icons">delete</i>
            </a>

        </form>


    </div>


</div>
</c:forEach>


</div>


<%@ include file="footer.jsp" %>

</body>

</html>