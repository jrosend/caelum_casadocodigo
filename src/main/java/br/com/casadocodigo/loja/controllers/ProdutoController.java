package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoProduto;
import br.com.casadocodigo.loja.models.validators.ProdutoValidator;
import br.com.casadocodigo.loja.repository.ProdutoRepository;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtosRepository;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		//webDataBinder.addValidators(new ProdutoValidator());
	}
	
	@RequestMapping("novo")
	public ModelAndView novoProduto(Produto produto){
		return new ModelAndView("produtos/novo", "tiposProduto", TipoProduto.values());
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView inserirProduto(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		System.out.println(produto);
		if(bindingResult.hasErrors()){
			return this.novoProduto(produto);
		}
		this.produtosRepository.inserir(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView obterProdutos(){
		List<Produto> produtos = this.produtosRepository.listarProdutos();
		produtos.forEach((produto) -> System.out.println(produto));
		return new ModelAndView("produtos/lista", "produtos", produtos);
	}
}