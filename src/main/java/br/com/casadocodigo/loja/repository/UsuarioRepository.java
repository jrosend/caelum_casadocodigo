package br.com.casadocodigo.loja.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioRepository {
	@PersistenceContext
	private EntityManager em;
	
	public Usuario obterUsuario(String nomeUsuario){
		return em.createQuery("select u from Usuario u where u.nomeUsuario = :nomeUsuario", Usuario.class)
				.setParameter("nomeUsuario", nomeUsuario).getSingleResult();
	}
}
