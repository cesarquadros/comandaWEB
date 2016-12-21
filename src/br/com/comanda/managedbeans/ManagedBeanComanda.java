package br.com.comanda.managedbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.Comanda;
import br.com.comanda.entities.ItemComanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.ItemComandaDAO;

public class ManagedBeanComanda {

	private List<Comanda> listagemComandas;

	public List<Comanda> getListagemComandas() {

		ComandaDAO comandaDAO = new ComandaDAO();
		listagemComandas = comandaDAO.listAll();

		return listagemComandas;
	}
}
