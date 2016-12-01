<head>
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanComanda" id="mb"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<html>
	<body>

		<ul class="collapsible" data-collapsible="accordion">
			  <c:forEach items="${mb.listagemComandas}" var="comanda">
			  <li>			  
			    <div class="collapsible-header" id=""><i class="small material-icons">perm_identity</i>
				    <label class="lbls">${comanda.nome}</label>
				    <label class="lbls" id="lblTotal">Valor Total: R$ ${comanda.valorTotal}</label>
			    </div>	
			    
			    <div class="collapsible-body" id="itens">
					<p>
						<button type="button" class="btn btn-danger btn-xs" id="btnAdd" href="#test4">Adicionar Produtos</button>
						<button type="button" class="btn btn-warning btn-xs" id="btnFechar">Fechar Comanda</button>
						<button type="button" class="btn btn-sucess btn-xs" id="btnPag">Efetuar Pagamentos</button>
					</p>
					<table class="striped responsive-table">
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
						 <td><label class="lbls itens">${item.produtos.descricao}</label> </td>
						 <td><label class="lbls">${item.produtos.categoria.categoria}</label></td>
						 <td><label class="lbls">R$ ${item.produtos.preco}</label></td>
						 <td><button type="button" class="btn btn-danger btn-xs" id="btnEx">X</button></td>
					 </tr>
			  </c:forEach>

			        </tbody>     				 
				 </table>
				</div>		 	
			  </li>
			  </c:forEach>
			</ul>
	</body>
</html>