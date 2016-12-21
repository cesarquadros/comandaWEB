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

	<h2 style="margin: auto; text-align: center; font-family: serif;">Produtos</h2>
	<div style="margin: auto; width: 95%;">

		<form class="col s12" name="formulario" method="post" action="ServletComanda?acao=cadastrarproduto" style="width: 25%; float: left;">
			<div class="row" style="width: 400px;">
				<div class="input-field col s6" style="width: 250px;">
					<input id="first_name2" type="text" class="validate"
						name="descricao" required> <label class="active"
						for="first_name2">Produto</label>
				</div>

				<div class="input-field col s6" style="width: 250px;">
					<input id="first_name2" type="text" class="validate" name="preco"
						required> <label class="active" for="first_name2">Preço</label>
				</div>
			</div>
			<div class="row" style="width: 400px;">
				<div class="input-field col s12" style="width: 250px;">
					<select name="idCategoria" required>
						<option value="">Selecione a categoria</option>
						<c:forEach items="${mbC.listagemCategoria}" var="categoria">
							<option value="${categoria.codCategoria }">${categoria.categoria}</option>
						</c:forEach>
					</select>
				</div>

				<div class="input-field col s6" style="width: 250px;">
					<input id="first_name2" type="text" class="validate"
						name="observacoes" required> <label class="active"
						for="first_name2">Observações</label>
				</div>
			</div>
			<input type="submit" class="waves-effect waves-light btn" value="Salvar" style="border-radius: 50px"/>
		</form>

		<h4 style="color: green">${mensagem}</h4>
		<h4 style="color: red">${mensagem2}</h4>
		<br />
		<div style="overflow: auto; width: 75%; height: 500px;">
			<table class="table table-hover highlight responsive-table bordered"
				id="dataTables-example">
				<thead>
					<tr>
						<th>ID Produto</th>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Observações</th>
						<th>Preço</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${mb.listagemProdutos}" var="produto">
						<tr>
							<td>${produto.codProdutos}</td>
							<td>${produto.descricao}</td>
							<td>${produto.categoria.categoria}</td>
							<td>${produto.observacoes}</td>
							<td>R$ ${produto.preco}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<script type="text/javascript" src="js/materialize.js"></script>
</body>
</html>