<!DOCTYPE html>

<!-- Referenciar os ManagedBeans -->
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanComanda"	id="mb"></jsp:useBean>

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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<link rel="stlesheet" href="css/menu.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>

</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	
	<div class="container">
		<h2>Comandas abertas</h2>
		<table class="table table-hover highlight responsive-table">
			<thead>
				<tr>
					<th>Comanda</th>
					<th>Nome</th>
					<th>Status</th>
					<th>Valor Total</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mb.listagemComandas}" var="comanda">
				<tr>
					<td>${comanda.codComanda}</td>
					<td>${comanda.nome}</td>
					<td>${comanda.status}</td>
					<td>R$ ${comanda.valorTotal}</td>
					<td><a href="ServletComanda?acao=adicionaritem&id=${comanda.codComanda}&action=1" class="waves-effect waves-light btn">Adicionar</a></td>
					<td><a href="ServletComanda?acao=detalhescomanda&id=${comanda.codComanda}" class="waves-effect waves-light btn">Detalhes</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> 

</body>
</html>