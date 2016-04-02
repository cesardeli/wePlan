<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="fr">


<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/surcouche.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <meta charset="UTF-8"/>
    <!--<link href="CSS/ajouter.css" rel="stylesheet" type="text/css" media="all" />
    <link href="CSS/header.css" rel="stylesheet" type="text/css" media="all" />
    <link href="CSS/footer.css" rel="stylesheet" type="text/css" media="all" />-->

    <title>We Plan</title>
    <link rel="shortcut icon" href="IMG/favicon.ico" type="image/x-icon">
    <link rel="icon" href="IMG/favicon.ico" type="image/x-icon">

</head>


<body class="grey lighten-4">

<div class="card small header">
    <div class="card-image">
        <img class="responsive-img" src="IMG/ban_cesar_flou.jpg">

        <div class="card-title">
            <h1>We Plan</h1>
            <h5>Toute la vie associative de HEI</h5>

        </div>
    </div>
</div>

<ul id="dropdown1" class="dropdown-content">
    <li class="divider"></li>
    <li><a href="#!">three</a></li>
    <li class="divider"></li>
    <li><a href="#!">three</a></li>
    <li class="divider"></li>
    <li><a href="#!">three</a></li>
</ul>

<nav>
    <div class="nav-wrapper red">
        <ul id="nav-mobile" class="right">
            <li>
                <a class="dropdown-button" href="#!" data-activates="dropdown1">Dropdown<i class="material-icons right">arrow_drop_down</i></a>
            </li>
            <li><a href="collapsible.html"><i class="material-icons left">power_settings_new</i> Deconnexion</a></li>
        </ul>
    </div>
</nav>

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
                    <input type="checkbox" id="prive" name="evenement_prive" checked="checked"/>
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
                    <button style="background-color: #7AAC15;" class="btn waves-effect waves-light" type="submit"
                            name="action">Enregistrer
                        <i class="material-icons right">save</i>
                    </button>
                </div>

                <%--<a href="" class="choix"><input type="submit" value="Enregistrer">
                    Enregistrer</input></a>--%>


                <div class="col s6 m3">
                    <a class="btn red waves-effect waves-light">Annuler
                        <i class="material-icons right">cancel</i>
                    </a>
                </div>
            </div>
        </form>


        <%--<ul class="menu">
            <li><a href="" class="choix"><input type="submit" value="Enregistrer"><img src="IMG/disquette.png">
                Enregistrer</input></a></li>
            <li><a href="" class="choix"><img src="IMG/annuler.png"> Annuler</a></li>
            <li><a href="" class="choix"><input type="submit" value="Supprimer"><img src="IMG/supprimer.png">
                Supprimer</a></li>
        </ul>--%>


        <!--<ul class="informations">
            <li>

                <input id="titre" type="text" name="evenement_nom" placeholder="Titre de l'�v�nement"
                       required="Veuillez ajouter un titre" required></li>
            <li>
                <input id="lieu" type="text" name="evenement_lieu" placeholder="Lieu de l'�v�nement" required>
                <input type="checkbox" name"evenement_prive" value="Priv�"> Priv�
            </li>
            <li>
                <input id="debut" type="date" name="evenement_date_debut" required="Veuillez ajouter une date"
                       required>
                <input type="time" name="evenement_heure_debut">
            </li>
            <li>
                <input id="fin" type="date" name="evenement_date_fin" required="Veuillez ajouter une date"
                       required>
                <input type="time" name="heurefin" value="Heure de fin">
            </li>

            <li>
                    <textarea rows="4" cols="50" id="description" name="evenement_description"
                              placeholder="Ajoutez une description" class="form-control"></textarea>
            </li>


            <div class="fichier">
                <input id="declaration" type="text" placeholder="D�posez votre d�claration de manifestation ICI"
                       name="fichier">
                <a class="choix"
                   href="http://images.google.fr/imgres?imgurl=https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAMOAAAAJGQ4MWIxNzdhLTZkMmUtNDRlZi05ODczLWIxZTVjMDkwMzdjNw.jpg&imgrefurl=https://fr.linkedin.com/in/cesardeligny&h=200&w=200&tbnid=w5OVHGl2nGKimM:&tbnh=90&tbnw=90&docid=j1eiEap0BQiDOM&usg=__Nxx2R-PopXyys7FwYRsgcxnVMoU=&sa=X&ved=0ahUKEwi9huPWqsXKAhXGCBoKHTkKDgMQ9QEIHjAA">
                    Selectionner un fichier
                </a>
            </div>
        </ul>-->

        </form>


    </div>

