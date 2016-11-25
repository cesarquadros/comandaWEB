package br.com.comanda.teste;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.util.ConverteData;

public class ComandaDAOTest {

	@Test
	public void testInsertComanda() throws ParseException, SQLException {

		Comanda comanda = new Comanda();
		comanda.setNome("Cesar");
		comanda.setStatus("Aberto");
		comanda.setValorTotal(0);
		comanda.setData(ConverteData.getDataAtual());
		
		ComandaDAO comandaDAO = new ComandaDAO();
		boolean teste = comandaDAO.insert(comanda);
		
		Assert.assertEquals(true, teste);
		
	}

}
