package br.com.casadocodigo.loja.repository.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.casadocodigo.loja.conf.AppConfig;
import br.com.casadocodigo.loja.conf.JPAConfig;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, JPAConfig.class, ProdutoRepository.class})
@ActiveProfiles({"teste"})
public class TestProdutoRepository {
	
	@Autowired private ProdutoRepository produtoRepository;
	
	@Test
	@Transactional
	public void testDeveCadastrarUmProduto(){
		Produto produto = new Produto();
		
		produtoRepository.inserir(produto);
		
		Produto produtoInserido = produtoRepository.getById(produto.getId());
		
		Assert.assertEquals(produto.getNumeroPaginas(), produtoInserido.getNumeroPaginas());
	}
}
