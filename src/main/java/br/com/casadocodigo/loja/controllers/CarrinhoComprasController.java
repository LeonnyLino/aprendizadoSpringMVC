package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	
	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
		ModelAndView view = new ModelAndView("redirect:/produto");
		CarrinhoItem item = criaItem(produtoId, tipoPreco);
		
		carrinho.add(item);
		
		return view;
		
	}


	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {

		Produto produto = dao.find(produtoId);
		CarrinhoItem item = new CarrinhoItem(produto, tipoPreco);
		
		return item;
	}
}
