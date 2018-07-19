package br.com.casadocodigo.loja.models.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produto produto = (Produto)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autor", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "campo.obrigatorio");
		
		if(produto.getNumeroPaginas() == null || produto.getNumeroPaginas() < 1){
			errors.rejectValue("numeroPaginas", "campo.invalido");
		}
	}
}
