<!DOCTYPE html>

<!-- Referenciar os ManagedBeans -->
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanProduto"	id="mb"></jsp:useBean>
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanCategoria"	id="mbC"></jsp:useBean>

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
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.4.js"></script><style type="text/css"></style>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">    
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>



</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>

	<script type="text/javascript">//<![CDATA[
		window.onload=function(){
		$(document).ready(function() {
		    $('select').material_select();
		});
	}
	</script>
	
	
	<div class="container" style="margin-left: 30px;">
		<h2>Produtos</h2>
		
	<div class="row">
	    <div class="input-field col s6">
	      <input id="first_name2" type="text" class="validate">
	      <label class="active" for="first_name2">Produto</label>
	    </div>

	    <div class="input-field col s6">
	      <input id="first_name2" type="text" class="validate">
	      <label class="active" for="first_name2">Preço</label>
	    </div>

		  <div class="input-field col s12">
		    <select>
		      <option value="" disabled selected>Escolha uma categoria</option>
		      <c:forEach items="${mbC.listagemCategoria}" var="categoria">
		      		<option value="${categoria.codCategoria }"> ${categoria.categoria} </option>
		      </c:forEach>
		    </select>
		  </div>	    
	    
	</div>	
	
  
  
		<br/><br/><br/><br/><br/><br/>
		<table class="table table-hover highlight responsive-table" id="dataTables-example">
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
	  
</body>
</html>