<!DOCTYPE html>

<!-- Referenciar os ManagedBeans -->
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanComanda"
	id="mb"></jsp:useBean>

<!-- TagLibraries (JSTL) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>


<html>
<head>
<title>Controle de Comandas</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<link rel="stlesheet" href="css/menu.css">

<!-- Compiled and minified JavaScript -->
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.4.js"></script>
<style type="text/css"></style>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

<!-- CORE CSS-->
<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="css/style.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<!-- Custome CSS-->
<link href="css/custom/custom.min.css" type="text/css" rel="stylesheet"
	media="screen,projection">

<!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
<link href="js/plugins/prism/prism.css" type="text/css" rel="stylesheet"
	media="screen,projection">
<link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="screen,projection">
<link href="js/plugins/chartist-js/chartist.min.css" type="text/css"
	rel="stylesheet" media="screen,projection">
<link href="js/plugins/jquery.nestable/nestable.css" type="text/css"
	rel="stylesheet" media="screen,projection">

</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	
	<div id="card-alert" class="card red">
                      <div class="card-content white-text">
                        <p>DANGER : The daily report has failed</p>
                      </div>
                      <button type="button" class="close white-text" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">×</span>
                      </button>
                    </div>

	<div class="col s12 m6 l3">
		<div class="card">
			<div class="card-content  green white-text">
				<p class="card-stats-title">
					<i class="mdi-social-group-add"></i> New Clients
				</p>
				<h4 class="card-stats-number">566</h4>
				<p class="card-stats-compare">
					<i class="mdi-hardware-keyboard-arrow-up"></i> 15% <span
						class="green-text text-lighten-5">from yesterday</span>
				</p>
			</div>
			<div class="card-action  green darken-2">
				<div id="clients-bar" class="center-align">
					<canvas width="227" height="25"
						style="display: inline-block; width: 227px; height: 25px; vertical-align: top;"></canvas>
				</div>
			</div>
		</div>
	</div>
</body>
</html>