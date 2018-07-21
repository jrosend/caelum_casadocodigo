package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.ShoppingItem;
import br.com.casadocodigo.loja.models.TipoProduto;
import br.com.casadocodigo.loja.paymentfast.PaymentFastService;
import br.com.casadocodigo.loja.repository.ProdutoRepository;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ShoppingCart cart;
	
	@Autowired
	private PaymentFastService paymentFastService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(Long id, TipoProduto tipoProduto){
		System.out.println(String.format("Adicionando produto %s ao carrinho", id));
		Produto produto = produtoRepository.getById(id);
		System.out.println(produto);
		ShoppingItem item = new ShoppingItem(produto, tipoProduto);
		cart.add(item);
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String mostrarCarrinho(){
		return "shopping/cart";
	}
	@RequestMapping(value="checkout", method=RequestMethod.POST)
	public Callable<String> checkout(RedirectAttributes redirectAttributes){
		final DeferredResult<String> result = new DeferredResult<String>();
		return () -> {
			String mensagem = paymentFastService.efetuarPagamento(this.cart.getTotal());
			redirectAttributes.addFlashAttribute("sucesso", mensagem);
			this.cart.clear();
			return "redirect:/produtos";
		};
	}
}
