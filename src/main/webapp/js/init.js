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

        /*       //Déclaration de la liste d'événements
         events: [
         < c
         :
         forEach
         var =
         "evenements"
         items = "${evenements}"
         varStatus = "pStatus" >
         {
         title: '${evenements.evenement_nom}',
         start: '${evenements.evenement_date_debut}T${evenements.evenement_heure_debut}Z',
         end: '${evenements.evenement_date_fin}T${evenements.evenement_heure_fin}Z',
         < c
         :
         choose >
         < c
         :
         when
         test = "${evenements.evenement_prive}" >
         lieu
         :
         'privé',
         </
         c:when >
         < c
         :
         otherwise >
         lieu
         :
         '${evenements.evenement_lieu}',
         </
         c:otherwise >
         < / c
         :
         choose >
         description
         :
         '${evenements.evenement_description}',
         //url:'http://google.com',
         },
         < / c
         :
         forEach >
         ],*/

//Ouverture modal après clic
        eventClick: function (event) {
            console.log("eventClick: function (event)"),
                $('#modalTitle').html(event.title);
            $('#modalBody').html('Lieu : ' + event.lieu + '<br/><br/> Description : ' + event.description);
            $('#eventUrl').attr('href', event.url);
            $('#modal1').openModal();
        }

        ,

//Ajouter lieu sur l'événement
        eventRender: function (event, element, view) {
            element.find('.fc-title').append("<br/>" + event.lieu);
        }
    })
    ;
})
;


evenements.forEach(function (evenement) {
    console.log(evenement);
    {
        title: evenement.evenement_nom;
        start: evenement.evenement_date_debutTevenement.evenement_heure_debutZ;
        end: evenement.evenement_date_finTevenement.evenement_heure_finZ;
    }
});