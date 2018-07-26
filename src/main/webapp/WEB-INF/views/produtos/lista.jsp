<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="cdc" tagdir="/WEB-INF/tags"%>

<cdc:page title="Lista de produtos">

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
		<div>Olá, ${user.nome}</div>
		<div>
			<a href="/casadocodigo/logout">Sair</a>
		</div>
	</sec:authorize>

	<sec:authorize access="isAnonymous()">
		<a href="/casadocodigo/login">Entrar</a>
	</sec:authorize>

	<h3>Lista de Livros</h3>
	
	${sucesso}
	<table border="1">
		<thead>
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Páginas</th>
				<th>Preços</th>
				<th>Data de lancamento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto" varStatus="index">
				<tr>
					<td><a href="/casadocodigo/produtos/${produto.id}">${produto.titulo}</a>
					</td>
					<td>${produto.autor}</td>
					<td>${produto.numeroPaginas}</td>

					<td><c:forEach items="${produto.precos}" var="preco">
							<div>
								<c:if test="${not empty preco.valor}">
									<label>${preco.tipoProduto}: ${preco.valor}</label>
								</c:if>
							</div>
						</c:forEach></td>
					<td>
						<fmt:formatDate type="both" value="${produto.dataLancamento.getTime()}" pattern="dd/MM/yyyy"></fmt:formatDate>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="produtos/novo">Novo</a>
	</sec:authorize>

</cdc:page>
