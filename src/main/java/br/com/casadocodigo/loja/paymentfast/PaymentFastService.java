package br.com.casadocodigo.loja.paymentfast;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentFastService {
	@Autowired
	private RestTemplate restTemplate;
	
	public String efetuarPagamento(BigDecimal valor) {
		try {
			ResponseEntity<String> response = restTemplate.postForEntity(new URI("http://book-payment.herokuapp.com/payment"), new PaymentFastInput(valor), String.class);
			if(response.getStatusCode() != HttpStatus.OK){
				return "Ocorreum um erro no request. Pagamento não realizado";
			} 
			return response.getBody();
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
			return "Ocorreu um erro. Pagamento não realizado";
		}
	}
}
