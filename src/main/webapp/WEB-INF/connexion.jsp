<html>
	<head>
		<meta charset="utf-8">
		<link href="CSS/connexion.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="CSS/header.css" rel="stylesheet" type="text/css" media="all" />
		<link href="CSS/footer.css" rel="stylesheet" type="text/css" media="all" />
		<title>WePlan</title>
		<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
		<link rel="icon" href="../img/favicon.ico" type="image/x-icon">
	</head>

	<body>
		<header id="ban">

			<h1>WePlan</h1>
			<h2>Toute la vie associative d'Hei</h2>
		
		</header>




	<div id="contenu">	
		

		<a id="inscription" href="inscription.html">
			<h1 class="titre"> Pas encore de compte ? </h1>
			<h1 class="titre"> Inscrivez vous</h1>
		</a>

		

	
			
		<section >
			<h2>Connectez vous</h2>

			<form action="/users/login" name="login" role="form" class="form-horizontal" method="post" accept-charset="utf-8">
                <div class="formulaire">
                <input name="username" placeholder="prenom.nom@hei.fr" class="form-control" type="text" id="UserUsername" required/>
              	</div>
                <div class="formulaire">
                <input name="password" placeholder="Mot de passe" class="form-control" type="password" id="UserPassword" required/>
                </div>
                <div>
                <input  class="btn" type="submit" value="Connexion"/>
            	</div>
            </form>

           <a id="aide" href="http://images.google.fr/imgres?imgurl=https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAMOAAAAJGQ4MWIxNzdhLTZkMmUtNDRlZi05ODczLWIxZTVjMDkwMzdjNw.jpg&imgrefurl=https://fr.linkedin.com/in/cesardeligny&h=200&w=200&tbnid=w5OVHGl2nGKimM:&tbnh=90&tbnw=90&docid=j1eiEap0BQiDOM&usg=__Nxx2R-PopXyys7FwYRsgcxnVMoU=&sa=X&ved=0ahUKEwi9huPWqsXKAhXGCBoKHTkKDgMQ9QEIHjAA"> Besoin d'aide ?</a>

		</section>
	</div>


	</body>
</html>