
<html>
<link rel="stlesheet" href="css/menu.css">
</head>
<body>
	<form class="col s12" name="formulario" method="post" action="ServletComanda?acao=abrircomanda">
	<nav>
		<div class="nav-wrapper" id="menu" style="background: gray;">
			<a href="index.jsp" class="brand-logo right">Logo</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="comandas.jsp">Comandas</a></li>
				<li><a href="produtos.jsp">Produtos</a></li>
				<li><a href="#">Relatorios</a></li>
				<li><a href="#modal1" class="modal-trigger waves-light btn" style="border-radius: 50px;">Nova Comanda</a></li>
			</ul>
		</div>
	</nav>

	<div class="modal" id="modal1" style="width: 300px;">
		<div class="modal-content">
			<h5>Abrir nova comanda</h5>
		</div>
		<div class="modal-footer">
			<div class="input-field col s6" style="width: 250px;">
				<input id="first_name2" type="text" class="validate" name="nome" required> <label class="active"for="first_name2">Nome da comanda</label>
			</div>
			<input type="submit" class="waves-effect waves-light btn" value="Salvar" style="border-radius: 50px"/>
		</div>
	</div>
</form>
	<script>
		$(document).ready(function() {
			$('.modal-trigger').leanModal();
		});
	</script>