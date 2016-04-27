//$(document).ready(function () {




    $('.datepicker').pickadate({
        selectMonths: true,//Creates a dropdown to control month
        selectYears: 2,//Creates a dropdown of 15 years to control year
//The title label to use for the month nav buttons
        labelMonthNext: 'Próximo Mês',
        labelMonthPrev: 'Mês Anterior',
//The title label to use for the dropdown selectors
        labelMonthSelect: 'Selecione o Mês',
        labelYearSelect: 'Selecione o ano',
//Months and weekdays
        monthsFull: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
        monthsShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
        weekdaysFull: [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
        weekdaysShort: [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
//Materialize modified
        weekdaysLetter: [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
//Today and clear
        today: 'Hoje',
        clear: 'Limpar',
        close: 'Fechar',
//The format to show on the `input` element
        format: 'd mmmm yyyy'
    });
//Copy settings and initialization tooltipped
    $(document).ready(function(){

        new Clipboard('.copy-text');

        $('.tooltipped').tooltip({delay: 50});

    });




//});


$(document).ready(function () {
    $('select').material_select();

});

$(document).ready(function () {
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal({
        dismissible: true, // Modal can be dismissed by clicking outside of the modal
        opacity: .5, // Opacity of modal background
        in_duration: 300, // Transition in duration
        out_duration: 200, // Transition out duration
        /!* ready: function () {
         alert('Ready');
         }, // Callback for Modal open
         complete: function () {
         alert('Closed');
         } // Callback for Modal close*!/
    })

    $(".announce").click(function(){ // Click to only happen on announce links
        $("#evenementId").val($(this).data('id'));
        $('#modalSupprimer').modal('show');
    });


});

$('#modalSupprimer').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
});

