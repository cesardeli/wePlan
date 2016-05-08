<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 07/05/16
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@include file="menu.jsp" %>


<div class="container">


    <div class="row">
        <div class="col s12 l6">
            <div class="card white ">
                <div class="card-content">
                    <span class="card-title">Responsable planification</span>
                    <ul class="collection">
                        <c:forEach var="planifications" items="${planifications}" varStatus="pStatus">
                            <li class="collection-item">${planifications.utilisateur_mail}
                                <a href="modifierdroit?id=${planifications.utilisateur_mail}"><i
                                        class="material-icons right red-text">delete</i></a></li>
                        </c:forEach>

                    </ul>
                </div>
                <div class="card-action">
                    <div class="row">
                        <form method="post" action="ajouterplanification">

                            <div class="input-field col s8 ">

                                <input id="email" type="email" class="validate" name="mailPlanification">
                                <label for="email">Email</label>
                            </div>
                            <button class="btn waves-effect waves-light col s4 " type="submit" name="action">Ajouter
                                <i class="material-icons right">add</i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="col s12 l6">
            <div class="card white ">
                <div class="card-content">
                    <span class="card-title">Responsable commission</span>
                    <ul class="collection">
                        <c:forEach var="commissions" items="${commissions}" varStatus="pStatus">
                            <li class="collection-item">${commissions.utilisateur_mail}
                                <a href="#" data-mail="${commissions.utilisateur_mail}"><i
                                        class="material-icons right red-text">delete</i></a></li>
                        </c:forEach>

                    </ul>
                </div>
                <div class="card-action">
                    <div class="row">

                        <form method="post" action="ajoutercommission">

                            <div class="input-field col s8 ">

                                <input id="email" type="email" class="validate" name="mailCommission">
                                <label for="email">Email</label>
                            </div>
                            <button class="btn waves-effect waves-light col s4 " type="submit" name="action">Ajouter
                                <i class="material-icons right">add</i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<%=session.getId()%>


<!-- Modal Structure -->
<div id="modalSupprimerDroit" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4>Suppression droits</h4>

        <p id="modalBody" class="modal-body"></p>
    </div>
    <div class="modal-footer">
        <a id="eventUrl"
           class="modal-action modal-close waves-effect waves-green btn-flat ">Agree</a>
    </div>
    <!-- FIN : Modal Structure -->
</div>

<%@ include file="footer.jsp" %>

<script>
    $(document).ready(function () {


        <!-- Modal ouverture -->
        $("[data-mail]").click(function () {
            var mail = $(this).data("mail");
            $('#modalBody').html('Voulez vous vraiment supprimer les droits de : ' + mail + '?');
            $('#eventUrl').attr('href', href = "modifierdroit?id=" + mail);
            $('#modalSupprimerDroit').openModal();
        });


        $('.modal-trigger').leanModal({
                    dismissible: true, // Modal can be dismissed by clicking outside of the modal
                    opacity: .5, // Opacity of modal background
                    in_duration: 300, // Transition in duration
                    out_duration: 200, // Transition out duration
                }
        );
    });
</script>

</body>
</html>
