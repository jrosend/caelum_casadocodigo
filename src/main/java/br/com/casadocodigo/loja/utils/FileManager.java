package br.com.casadocodigo.loja.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	public String save(MultipartFile multipartFile){
		try {
			String fullPath = System.getProperty("user.home")+"/"+"uploads"+"/"+multipartFile.getOriginalFilename();
			System.out.println(fullPath);
			multipartFile.transferTo(new File(fullPath));
			return fullPath;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
