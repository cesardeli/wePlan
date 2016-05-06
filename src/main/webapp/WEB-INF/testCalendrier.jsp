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

</div>
<div id="fullCalModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span> <span
                        class="sr-only">close</span></button>
                <h4 id="modalTitle" class="modal-title"></h4>
            </div>
            <div id="modalBody" class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                <a class="btn btn-primary" id="eventUrl" target="_blank">Page événement</a>
            </div>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>

</body>
</html>
