package br.com.comanda.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.comanda.entities.Pagamento;
import br.com.comanda.persistence.PagamentoDAO;

public class main {
	
	public static void main(String[] args){
	
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
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		try {
			List<Pagamento> p = pagamentoDAO.findByComanda(1000);
			
			for (Pagamento pagamento : p) {
				System.out.println(pagamento.getObservacaoPagamento());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
