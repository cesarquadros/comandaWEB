package br.com.comanda.managedbeans;

import java.util.List;

import br.com.comanda.entities.Produtos;
import br.com.comanda.persistence.ProdutosDAO;

public class ManagedBeanProduto {
	
	private List<Produtos> listagemProdutos;
	
	public List<Produtos> getListagemProdutos(){
		
		ProdutosDAO p = new ProdutosDAO();
		return listagemProdutos = p.listAll();
	}

}
