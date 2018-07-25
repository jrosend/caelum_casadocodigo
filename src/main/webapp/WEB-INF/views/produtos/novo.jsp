<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Produto</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
</head>
	<body>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
		
		<h3>Novo produto</h3>
		
		<form:form servletRelativeAction="/produtos" id="formNovoLivro" method="post" commandName="produto" enctype="multipart/form-data">
			<div>
				Título
				<form:input path="titulo" type="text" name="titulo"/>
				<br/>
				<form:errors path="titulo"/>
			</div>
			<br/>
			<div>
				Descrição
				<form:textarea path="descricao" name="descricao"/>
				<br/>
				<form:errors path="descricao"/>
			</div>
			<br/>
			<div>
				Autor
				<form:input type="text" name="autor" path="autor"/>
				<br/>
				<form:errors path="autor"/>
			</div>
			<br/>
			<div>
				Número de Páginas
				<form:input type="number" name="numeroPaginas" path="numeroPaginas"/>
				<br/>
				<form:errors path="numeroPaginas"/>
			</div>
			<br/>
			<h3>Preços</h3>
			<c:forEach items="${tiposProduto}" var="tipoProduto" varStatus="index">
				<div>
					<label>${tipoProduto}</label>
					<form:input path="precos[${index.index}].valor" type="text" name="precos[${index.index}].valor"/>
					<form:input path="precos[${index.index}].tipoProduto" type="hidden" value="${tipoProduto}" name="precos[${index.index}].tipoProduto"/>
				</div>
			</c:forEach>
			
			<div>
				<label for="dataLancamento">Data de lançamento</label>
				<form:input type="date" path="dataLancamento" name="dataLancamento" id="dataLancamento"/>
				<form:errors path="dataLancamento"></form:errors>
			</div>
			
			<div>
				<label for="sumario">Sumário do livro</label>
				<input type="file" name="sumario" id="sumario"/>
				<form:errors path="caminhoSumario"/>
			</div>
			
			<input type="submit" value="Incluir"></input>
		</form:form>
	</body>
</html>