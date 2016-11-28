<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
<html>
<head>

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
<title>BAR DO BUGÃO</title>
</head>
<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<!-- ---------------------------------------------------------------------------- -->


	<nav class="nav-extended" style="background: rgb(0,150,136)">

	<div class="nav-wrapper">
		<a href="#" class="brand-logo">Logo</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="sass.html">Sass</a></li>
			<li><a href="badges.html">Components</a></li>
			<li><a href="collapsible.html">JavaScript</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="sass.html">Sass</a></li>
			<li><a href="badges.html">Components</a></li>
			<li><a href="collapsible.html">JavaScript</a></li>
		</ul>

		<ul class="tabs tabs-transparent">
			<li class="tab"><a href="#test1">Test 1</a></li>
			<li class="tab"><a class="active" href="#test2">Test 2</a></li>
			<li class="tab disabled"><a href="#test3">Disabled Tab</a></li>
			<li class="tab"><a href="#test4">Test 4</a></li>
		</ul>
	</div>
	</nav>
	
	<div id="test1" class="col s12" style="height: 50%;" >
		<ul class="collapsible" data-collapsible="accordion" style="height: 50%">
			<li style="height: 50%">
				<div class="collapsible-header" style="height: 50%">
					<span class="new badge"></span><i class="material-icons"></i>Comanda
				</div>
				<div class="collapsible-body">
					<p>Item 1</p>
				</div>
			</li>
						<li style="height: 50%">
				<div class="collapsible-header" style="height: 50%">
					<span class="new badge"></span><i class="material-icons"></i>Comanda2
				</div>
				<div class="collapsible-body">
					<p>Item 1</p>
				</div>
			</li>
		</ul>
	</div>
	
	<div id="test2" class="col s12">Test 2</div>
	<div id="test3" class="col s12">Test 3</div>
	<div id="test4" class="col s12">Test 4</div>


</body>
</html>