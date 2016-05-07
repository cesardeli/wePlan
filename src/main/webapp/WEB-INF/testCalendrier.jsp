<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 03/05/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@include file="menu.jsp" %>


<div class="container">


    <div class="card-panel white">

        <div id='loading'></div>

        <div id='calendar'></div>


    </div>


    <!-- Modal Structure -->
    <div id="modal1" class="modal modal-fixed-footer">
        <div class="modal-content">
            <h4 id="modalTitle" class="modalTitle"></h4>

            <p id="modalBody" class="modal-body"></p>
        </div>
        <div class="modal-footer">
            <div class="row">
                <div class="col offset-m3 s6 m3">
                    <a class="blue btn waves-effect waves-light" id="eventUrl" target="_blank">Page événement</a>
                </div>
                <div class="col s6 m3">
                    <a href="#!" class="red btn waves-effect waves-light">Fermer</a>
                </div>
            </div>
        </div>
    </div>


    <%@ include file="footer.jsp" %>

</body>
</html>
