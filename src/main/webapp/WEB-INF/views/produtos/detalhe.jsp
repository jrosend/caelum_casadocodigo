<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="cdc" tagdir="/WEB-INF/tags"%>

<cdc:page title="${produto.titulo}">
	<article id="${produto.titulo}" itemscope
		itemtype="http://schema.org/Book">
		<header id="product-highlight" class="clearfix">
			<div id="product-overview" class="container">
				<img itemprop="image" width="280px" height="395px"
					src='http://cdn.shopify.com/s/files/1/0155/7645/products/cover-apis-java_large.jpeg?v=1423244220'
					class="product-featured-image" alt="${produto.titulo}">
				<h1 class="product-title" itemprop="name">${produto.titulo}</h1>
				<p class="product-author">
					<span class="product-author-link">${produto.autor}</span>
				</p>

				<p itemprop="description" class="book-description">
					${produto.descricao}<br /> Veja o <a
						href="<c:url value='/${produto.caminhoSumario}'/>" target="_blank">sum&#225;rio</a>
					completo do livro!
				</p>
			</div>
		</header>

		<section class="buy-options clearfix">
			<form:form servletRelativeAction="/shopping" method="post"
				class="container">
				<input type="hidden" value="${produto.id}" name="id" />
				<ul id="variants" class="clearfix">
					<c:forEach items="${produto.precos}" var="preco">
						<li class="buy-option"><input type="radio" name="tipoProduto"
							class="variant-radio" id="${produto.id}-${preco.tipoProduto}"
							value="${preco.tipoProduto}"
							${preco.tipoProduto.name() == 'FISICO' ? 'checked' : ''}>

							<label class="variant-label"
							for="${produto.id}-${preco.tipoProduto}">
								${preco.tipoProduto} </label>
							<p class="variant-price">${preco.valor}</p></li>
					</c:forEach>
				</ul>

				<input type="submit" class="submit-image icon-basket-alt"
					alt="Compre agora" title="Compre agora '${produto.titulo}'!"
					value="comprar" />
			</form:form>
		</section>

		<div class="container">
			<section class="author product-detail" itemprop="author" itemscope
				itemtype="http://schema.org/Person">
				<h2 class="section-title" itemprop="name">${produto.titulo}</h2>
				<span itemprop="description">
					<p class="book-description">${produto.descricao}</p>
				</span>
			</section>

			<section class="data product-detail">
				<h2 class="section-title">Dados do livro:</h2>
				<p>
					Número de paginas: <span itemprop="numberOfPages">${produto.numeroPaginas}</span>
				</p>

				<p></p>
				<p>
					Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta
						uma errata</a>
				</p>
			</section>
		</div>
	</article>
</cdc:page>

