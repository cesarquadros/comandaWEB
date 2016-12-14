package br.com.comanda.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import br.com.comanda.entities.Comanda;
import br.com.comanda.entities.ItemComanda;
import br.com.comanda.managedbeans.ManagedBeanComanda;
import br.com.comanda.persistence.CategoriaDAO;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.Conexao;
import br.com.comanda.persistence.ItemComandaDAO;
import br.com.comanda.persistence.ProdutosDAO;
import br.com.comanda.util.ConverteData;

public class main {
	
	public static void main(String[] args) throws SQLException, ParseException {
	
/*		Conexao conexao = new Conexao();
		Comanda comanda = new Comanda();
		comanda.setNome("Cesar");
		comanda.setStatus("Aberto");
		comanda.setValorTotal(0);
		comanda.setDataInicio(ConverteData.getDataAtual());
		
		ComandaDAO comandaDAO = new ComandaDAO();
		comandaDAO.insert(comanda);

		ComandaDAO comandaDAO = new ComandaDAO();
		comandaDAO = new ComandaDAO();
		ArrayList<Comanda> list = (ArrayList<Comanda>) comandaDAO.listAll();
		comandaDAO.findById(1000);		

		ItemComandaDAO itemComandaDAO = new ItemComandaDAO();
		itemComandaDAO.findById(1000);
		
		CategoriaDAO c = new CategoriaDAO();
		c.listAll();
		c.findById(1);
		
		ProdutosDAO p = new ProdutosDAO();
		p.findById(117);

		ManagedBeanComanda mb = new ManagedBeanComanda();
		mb.getListagemComandas();
		Comanda comanda = new Comanda();
		comanda.getListItemComanda();
				
		ProdutosDAO p = new ProdutosDAO();
		p.listAll();
		*/
		
		ComandaDAO comandaDAO = new ComandaDAO();
		comandaDAO.comprovante(1000);
	}
}
