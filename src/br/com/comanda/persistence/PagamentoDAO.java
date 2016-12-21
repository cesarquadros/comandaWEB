package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comanda.entities.Pagamento;

public class PagamentoDAO extends Conexao {
	
	public List<Pagamento> findByComanda(int codComanda) throws SQLException{
		
		String sql = "select * from PAGAMENTOS where COD_COMANDA = ?";
		abreConexao();
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, codComanda);
		rs = stmt.executeQuery();
		
		List<Pagamento> list = new ArrayList<Pagamento>();
		ComandaDAO comandaDAO = new ComandaDAO();
		while(rs.next()){
			Pagamento pagamento = new Pagamento();
			pagamento.setCodPagamento(rs.getInt("COD_PAGAMENTO"));
			pagamento.setComanda(comandaDAO.findById(rs.getInt("COD_COMANDA")));
			pagamento.setObservacaoPagamento(rs.getString("PAG_OBSERVACOES"));
			pagamento.setValorPagamento(rs.getFloat("VALOR_PAGO"));
			list.add(pagamento);
		}
		
		return list;
	}
	
	public void efetuarPagamento(Pagamento pagamento) throws SQLException{
		
		String sql = "insert pagamentos(cod_comanda,pag_observacoes,valor_pago)values(?,?,?)";
		abreConexao();
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, pagamento.getComanda().getCodComanda());
		stmt.setString(2, pagamento.getObservacaoPagamento());
		stmt.setFloat(3, pagamento.getValorPagamento());
		stmt.execute();
		
		stmt.close();
		con.close();
	}
}
