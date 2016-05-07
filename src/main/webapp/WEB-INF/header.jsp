<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8"/>
    <title>We Plan</title>


    <!--Import JQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import fullcalendar.css-->
    <link rel='stylesheet' href='CSS/fullcalendar.css'/>
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="CSS/materialize.css"/>
    <link type="text/css" rel="stylesheet" href="CSS/surcouche.css"/>


    <!--Import JS-->
    <script src='js/moment.min.js'></script>
    <script src='js/jquery.min.js'></script>
    <script src='js/fullcalendar.js'></script>
    <script src='js/materialize.js'></script>
    <script type="text/javascript" src="js/qtip-1.0.0.min.js"></script>
    <script src='js/lang-all.js'></script>


    <script>
        $(document).ready(function () {


            $(".dropdown-button").dropdown();

            //Paramètres du Modal
            $('.modal-trigger').leanModal({
                dismissible: true, // Modal can be dismissed by clicking outside of the modal
                opacity: .5, // Opacity of modal background
                in_duration: 300, // Transition in duration
                out_duration: 200 // Transition out duration

            });


            $('#calendar').fullCalendar({
                height: '350',
                default: false,
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
                        //url:'http://google.com',
                    },
                    </c:forEach>
                ],

                //Ouverture modal après clic
                eventClick: function (event) {
                    console.log("eventClick: function (event)"),
                            $('#modalTitle').html(event.title);
                    $('#modalBody').html('Lieu : ' + event.lieu + '<br/><br/> Description : ' + event.description);
                    $('#eventUrl').attr('href', event.url);
                    $('#modal1').openModal();
                },

                //Ajouter lieu sur l'événement
                eventRender: function (event, element, view) {
                    element.find('.fc-title').append("<br/>" + event.lieu);
                }
            });
        });
    </script>


    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="shortcut icon" href="IMG/favicon.ico" type="image/x-icon">
    <link rel="icon" href="IMG/favicon.ico" type="image/x-icon">

</head>

<div class="card small header">
    <div class="card-image">
        <img class="responsive-img" src="IMG/ban_cesar_flou.jpg">

        <div class="card-title">
            <h1>We Plan</h1>
            <h5>Toute la vie associative de HEI</h5>

        </div>
    </div>
</div>