<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 03/05/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="../WEB-INF/header.jsp" %>

<body class="grey lighten-4">

<%@include file="menu.jsp" %>


<div class="container">


    <div class="card-panel grey lighten-4" style="box-shadow: none; margin-bottom: 0;">
        <div class="row">
            <c:set var="mail" value="${sessionScope.sessionUtilisateur.utilisateur_mail}"/>
            <c:set var="prenom" value="${fn:split(msg,'.')}"/>
            <h2 class="blue-text col offset-m1" style="font-weight: 300; margin: 0; ">
                Bonjour
            </h2>
            <h2 class="blue-text col offset-m1 maj" style="font-weight: 300; margin: 0; ">
                ${prenom[0]},
            </h2>
        </div>

        <div class="row">
            <p class="flow-text col offset-m1" style="margin: 0;">
                Voici le programme des événements
            </p>
        </div>
    </div>


    <div class="card-panel white">


        <div id='calendar'></div>


    </div>


    <!-- Modal Structure -->
    <div id="modal1" class="modal modal-fixed-footer">
        <div class="modal-content">
            <h4 id="modalTitle" class="modalTitle"></h4>

            <p id="modalBody" class="modal-body"></p>
        </div>
        <div class="modal-footer">
            <a href="#!" class="modal-action modal-close red btn waves-effect waves-light">Fermer</a>
            <a class="blue btn waves-effect waves-light" id="eventUrl" target="_blank">Page événement</a>


        </div>
    </div>
</div>


<%@ include file="../WEB-INF/footer.jsp" %>

<script src='js/fullcalendar.js'></script>
<script type="text/javascript" src="js/qtip-1.0.0.min.js"></script>
<script src='js/lang-all.js'></script>


<script>
    $(document).ready(function () {


        //Paramètres du Modal
        $('.modal-trigger').leanModal({
            dismissible: true, // Modal can be dismissed by clicking outside of the modal
            opacity: .5, // Opacity of modal background
            in_duration: 300, // Transition in duration
            out_duration: 200 // Transition out duration

        });


        $('#calendar').fullCalendar({
            height: '350',
            minTime: "07:30:00",
            editable: false,
            lang: 'fr',
            defaultView: 'agendaWeek',
            color: 'grey lighten-4',     // an option!

            //Mise en forme du header
            header: {
                prev: 'circle-triangle-w',
                next: 'circle-triangle-e',
                left: 'prev,next today',
                center: 'title',
                right: 'agendaWeek,agendaDay',
            },

            //Déclaration de la liste d'événements
            events: [
                <c:forEach var="evenements" items="${evenements}" varStatus="pStatus">
                {
                    title: '${evenements.evenement_nom}',
                    start: '${evenements.evenement_date_debut}T${evenements.evenement_heure_debut}Z',
                    end: '${evenements.evenement_date_fin}T${evenements.evenement_heure_fin}Z',
                    <c:choose>
                    <c:when test="${evenements.evenement_prive}">
                    lieu: 'privé',
                    </c:when>
                    <c:otherwise>
                    lieu: '${evenements.evenement_lieu}',
                    </c:otherwise>
                    </c:choose>
                    description: '${evenements.evenement_description}',

                    link: '${evenements.evenement_link}'


                },
                </c:forEach>
            ],

            //Ouverture modal après clic
            eventClick: function (event) {
                console.log("eventClick: function (event)"),
                        $('#modalTitle').html(event.title);
                $('#modalBody').html('Lieu : ' + event.lieu + '<br/><br/> Description : ' + event.description);
                if (event.link && event.link != null) {
                    $('#eventUrl').attr('href', event.link);
                    console.log('non null');
                }
                else {
                    $('#eventUrl').attr('style', 'display:none');
                    console.log('null')
                }
                $('#modal1').openModal();
            },

            //Ajouter lieu sur l'événement
            eventRender: function (event, element, view) {
                element.find('.fc-title').append("<br/>" + event.lieu);
            }
        });
    });
</script>


</body>
</html>
