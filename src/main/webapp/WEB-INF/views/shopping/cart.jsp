<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="cdc" tagdir="/WEB-INF/tags"%>

<cdc:page title="Carrinho">
	<section class="container middle">
		<h2 id="cart-title">Seu carrinho de compras</h2>
		<table id="cart-table">
			<colgroup>
				<col class="item-price-col">
				<col class="item-quantity-col">
				<col class="line-price-col">
			</colgroup>
			<thead>
				<tr>
					<th width="70%">Item</th>
					<th width="10%">Preço</th>
					<th width="10%">Quantidade</th>
					<th width="10%">Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoppingCart.list}" var="item">
					<tr>
						<td class="item-title">${item.product.titulo}-${item.bookType}</td>
						<td class="numeric-cell">${item.price}</td>
						<td class="quantity-input-cell">${shoppingCart.getQuantity(item)}</td>
						<td class="numeric-cell">${shoppingCart.getTotal(item)}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><form:form
							servletRelativeAction="/shopping/checkout" method="post">
							<input type="submit" class="checkout" name="checkout"
								value="Finalizar compra" id="checkout" />
						</form:form></td>
					<td></td>
					<td class="numeric-cell">${shoppingCart.total}</td>
				</tr>
			</tfoot>
		</table>
	</section>
</cdc:page>
