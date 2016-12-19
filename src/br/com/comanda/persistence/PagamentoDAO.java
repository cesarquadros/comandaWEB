package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.comanda.entities.Pagamento;

public class PagamentoDAO extends Conexao {
	
	public List<Pagamento> findByComanda(int codComanda){
		return null;
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
