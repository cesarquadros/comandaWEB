<head>
<jsp:useBean class="br.com.comanda.managedbeans.ManagedBeanProduto" id="mb2"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<html>
	<body>
		<c:forEach items="${mb2.listagemProdutos}" var="produtos">
		<p>${produtos.descricao}</p>
		</c:forEach>
	</body>
</html>