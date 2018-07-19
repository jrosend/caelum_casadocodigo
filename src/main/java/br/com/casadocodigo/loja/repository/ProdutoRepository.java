package br.com.casadocodigo.loja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;

@Repository
public class ProdutoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(final Produto livro){
		em.persist(livro);
	}
	
	public List<Produto> listarProdutos(){
		return em.createQuery("select distinct(p) from Produto p left join fetch p.precos", Produto.class).getResultList();
	}
}
