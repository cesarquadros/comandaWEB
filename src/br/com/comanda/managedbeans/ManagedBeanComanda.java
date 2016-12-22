package br.com.comanda.managedbeans;

import java.sql.SQLException;
import java.util.List;
import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.ItemComandaDAO;
import br.com.comanda.persistence.PagamentoDAO;

public class ManagedBeanComanda {

	private List<Comanda> listagemComandas;

	public List<Comanda> getListagemComandas() throws SQLException {

		ComandaDAO comandaDAO = new ComandaDAO();
		ItemComandaDAO itemComandaDAO = new ItemComandaDAO();
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		
		
		listagemComandas = comandaDAO.listAll();
		
		for (Comanda comanda : listagemComandas) {
			comanda.setListItemComanda(itemComandaDAO.findById(comanda.getCodComanda()));
			comanda.setListPagamento(pagamentoDAO.findByComanda(comanda.getCodComanda()));
		}

		return listagemComandas;
	}
}
