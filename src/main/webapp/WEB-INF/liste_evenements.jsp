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


    <c:forEach var="evenements" items="${evenements}">


        <div class="card-panel white">


            <div class="row">

                <div class="col">
                    <a class="btn-floating green" onclick=""><i class="material-icons">mode_edit</i></a>
                </div>
                <form method="get" action="supprimer">
                    <div class="col">
                        <input type="hidden" name="ID" value="${evenements.evenement_id}">
                        <button class="btn-floating red" type="submit"
                                name="delete_event">
                            <i class="material-icons">delete</i>
                        </button>
                    </div>
                </form>
            </div>

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
    </c:forEach>


</div>


<%@ include file="footer.jsp" %>

</body>

</html>