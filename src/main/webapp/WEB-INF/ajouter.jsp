<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">

<%@ include file="header.jsp" %>

<body class="grey lighten-4">

<%@ include file="menu.jsp" %>

<div class="container">

    <div class="card-panel white">

        <h2 class="center blue-text" style="font-weight: 300;">
            Ajouter un événement
        </h2>

        <form method="post" action="ajouter">
            <div class="row">

                <!-- ************ Informations générales *********   -->

                <span class="flow-text col offset-m2">Informations générales</span>

                <div class="input-field col offset-m2 s12 m8">
                    <input id="titre" type="text" name="evenement_nom" class="validate" required>
                    <label for="titre">Titre de l'événement</label>
                </div>
            </div>


            <div class="row">
                <div class="input-field col offset-m2 s8 m6">
                    <input id="lieu" type="text" name="evenement_lieu" class="validate" required>
                    <label for="lieu">Lieu</label>
                </div>

                <div class="input-field col s4 m2">
                    <input type="checkbox" id="prive" value="on" name="evenement_prive" checked="checked"/>
                    <label for="prive">Lieu privé</label>
                </div>
            </div>


            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                            <textarea id="description" class="materialize-textarea" name="evenement_description"
                                      length="120"></textarea>
                    <label for="description">Description</label>
                </div>
            </div>


            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <div class="file-field input-field">
                        <div class="btn blue">
                            <span>Fichier</span>
                            <input type="file">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text" placeholder="Déclaration de l'événement">
                        </div>
                    </div>
                </div>
                <div class="col s12 m8 offset-m2">
                            <span class="red-text">
                                <i class="material-icons tiny">warning</i> La declaration d'événement a bien été envoyé à
                                l'adresse vie.associative@hei.fr?
                            </span>
                </div>
            </div>


            <!-- ************ Début *********   -->

            <div class="row">
                <span style="margin-top: 20px;" class="flow-text col offset-m2">Début</span>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <label for="debut">Date de début</label>
                    <input type="date" id="debut" name="evenement_date_debut" class="datepicker"/>
                </div>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s6 m4">
                    <select>
                        <option style=" text-align: right;" value="" disabled selected>Heure de début</option>
                        <option style="text-align: right;" value="1">08 heures</option>
                        <option value="2">09 heures</option>
                        <option value="3">10 heures</option>
                        <option value="4">11 heures</option>
                        <option value="2">12 heures</option>
                        <option value="2">13 heures</option>
                        <option value="2">14 heures</option>
                        <option value="2">15 heures</option>
                        <option value="2">16 heures</option>
                        <option value="2">17 heures</option>
                        <option value="2">18 heures</option>
                        <option value="2">19 heures</option>
                        <option value="2">20 heures</option>
                        <option value="2">21 heures</option>
                        <option value="2">22 heures</option>
                    </select>
                </div>


                <div class="input-field col s6 m4">
                    <select>
                        <option value="" disabled selected>Minute</option>
                        <option value="0">00 minute</option>
                        <option value="2">15 minutes</option>
                        <option value="2">30 minutes</option>
                        <option value="2">45 minutes</option>

                    </select>
                </div>
            </div>


            <!-- ************ Fin *********   -->


            <div class="row">
                <span class="flow-text col offset-m2">Fin</span>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <label for="eventDate">Date</label>
                    <input type="text" id="eventDate" class="datepicker"/>
                </div>
            </div>

            <div class="row">

                <div class="input-field col offset-m2 s6 m4">
                    <select>
                        <option value="" disabled selected>Heure</option>
                        <option value="8">08 heures</option>
                        <option value="9">09 heures</option>
                        <option value="10">10 heures</option>
                        <option value="11">11 heures</option>
                        <option value="12">12 heures</option>
                        <option value="13">13 heures</option>
                        <option value="14">14 heures</option>
                        <option value="15">15 heures</option>
                        <option value="16">16 heures</option>
                        <option value="17">17 heures</option>
                        <option value="18">18 heures</option>
                        <option value="19">19 heures</option>
                        <option value="20">20 heures</option>
                        <option value="21">21 heures</option>
                        <option value="22">22 heures</option>
                    </select>
                    <label>Fin</label>
                </div>
                <div class="input-field col s6 m4">
                    <select>
                        <option value="" disabled selected>Minute</option>
                        <option value="0">00</option>
                        <option value="2">15</option>
                        <option value="2">30</option>
                        <option value="2">45</option>

                    </select>
                </div>
            </div>


            <!-- ************ Boutons *********   -->

            <div class="row">
                <div class="col offset-m3 s6 m3">
                    <button class="green btn waves-effect waves-light" type="submit"
                            name="action">Enregistrer
                        <i class="material-icons right">save</i>
                    </button>
                </div>


                <div class="col s6 m3">
                    <a class="btn red waves-effect waves-light" href=javascript:history.go(-1)>Annuler
                    <i class="material-icons right">cancel</i>
                    </a>
                </div>
            </div>
        </form>

    </div>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>