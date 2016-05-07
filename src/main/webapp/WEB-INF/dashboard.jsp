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
                                <a href="modifierdroit?id=${commissions.utilisateur_mail}"><i
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

<%@ include file="footer.jsp" %>

</body>
</html>
