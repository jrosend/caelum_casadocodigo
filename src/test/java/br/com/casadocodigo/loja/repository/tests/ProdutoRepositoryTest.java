package br.com.casadocodigo.loja.repository.tests;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfig;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoProduto;
import br.com.casadocodigo.loja.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class, ProdutoRepository.class, DataSourceConfigurationTest.class})
@ActiveProfiles({"teste"})
public class ProdutoRepositoryTest {
	
	@Autowired private ProdutoRepository produtoRepository;
	
	@Test
	@Transactional
	public void shouldSumAllPricesOfEachBookPerType(){
		List<Produto> livrosFisicos = ProdutoBuilder.novoProduto(TipoProduto.FISICO, BigDecimal.TEN).mais(4).buildAll();
		livrosFisicos.stream().forEach(produtoRepository::inserir);
		
		List<Produto> livrosDigitais = ProdutoBuilder.novoProduto(TipoProduto.DIGITAL, BigDecimal.TEN).mais(4).buildAll();
		livrosDigitais.stream().forEach(produtoRepository::inserir);
		
		BigDecimal valor = produtoRepository.somarPrecosPorTipo(TipoProduto.FISICO);
		
		Assert.assertEquals(new BigDecimal(50).setScale(2), valor);
	}
}
