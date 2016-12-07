package br.com.comanda.managedbeans;

import java.util.List;

import br.com.comanda.entities.Categoria;
import br.com.comanda.persistence.CategoriaDAO;

public class ManagedBeanCategoria {
	
	private List<Categoria> listagemCategoria;
	
	public List<Categoria> getListagemCategoria(){
		
		CategoriaDAO c = new CategoriaDAO();
		return listagemCategoria = c.listAll();
	}
}
