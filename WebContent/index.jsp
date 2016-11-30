<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanComanda"
	id="mb"></jsp:useBean>
<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<html>
<head>

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />



<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/index2.css" />
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<title>Controle de Comanda</title>

</head>

<body id="corpo">

	<div id="corpo2">
		<!--Import jQuery before materialize.js-->
		<script type="text/javascript"
			src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.min.js"></script>
		<!-- ---------------------------------------------------------------------------- -->

		<div style="width: 100%; margin: auto; margin-top: 5px;">
			<nav class="nav-extended" style="background: rgb(0,150,136);"
				id="menu">
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
					<li class="tab"><a class="active" href="#test1">Comandas
							Abertas</a></li>
					<li class="tab"><a href="#test2">Test 2</a></li>
					<li class="tab disabled"><a href="#test3">Disabled Tab</a></li>
					<li class="tab"><a href="#test4">Test 4</a></li>
				</ul>
			</div>
			</nav>
			
			<div id="test1" class="col s12">
			<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------ -->
			<ul class="collapsible" data-collapsible="accordion">
			  <c:forEach items="${mb.listagemComandas}" var="comanda">
			  <li>			  
			    <div class="collapsible-header" id=""><i class="small material-icons">perm_identity</i>
				    <label class="lbls">${comanda.nome}</label>
				    <label class="lbls" id="lblTotal">Valor Total: R$ ${comanda.valorTotal}</label>
			    </div>	
			    
			    <div class="collapsible-body" id="itens">
					<p>
						<button type="button" class="btn btn-danger btn-xs" id="btnAdd">Adicionar Produtos</button>
						<button type="button" class="btn btn-warning btn-xs" id="btnFechar">Fechar Comanda</button>
						<button type="button" class="btn btn-sucess btn-xs" id="btnPag">Efetuar Pagamentos</button>
					</p>
					<table>
			        <thead>
			          <tr>
			              <th data-field="id">Produto</th>
			              <th data-field="name">Categoria</th>
			              <th data-field="price">Preço</th>
			               <th data-field="price"></th>
			          </tr>
			        </thead>
			        
			        <tbody>

			    <c:forEach items="${comanda.listItemComanda}" var="item">    
						<tr>
					
						 <td><label class="lbls">${item.produtos.descricao}</label> </td>
						 <td><label class="lbls">${item.produtos.categoria.categoria}</label></td>
						 <td><label class="lbls">${item.produtos.preco}</label></td>
						 <td><button type="button" class="btn btn-danger btn-xs" id="btnExcluir">X</button></td>
						 </tr>
					
			  </c:forEach>

			        </tbody>     				 
				 </table>
				</div>	
					
				
				 		    

			   
			 	
			  		
			  </li>
			  </c:forEach>
			</ul>
			<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------ -->
			</div>
			<div id="test2" class="col s12">Test 2</div>
			<div id="test3" class="col s12">Test 3</div>
			<div id="test4" class="col s12">Test 4</div>
		</div>
	</div>
</body>
</html>