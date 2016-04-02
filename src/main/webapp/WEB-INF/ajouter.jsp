<html>

	<head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="../css/materialize.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>





		<meta charset="UTF-8" />
		<%--<link href="CSS/ajouter.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/header.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/footer.css" rel="stylesheet" type="text/css" media="all" />--%>

		<title>We Plan</title>
		<link rel="shortcut icon" href="../IMG/favicon.ico" type="image/x-icon">
		<link rel="icon" href="../IMG/favicon.ico" type="image/x-icon">

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
					<li><a href="" class="choix"><input type="submit" value="Enregistrer"><img src="IMG/disquette.png"> Enregistrer</input></a></li>
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
        <script type="text/javascript" src="../js/materialize.js"></script>

	</body>


</html>