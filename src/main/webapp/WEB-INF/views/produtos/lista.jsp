<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<h3>Lista de Livros</h3>
	${sucesso}
	<table border="1">
		<thead>
			<tr>
				<th>
					Título
				</th>
				<th>
					Autor
				</th>
				<th>
					Páginas
				</th>
				<th>
					Preços
				</th>
				<th>
					Data de lancamento
				</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${produtos}" var="produto" varStatus="index">
			<tr>
				<td>
					<a href="/casadocodigo/produtos/${produto.id}">${produto.titulo}</a>
				</td>
				<td>
					${produto.autor}
				</td>
				<td>
					${produto.numeroPaginas}
				</td>
				
				<td>
					<c:forEach items="${produto.precos}" var="preco">
					<div>
						<c:if test="${not empty preco.valor}">
							<label>${preco.tipoProduto}: ${preco.valor}</label>
						</c:if>
					</div>
					</c:forEach>
				</td>
				<td>
					<fmt:formatDate type="both" value="${produto.dataLancamento.getTime()}" pattern="dd/MM/yyyy"></fmt:formatDate>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="produtos/novo">Novo</a>
</body>
</html>