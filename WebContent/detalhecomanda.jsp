<!DOCTYPE html>

<!-- Referenciar os ManagedBeans -->
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanProduto"
	id="mb"></jsp:useBean>
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanCategoria"
	id="mbC"></jsp:useBean>

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



</head>
<body style="padding: 0px;">

	<jsp:include page="menu.jsp"></jsp:include>

	<script type="text/javascript">
		//<![CDATA[
		window.onload = function() {
			$(document).ready(function() {
				$('select').material_select();
			});
		}
	</script>

	<div class="chip">Comanda: ${id}</div>

	<h2 style="margin: auto; text-align: center; font-family: serif;">Detalhes
		da Comanda</h2>
	<div style="margin: auto; width: 95%;">


		<h4 style="color: green;">${mensagem}</h4>
		<h4 style="color: red;">${mensagem2}</h4>
		<br />

		<div style="overflow: auto; width: 55%; height: 500px;">
			<table class="table table-hover highlight responsive-table bordered"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Observações</th>
						<th>Quantidade</th>
						<th>Preço</th>
						<th>Adicionar</th>
						<th>Remover</th>
												
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listaComprovante}" var="comprovante">
						<tr>
							<td>${comprovante.descricao}</td>
							<td>${comprovante.categoria}</td>
							<td>${comprovante.observacoes}</td>
							<td>${comprovante.quantidade}</td>
							<td>R$${comprovante.valorTotal}</td>
							<td style="width: 10%"><a href="ServletComanda?acao=adicionaritem&produto=${comprovante.produto}&id=${id}&qtd=1&teste=1" class="waves-effect waves-light btn" style="border-radius: 50px">+</a></td>
							<td style="width: 10%"><a href="ServletComanda?acao=adicionaritem&produto=${comprovante.produto}&id=${id}&qtd=1&teste=1" class="waves-effect waves-light btn" style="border-radius: 50px; background: red;">-</a></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>