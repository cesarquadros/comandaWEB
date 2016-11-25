package br.com.comanda.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.Conexao;
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
*/
		ComandaDAO comandaDAO = new ComandaDAO();
		comandaDAO = new ComandaDAO();
		ArrayList<Comanda> list = (ArrayList<Comanda>) comandaDAO.listAll();
		comandaDAO.findById(1000);		
		
		
	}
}
