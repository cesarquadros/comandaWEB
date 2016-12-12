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

	<div class="chip" style="color: black;">
		Comanda: <label id="idcomanda">${id}</label>
	</div>
	${mensagem}
	<br />



	<div class="row" style="width: 80%;">
		<div class="col s12">
			<ul class="tabs" style="color: black">
				<li class="tab col s3"><a href="#cerveja" class="active"
					style="color: black">Cerveja</a></li>
				<li class="tab col s3"><a href="#bebidas" style="color: black">Bebidas</a></li>
				<li class="tab col s3"><a href="#lanches" style="color: black">Lanches</a></li>
				<li class="tab col s3"><a href="#outros" style="color: black">Outros</a></li>
			</ul>
		</div>

		<div id="cerveja" class="col s12">
			<br /> <br />
			<div style="margin: auto; width: 100%;">
				<div style="overflow: auto; width: 100%; height: 500px;border-top: solid 1px black">
					<table class="table table-hover highlight responsive-table bordered" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Nome</th>
								<th>Observações</th>
								<th>Preço</th>
								<th>Quantidade</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${mb.listagemProdutos}" var="produto">
							<form name="formulario" method="post" action="ServletComanda?acao=adicionaritem&id=${id}&produto=${produto.codProdutos}">
								<c:if test="${produto.categoria.codCategoria=='1'}">
									<tr>
										<td><label id="codProduto">${produto.codProdutos}</label></td>
										<td>${produto.descricao}</td>
										<td>${produto.observacoes}</td>
										<td>R$ ${produto.preco}</td>
										<td style="width: 30px;">
											<div class="input-field col s6" style="width: 100px;">
												<input id="quantidade" type="number" class="validate"
													name="qtd" required> <label class="active"
													for="first_name2">QTD</label>
											</div>
										</td>
 
										<td><input type="submit" id="add" value="Adicionar"class="btn btn-sm"
											style="background-color: #ffc8a4; font-size: 14; color: black; border-color: black; margin-left: 10px">
									</td>
									</tr>
								</c:if>
								</form>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="bebidas" class="col s12">
			<br /> <br />
			<div style="margin: auto; width: 100%;">
				<div style="overflow: auto; width: 100%; height: 500px;">
					<table
						class="table table-hover highlight responsive-table bordered"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Observações</th>
								<th>Preço</th>
								<th>Quantidade</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${mb.listagemProdutos}" var="produto">
							<form name="formulario" method="post" action="ServletComanda?acao=adicionaritem&id=${id}&produto=${produto.codProdutos}">
								<c:if test="${produto.categoria.codCategoria=='2'}">
															
									<tr>
										<td><label id="codProduto2">${produto.codProdutos}</label></td>
										<td>${produto.descricao}</td>
										<td>${produto.observacoes}</td>
										<td>R$ ${produto.preco}</td>
										<td style="width: 30px;">
											<div class="input-field col s6" style="width: 250px;">
												<input id="quantidade2" type="number" class="validate"
													name="qtd" required> <label class="active"
													for="first_name2">QTD</label>
											</div>
										</td>

										<td><input type="submit" id="add" value="Adicionar"class="btn btn-sm"
											style="background-color: #ffc8a4; font-size: 14; color: black; border-color: black; margin-left: 10px">
									</td>
									</tr>
								</c:if>
								</form>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="lanches" class="col s12">
			<br /> <br />
			<div style="margin: auto; width: 100%;">
				<div style="overflow: auto; width: 100%; height: 500px;">
					<table
						class="table table-hover highlight responsive-table bordered"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Observações</th>
								<th>Preço</th>
								<th>Quantidade</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${mb.listagemProdutos}" var="produto">
								<form name="formulario" method="post" action="ServletComanda?acao=adicionaritem&id=${id}&produto=${produto.codProdutos}">
								<c:if test="${produto.categoria.codCategoria=='3'}">
									<tr>
										<td><label id="codProduto3">${produto.codProdutos}</label></td>
										<td>${produto.descricao}</td>
										<td>${produto.observacoes}</td>
										<td>R$ ${produto.preco}</td>
										<td style="width: 30px;">
											<div class="input-field col s6" style="width: 250px;">
												<input id="quantidade3" type="number" class="validate"
													name="qtd" required> <label class="active"
													for="first_name2">QTD</label>
											</div>
										</td>

										<td><input type="submit" id="add" value="Adicionar"class="btn btn-sm"
											style="background-color: #ffc8a4; font-size: 14; color: black; border-color: black; margin-left: 10px">
									</td>
									</tr>
								</c:if>
								</form>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div id="outros" class="col s12">
			<br /> <br />
			<div style="margin: auto; width: 100%;">
				<div style="overflow: auto; width: 100%; height: 500px;">
					<table
						class="table table-hover highlight responsive-table bordered"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Observações</th>
								<th>Preço</th>
								<th>Quantidade</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${mb.listagemProdutos}" var="produto">
							<form name="formulario" method="post" action="ServletComanda?acao=adicionaritem&id=${id}&produto=${produto.codProdutos}">							
								<c:if test="${produto.categoria.codCategoria=='4'}">
									<tr>
										<td><label id="codProduto4">${produto.codProdutos}</label></td>
										<td>${produto.descricao}</td>
										<td>${produto.observacoes}</td>
										<td>R$ ${produto.preco}</td>
										<td style="width: 30px;">
											<div class="input-field col s6" style="width: 250px;">
												<input id="quantidade4" type="number" class="validate"
													name="qtd" required> <label class="active"
													for="first_name2">QTD</label>
											</div>
										</td>

										<td><input type="submit" id="add" value="Adicionar"class="btn btn-sm"
											style="background-color: #ffc8a4; font-size: 14; color: black; border-color: black; margin-left: 10px">
									</td>
									</tr>
								</c:if>
								</form>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>

</body>
</html>