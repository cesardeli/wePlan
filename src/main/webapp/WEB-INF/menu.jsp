<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="Dropdown1" class="dropdown-content">
    <li style="height: 64px;"><a style="height: 64px;" href=""> Paramètres</a></li>
    <li style="height: 64px;"><a style="height: 64px;" href=""> Deconnexion</a></li>
</ul>

<nav>
    <div class="nav-wrapper red">
        <ul id="nav-mobile" class="right">
            <li>
                <a href="ajouter"> Ajouter</a>
            </li>
            <li>
                <a href="evenements"> Liste</a>
            </li>
            <li>
                <a class="dropdown-button" href="#!" data-activates="Dropdown1">
                    <i class="material-icons">arrow_drop_down</i>
                </a>
            </li>
        </ul>
    </div>
</nav>