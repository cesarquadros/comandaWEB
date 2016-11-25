package br.com.comanda.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.util.ConverteData;

public class ComandaDAOTest {

	@Test
	public void testInsertComanda() throws ParseException, SQLException {

		Comanda comanda = new Comanda();
		comanda.setNome("HAHAHA");
		comanda.setStatus("Aberto");
		comanda.setValorTotal(0);
		comanda.setDataInicio(ConverteData.getDataAtual());
		
		ComandaDAO comandaDAO = new ComandaDAO();
		boolean teste = comandaDAO.insert(comanda);
		Assert.assertEquals(true, teste);
		
	}
	
	@Test
	public void testListAll() throws ParseException, SQLException {
		
		ComandaDAO comandaDAO = new ComandaDAO();
		ArrayList<Comanda> list = (ArrayList<Comanda>) comandaDAO.listAll();
		System.out.println(list.size());
		Assert.assertNull(true);
		
	}
}
