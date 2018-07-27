package br.com.casadocodigo.loja.builders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.casadocodigo.loja.models.Preco;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoProduto;

public class ProdutoBuilder {
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private ProdutoBuilder(Produto produto){
		produtos.add(produto);
	}
	
	public static ProdutoBuilder novoProduto(TipoProduto tipoProduto, BigDecimal valor){
		Produto produto = criar("Livro 1", tipoProduto, valor);
		return new ProdutoBuilder(produto);
	}
	
	public static ProdutoBuilder novoProduto(){
		Produto produto = criar("LIVRO 2", TipoProduto.DIGITAL, BigDecimal.TEN);
		return new ProdutoBuilder(produto);
	}
	

	private static Produto criar(String nome, TipoProduto tipoProduto, BigDecimal valor) {
		Produto produto = new Produto();
		produto.setTitulo(nome);
		produto.setDataLancamento(Calendar.getInstance());
		produto.setNumeroPaginas(167);
		produto.setDescricao("Longa e tediosa descrição");
		produto.setAutor("Desconhecido");
		
		Preco preco = new Preco();
		preco.setTipoProduto(tipoProduto);
		preco.setValor(valor);
		
		produto.getPrecos().add(preco);
		return produto;
	}
	
	public ProdutoBuilder mais(int numero){
		Produto base = produtos.get(0);
		Preco preco = base.getPrecos().get(0);
		
		for(int i = 0; i < numero; i++){
			produtos.add(criar("Livro "+numero, preco.getTipoProduto(), preco.getValor()));
		}
		return this;
	}
	
	public Produto buildOne(){
		return produtos.get(0);
	}
	
	public List<Produto> buildAll(){
		return produtos;
	}
	
	
}
