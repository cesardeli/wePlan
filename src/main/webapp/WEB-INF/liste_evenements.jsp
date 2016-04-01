<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>


<head>
	<meta charset="UTF-8"></meta>
		<link href="CSS/liste_evenements.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/header.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/footer.css" rel="stylesheet" type="text/css" media="all" />

<title>We Plan</title>
<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
<link rel="icon" href="../img/favicon.ico" type="image/x-icon">

</head>


<body>

	<header id="ban">

		<h1>We Plan</h1>
		<h2>Toute la vie associative de HEI</h2>

	</header>

	<a href="deconnexion.html" id="deconnexion"><img
		src="IMG/btn_deconnexion.png">Déconnexion</a>

	<div id="contenu">



		<section>
			<h1>Bonjour Pierre,</h1>

			<h2>Voici le programme de la semaine :</h2>

			<p id="ajouter">
				<a href="ajouter"><img src="IMG/btn_ajouter.png">Ajouter</a>
			</p>

		</section>

		<section>
			<c:forEach var="evenements" items="${evenements}">
				<article>
					<p>
						Nom : ${evenements.evenement_nom}, 
					</p>
					<p>
						Date début: ${evenements.evenement_date_debut}, 
						Heure début : ${evenements.evenement_heure_debut} ,
					</p>
					<p>
						Date fin : ${evenements.evenement_date_fin },
						Heure fin : ${evenements.evenement_heure_fin },
					</p>
					
					<c:if test="${not evenement.evenement_prive}">Evenement prive Lieu : ${evenements.evenement_lieu }</c:if>
					
					
   					<p>
   						Lieu : ${evenements.evenement_lieu }
   					<p>
				
					<p>
						Description: ${evenements.evenement_description}
					</p>
				</article>

				
		</section>
		
		</c:forEach>




	</div>


	<footer>
		<p>Ce super site a été réalisé par Constance SALLE et César
			DELIGNY</p>
		<p>Pour le BDE Spacem'Hein.</p>
	</footer>




</body>





</html>