</div>


<footer style="background-color: #dd3333;" class="page-footer">
    <div class="footer-copyright">
        <div class="container">
            © 2016 Site réalisé par César DELIGNY & Constance SALLE
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
        </div>
    </div>
</footer>


<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/init.js"></script>

</body>


</html>

<%--
<html>

	<head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>





		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		&lt;%&ndash;<link href="CSS/ajouter.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/header.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/footer.css" rel="stylesheet" type="text/css" media="all" />&ndash;%&gt;

		<title>We Plan</title>
		<link rel="shortcut icon" href="IMG/favicon.ico" type="image/x-icon">
		<link rel="icon" href="IMG/favicon.ico" type="image/x-icon">

	</head>




	<body>

		<header id="ban" >

			<h1> We Plan</h1>
			<h2>Toute la vie associative de HEI</h2>

		</header>

		<a href="deconnexion.jsp" id="deconnexion"><img src="IMG/btn_deconnexion.png">Deconnexion</a>

		<div id="contenu">


			<section>
				<h1>
					Ajouter un �v�nement
				</h1>

				<h2>
					Le mail avec la declaration d'�v�nement a bien �t� envoy� a� l'adresse <a href="" id="vieasso">vie.associative@hei.fr</a>?
				</h2>

			</section>



			<article>
				<form method="post" action="ajouter">


				<ul class="menu">
					<li><a href="" class="choix"><img src="IMG/annuler.png"> Annuler</a></li>
					<li><a href="" class="choix"><input type="submit" value="Supprimer"><img src="IMG/supprimer.png"> Supprimer</a></li>				</ul>


				<ul class="informations">
					<li >

						<input id="titre" type="text" name="evenement_nom" placeholder="Titre de l'�v�nement" required="Veuillez ajouter un titre" required></li>
					<li >
						<input id="lieu" type="text" name="evenement_lieu" placeholder="Lieu de l'�v�nement" required>
						<input type="checkbox" name"evenement_prive" value="Priv�"> Priv� </li>
					<li >
						<input id="debut" type="date" name="evenement_date_debut" required="Veuillez ajouter une date" required>
						<input type="time" name="evenement_heure_debut">
					</li>
					<li >
						<input id="fin" type="date" name="evenement_date_fin" required="Veuillez ajouter une date" required>
						<input type="time" name="heurefin" value="Heure de fin">
					</li>

					<li >
						<textarea rows="4" cols="50" id="description" name="evenement_description" placeholder="Ajoutez une description" class="form-control"></textarea>
					</li>




					<div class="fichier">
						<input  id="declaration" type="text" placeholder="D�posez votre d�claration de manifestation ICI" name="fichier"  >
						<a class ="choix" href="http://images.google.fr/imgres?imgurl=https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAMOAAAAJGQ4MWIxNzdhLTZkMmUtNDRlZi05ODczLWIxZTVjMDkwMzdjNw.jpg&imgrefurl=https://fr.linkedin.com/in/cesardeligny&h=200&w=200&tbnid=w5OVHGl2nGKimM:&tbnh=90&tbnw=90&docid=j1eiEap0BQiDOM&usg=__Nxx2R-PopXyys7FwYRsgcxnVMoU=&sa=X&ved=0ahUKEwi9huPWqsXKAhXGCBoKHTkKDgMQ9QEIHjAA">
							Selectionner un fichier
						</a>
					</div>
				 </ul>

				 </form>


			</article>




		</div>

		<footer>
			<p>Ce super site a �t� r�alis� par Constance SALLE et C�sar DELIGNY</p>
			<p>Pour le BDE Spacem'Hein.</p>
	    </footer>



        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

	</body>


</html>--%>
