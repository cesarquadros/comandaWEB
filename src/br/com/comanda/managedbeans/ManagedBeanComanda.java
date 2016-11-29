package br.com.comanda.managedbeans;

import java.util.List;
import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;

public class ManagedBeanComanda {
	private List<Comanda> listagemComandas;
	
	public List<Comanda> getListagemComandas(){
		
		ComandaDAO comandaDAO = new ComandaDAO();
		listagemComandas = comandaDAO.listAll();
		return listagemComandas;
	}
}
