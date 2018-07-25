package br.com.casadocodigo.loja.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.repository.UsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.obterUsuario(username);
		if(Objects.isNull(usuario)) throw new UsernameNotFoundException("Usuário não encontrado");
		return usuario;
	}
}
