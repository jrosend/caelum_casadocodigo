<%@taglib prefix="cdc" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<cdc:page title="Novo produto">

	<h3>Novo produto</h3>

	<form:form servletRelativeAction="/produtos" id="formNovoLivro"
		method="post" commandName="produto" enctype="multipart/form-data">
		<div>
			Título
			<form:input path="titulo" type="text" name="titulo" />
			<br />
			<form:errors path="titulo" />
		</div>
		<br />
		<div>
			Descrição
			<form:textarea path="descricao" name="descricao" />
			<br />
			<form:errors path="descricao" />
		</div>
		<br />
		<div>
			Autor
			<form:input type="text" name="autor" path="autor" />
			<br />
			<form:errors path="autor" />
		</div>
		<br />
		<div>
			Número de Páginas
			<form:input type="number" name="numeroPaginas" path="numeroPaginas" />
			<br />
			<form:errors path="numeroPaginas" />
		</div>
		<br />
		<h3>Preços</h3>
		<c:forEach items="${tiposProduto}" var="tipoProduto" varStatus="index">
			<div>
				<label>${tipoProduto}</label>
				<form:input path="precos[${index.index}].valor" type="text"
					name="precos[${index.index}].valor" />
				<form:input path="precos[${index.index}].tipoProduto" type="hidden"
					value="${tipoProduto}" name="precos[${index.index}].tipoProduto" />
			</div>
		</c:forEach>

		<div>
			<label for="dataLancamento">Data de lançamento</label>
			<form:input type="date" path="dataLancamento" name="dataLancamento"
				id="dataLancamento" />
			<form:errors path="dataLancamento"></form:errors>
		</div>

		<div>
			<label for="sumario">Sumário do livro</label> <input type="file"
				name="sumario" id="sumario" />
			<form:errors path="caminhoSumario" />
		</div>

		<input type="submit" value="Incluir"></input>
	</form:form>
</cdc:page>
