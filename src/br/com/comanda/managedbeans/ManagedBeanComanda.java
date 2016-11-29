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

		ItemComandaDAO itemComandaDAO = new ItemComandaDAO();
		ComandaDAO comandaDAO = new ComandaDAO();
		listagemComandas = comandaDAO.listAll();

		for (int i = 0; i < listagemComandas.size(); i++) {
			try {
				List<ItemComanda> listItem = new ArrayList<ItemComanda>();
				listItem = itemComandaDAO.findById(listagemComandas.get(i).getCodComanda());
				for (int j = 0; j < listItem.size(); j++) {
					listagemComandas.get(i).addItem(listItem.get(j));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listagemComandas;
	}
}
