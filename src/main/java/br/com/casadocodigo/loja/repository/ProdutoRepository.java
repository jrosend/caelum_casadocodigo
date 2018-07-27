package br.com.casadocodigo.loja.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoProduto;

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

	public Produto getById(Long id) {
		return em.createQuery("select p from Produto p join fetch p.precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somarPrecosPorTipo(TipoProduto tipoProduto) {
		TypedQuery<BigDecimal> query = em.createQuery("select sum(preco.valor) from Produto p join p.precos preco where preco.tipoProduto = :tipoProduto", BigDecimal.class);
		query.setParameter("tipoProduto", tipoProduto);
		return query.getSingleResult();
	}
}
