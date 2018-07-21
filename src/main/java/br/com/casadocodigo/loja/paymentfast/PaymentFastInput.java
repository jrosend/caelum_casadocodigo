package br.com.casadocodigo.loja.paymentfast;

import java.math.BigDecimal;

public class PaymentFastInput {
	private BigDecimal value;

	public PaymentFastInput(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return this.value;
	}
}
