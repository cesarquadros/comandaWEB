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

	<div class="chip">Comanda: ${id}</div>${mensagem}
	<!-- Dropdown Trigger -->

	<a class='dropdown-button btn' href='#' data-activates='dropdown1'
		style="border-radius: 50px; float: right; margin-right: 5px; margin-top: 5px;">Opções
		da Comanda</a>
	<!-- Dropdown Structure -->
	<ul id='dropdown1' class='dropdown-content'>
		<li><a href="#modaldetalhes" class="modal-trigger">Efetuar
				Pagamento</a></li>
		<li class="divider"></li>
		<li><a href="#modalpagamento" class="modal-trigger">Detalhes
				de Pagamentos</a></li>
		<li class="divider"></li>
		<li><a href="#!" class="modal-trigger">Fechar comanda</a></li>
	</ul>


	<!-- 							MODAL EFETUAR PAGAMENTOS -->
	<form class="col s12" name="formulario" method="post"
		action="ServletComanda?acao=efetuarpagamento&id=${id}">
		<div class="modal" id="modaldetalhes" style="width: 300px; border-radius: 10px; margin: auto; text-align: center;">
			<div class="modal-content">
				<h5>Valor a ser pago</h5>
			</div>
			<div class="modal-footer">
				<div class="input-field col s6" style="width: 200px; margin: auto;">
					<input id="valor" type="text" class="validate" name="valor"
						required> <label class="active" for="first_name2" style="text-align: left;">Valor</label>
				</div>
			</div>
				<br/>
			<div class="modal-footer">
				<div class="input-field col s6" style="width: 200px; margin: auto;">
					<input id="obeservacao" type="text" class="validate"
						name="obeservacao" required> <label class="active"
						for="first_name2" style="text-align: left;">Observação</label>
				</div>
			</div>
			<br /> <input type="submit" class="waves-effect waves-light btn"
				value="Efetuar pagamento"
				style="border-radius: 50px; margin: auto; margin-bottom: 5px; text-align: center;" />
		</div>
	</form>

	<!-- MODAL DETALHES DE PAGAMENTO -->
	<div class="modal" id="modalpagamento"
		style="width: 450px; height: 600px; border-radius: 30px;">
		<div class="modal-content">
			<div style="text-align: center;">
				<h5>Comanda WEB</h5>
				<h6>Cupon Fiscal</h6>
				<br />
				<h6>------------------- Histórico de pagamentos --------------------</h6>
			</div>
		</div>
		<div class="modal-footer">
			<table class="table table-hover highlight responsive-table bordered" id="dataTables-example" style="text-align: center;">
				<thead>
					<tr>
						<th>Quem pagou?</th>
						<th>Valor pago</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comanda.listPagamento}" var="pagamentos">
						<tr>
							<td>${pagamentos.observacaoPagamento}</td>
							<td>${pagamentos.valorPagamento}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="margin: auto;"> 
			<p style="color: green;">Valor pago: R$ ${comanda.valorPago}</p>
			<p style="color: red;">Valor á pagar: R$ ${comanda.valorAPagar}</p>
			<p>Valor total: R$ ${comanda.valorTotal}</p>
			</div>
		</div>
		<br />
	</div>






	<h2 style="margin: auto; text-align: center; font-family: serif;">Detalhes
		da Comanda</h2>
	<div style="margin: auto; width: 95%;">
		<br />

		<div style="overflow: auto; width: 70%; height: 580px; margin: auto;">
			<table class="table table-hover highlight responsive-table bordered"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Observações</th>
						<th>Preço</th>
						<th>Adicionar</th>
						<th>Remover</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comanda.listItemComanda}" var="itens">
						<tr>
							<td>${itens.produtos.descricao}</td>
							<td>${itens.produtos.categoria.categoria}</td>
							<td>${itens.produtos.observacoes}</td>
							<td>${itens.produtos.preco}</td>

							<td style="width: 10%"><a href="ServletComanda?acao=adicionaritem&produto=${itens.produtos.codProdutos}&id=${id}&qtd=1&teste=1" class="waves-effect waves-light btn" style="border-radius: 50px">+</a></td>
							<td style="width: 10%"><a href="ServletComanda?acao=removeritem&produto=${itens.produtos.codProdutos}&id=${id}&qtd=1&idItem=${itens.codItem}" class="waves-effect waves-light btn" style="border-radius: 50px; background: #ef5350;">-</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>