package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.Comanda;
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

	public Comanda findById(Integer idComanda) throws SQLException {
		Comanda comanda = null;

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

		stmt.close();
		con.close();

		return comanda;
	}

	public void fecharComanda(Comanda comanda) throws SQLException {
		try {
			String sql = "UPDATE COMANDA SET STATUS = ? WHERE COD_COMANDA = ?";
			abreConexao();
			stmt = con.prepareStatement(sql);

			stmt.setString(1, "FECHADA");
			stmt.setInt(2, comanda.getCodComanda());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}

}
