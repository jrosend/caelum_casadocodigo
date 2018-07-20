package br.com.casadocodigo.loja.models.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class ArquivoValidator implements Validator{

	@Override
	public boolean supports(Class<?> cls) {
		return MultipartFile.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object object, Errors erros) {
		System.out.println("Validando extensão do arquivo");
		MultipartFile multiPartFile = (MultipartFile)object;
		if(multiPartFile.getOriginalFilename().endsWith(".exe")){
			erros.rejectValue("caminhoSumario", "campo.invalido");
		}
	}
}
