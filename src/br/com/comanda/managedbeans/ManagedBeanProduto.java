package br.com.comanda.managedbeans;

import java.util.List;

import br.com.comanda.entities.Produto;
import br.com.comanda.persistence.ProdutosDAO;

public class ManagedBeanProduto {
	
	private List<Produto> listagemProdutos;
	
	public List<Produto> getListagemProdutos(){
		
		ProdutosDAO p = new ProdutosDAO();
		return listagemProdutos = p.listAll();
	}

}
