package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.Comanda;
import br.com.comanda.entities.Comprovante;
import br.com.comanda.util.ConverteData;

public class ComandaDAO extends Conexao {

	public void insert(Comanda comanda) throws SQLException {
		String sql = "insert comanda (nome_cliente, data_inicio, status, valor_total) values (?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(sql);

		stmt.setString(1, comanda.getNome());
		stmt.setString(2, ConverteData.dateToString(comanda.getDataInicio()));
		stmt.setString(3, comanda.getStatus());
		stmt.setFloat(4, comanda.getValorTotal());

		stmt.execute();
	}

	public List<Comanda> listAll() {
		List<Comanda> listaComanda = new ArrayList<Comanda>();
		try {
			String sql = "select * from comanda";
			// String sql = "SELECT COD_COMANDA, NOME_CLIENTE, STATUS,
			// CONVERT(VARCHAR(10),DATA_INICIO,103) FROM COMANDA WHERE STATUS =
			// 'ABERTO'";
			abreConexao();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Comanda comanda = new Comanda();
				comanda.setCodComanda(rs.getInt("cod_comanda"));
				comanda.setNome(rs.getString("nome_cliente"));
				comanda.setDataInicio(rs.getDate("data_inicio"));
				comanda.setDataFim(rs.getDate("data_final"));
				comanda.setStatus(rs.getString("status"));
				comanda.setValorTotal(rs.getFloat("valor_total"));
				listaComanda.add(comanda);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaComanda;
	}

	public Comanda findById(Integer idComanda) {
		Comanda comanda = null;
		try {
			String sql = "select * from comanda where cod_comanda = ?";

			abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idComanda);

			rs = stmt.executeQuery();

			while (rs.next()) {
				comanda = new Comanda();
				comanda.setCodComanda(rs.getInt("cod_comanda"));
				comanda.setNome(rs.getString("nome_cliente"));
				comanda.setDataInicio(rs.getDate("data_inicio"));
				comanda.setDataFim(rs.getDate("data_final"));
				comanda.setStatus(rs.getString("status"));
				comanda.setValorTotal(rs.getFloat("valor_total"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return comanda;
	}

	public void fecharComanda(Comanda comanda) throws SQLException {
		try {
			String sql = "UPDATE COMANDA SET STATUS = ? WHERE COD_COMANDA = ?";
			abreConexao();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, comanda.getCodComanda());
			stmt.setString(2, "fechado");
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}

	public List<Comprovante> comprovante(int codComanda) throws SQLException {

		List<Comprovante> listComprovante = new ArrayList<Comprovante>();

		String sql = "SELECT P.COD_PRODUTO, P.DESCRICAO, CA.CATEGORIA, P.OBSERVACOES,P.PRECO, COUNT(*) AS CONT FROM ITENS_COMANDA IC, PRODUTOS P, CATEGORIAS CA WHERE P.COD_PRODUTO = IC.COD_PRODUTO AND P.COD_CATEGORIA = CA.COD_CATEGORIA AND IC.COD_COMANDA = ? GROUP BY P.DESCRICAO, P.PRECO, CA.CATEGORIA, P.OBSERVACOES, P.COD_PRODUTO";

		abreConexao();
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, codComanda);
		rs = stmt.executeQuery();
		Comprovante comprovante;
		while (rs.next()) {
			comprovante = new Comprovante();
			
			comprovante.setProduto(rs.getInt(1));
			comprovante.setDescricao(rs.getString(2));
			comprovante.setCategoria(rs.getString(3));
			comprovante.setObservacoes(rs.getString(4));
			comprovante.setPreco(rs.getFloat(5));
			comprovante.setQuantidade(rs.getInt(6));
			listComprovante.add(comprovante);
		}
		con.close();
		stmt.close();
		return listComprovante;
	}

	/*
	 * public void cabecalhoComprovante(JTextArea textComprovante) {
	 * SimpleDateFormat dateFormat = new SimpleDateFormat(
	 * "dd/MM/yyyy - HH:mm:ss"); String dataAtual = dateFormat.format(new
	 * Date()); textComprovante.setText(null);
	 * textComprovante.setText(textComprovante.getText() +
	 * "               BAR DO BUGÃO" + System.lineSeparator());
	 * textComprovante.setText(textComprovante.getText() + "         " +
	 * dataAtual + System.lineSeparator());
	 * textComprovante.setText(textComprovante.getText() +
	 * "               CUPOM FISCAL" + System.lineSeparator());
	 * textComprovante.setText(textComprovante.getText() +
	 * System.lineSeparator()); textComprovante
	 * .setText(textComprovante.getText() +
	 * " -------------  CONSUMO  -------------" + System.lineSeparator());
	 * textComprovante.setText(textComprovante.getText() +
	 * System.lineSeparator());
	 * 
	 * }
	 * 
	 * 
	 * public ArrayList<Pagamento> historicoPagamentos(int codComanda, JTextArea
	 * textComprovante) throws SQLException{ ArrayList<Pagamento> arrayPagamento
	 * = new ArrayList<Pagamento>();
	 * 
	 * try { con = abreConexao(); stmt = con.createStatement();
	 * 
	 * sql =
	 * "SELECT PAG_OBSERVACOES, VALOR_PAGO FROM PAGAMENTOS WHERE COD_COMANDA = '"
	 * +codComanda+"'"; rs = stmt.executeQuery(sql);
	 * 
	 * while(rs.next()){ Pagamento pagamento = new Pagamento();
	 * pagamento.setObservacaoPagamento(rs.getString(1));
	 * pagamento.setValorPagamento(rs.getFloat(2));
	 * arrayPagamento.add(pagamento); } } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); con.close(); }
	 * con.close(); return arrayPagamento; }
	 */
}
