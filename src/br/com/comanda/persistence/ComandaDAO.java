package br.com.comanda.persistence;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.comanda.entities.Comanda;
import br.com.comanda.entities.Pagamento;
import br.com.comanda.util.ConverteData;

public class ComandaDAO extends Conexao {

	public boolean insert(Comanda comanda) {
		String sql = "insert comanda (nome_cliente, data_inicio, status, valor_total) values (?,?,?,?)";
		try {
			abreConexao();

			stmt = con.prepareStatement(sql);

			stmt.setString(1, comanda.getNome());
			stmt.setString(2, ConverteData.dateToString(comanda.getDataInicio()));
			stmt.setString(3, comanda.getStatus());
			stmt.setFloat(4, comanda.getValorTotal());

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

	public Comanda findById(Integer id){
		Comanda comanda = null;
		try {
			String sql = "select * from comanda where cod_comanda = ?";
			
			abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();

			while(rs.next()){
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
		}finally {
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

	/*
	public static JTable getNewRenderedTable(final JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

				String status = (String) table.getModel().getValueAt(row, 2);

				if (status.equalsIgnoreCase("ABERTO")) {
					setForeground(new Color(34, 139, 34));
				} else if (status.equalsIgnoreCase("FECHADO")) {
					setForeground(Color.red);
				} else if (status.equalsIgnoreCase("PENDENTE")) {
					setForeground(Color.orange);
				}

				return this;
			}
		});
		return table;
	}

	public float valorAPagar(int codComanda) throws SQLException { float
	  valorApagar = 0; try { con = abreConexao(); stmt = con.createStatement();
	  sql = "SELECT VALOR_PAGO FROM PAGAMENTOS WHERE COD_COMANDA ='" +
	  codComanda + "'"; rs = stmt.executeQuery(sql);
	  
	  while (rs.next()) { valorApagar += rs.getFloat(1); } con.close(); return
	  valorApagar; } catch (SQLException e) { // TODO Auto-generated catch
	  block e.printStackTrace(); } con.close(); return valorApagar; }

	public boolean efetuarPagamento(Pagamento pagamento) throws SQLException {

		try {
			con = abreConexao();
			stmt = con.createStatement();

			sql = "INSERT INTO PAGAMENTOS(COD_COMANDA, PAG_OBSERVACOES, VALOR_PAGO)" + "VALUES('"
					+ pagamento.getCodComandao() + "','" + pagamento.getObservacaoPagamento() + "','"
					+ pagamento.getValorPagamento() + "')";
			stmt.executeUpdate(sql);

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			con.close();
			return false;
		}
		con.close();
		return true;
	}

	public ArrayList<Pagamento> historicoPagamentos(int codComanda, JTextArea
	  textComprovante) throws SQLException{ ArrayList<Pagamento> arrayPagamento
	  = new ArrayList<Pagamento>();
	  
	  try { con = abreConexao(); stmt = con.createStatement();
	  
	  sql =
	  "SELECT PAG_OBSERVACOES, VALOR_PAGO FROM PAGAMENTOS WHERE COD_COMANDA = '"
	  +codComanda+"'"; rs = stmt.executeQuery(sql);
	  
	  while(rs.next()){ Pagamento pagamento = new Pagamento();
	  pagamento.setObservacaoPagamento(rs.getString(1));
	  pagamento.setValorPagamento(rs.getFloat(2));
	  arrayPagamento.add(pagamento); } } catch (SQLException e) { // TODO
	  Auto-generated catch block e.printStackTrace(); con.close(); }
	  con.close(); return arrayPagamento; }

	public void comprovante(JTextArea textComprovante, int codComanda) throws SQLException {

		try {
			con = abreConexao();
			stmt = con.createStatement();

			sql = "SELECT" + " P.DESCRICAO,P.PRECO, COUNT(*) AS CONT" + " FROM "
					+ " ITENS_COMANDA IC, PRODUTOS P, CATEGORIAS CA" + " WHERE" + " P.COD_PRODUTO = IC.COD_PRODUTO"
					+ " AND" + " P.COD_CATEGORIA = CA.COD_CATEGORIA" + " AND" + " IC.COD_COMANDA = '" + codComanda + "'"
					+ " GROUP BY" + " P.DESCRICAO, P.PRECO";
			rs = stmt.executeQuery(sql);

			cabecalhoComprovante(textComprovante);

			while (rs.next()) {

				textComprovante.setText(textComprovante.getText() + " " + rs.getString(1) + "   x" + rs.getInt(3)
						+ "   R$" + df.format(rs.getFloat(2) * rs.getInt(3)) + System.lineSeparator());
			}

			textComprovante.setText(textComprovante.getText() + System.lineSeparator());
			textComprovante
					.setText(textComprovante.getText() + "---- HISTÓRICO DE PAGAMENTOS ----" + System.lineSeparator());
			textComprovante.setText(textComprovante.getText() + System.lineSeparator());

			ArrayList<Pagamento> arrayPag = new ArrayList<Pagamento>();
			arrayPag = historicoPagamentos(codComanda, textComprovante);

			for (int i = 0; i < arrayPag.size(); i++) {
				textComprovante.setText(textComprovante.getText() + " " + arrayPag.get(i).getObservacaoPagamento()
						+ " --- R$" + df.format(arrayPag.get(i).getValorPagamento()) + System.lineSeparator());
			}

			textComprovante.setText(textComprovante.getText() + " ------------------------------------------- "
					+ System.lineSeparator());
			textComprovante.setText(textComprovante.getText() + System.lineSeparator());

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			con.close();
		}
		con.close();
	}

	public void cabecalhoComprovante(JTextArea textComprovante) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		String dataAtual = dateFormat.format(new Date());
		textComprovante.setText(null);
		textComprovante.setText(textComprovante.getText() + "               BAR DO BUGÃO" + System.lineSeparator());
		textComprovante.setText(textComprovante.getText() + "         " + dataAtual + System.lineSeparator());
		textComprovante.setText(textComprovante.getText() + "               CUPOM FISCAL" + System.lineSeparator());
		textComprovante.setText(textComprovante.getText() + System.lineSeparator());
		textComprovante
				.setText(textComprovante.getText() + " -------------  CONSUMO  -------------" + System.lineSeparator());
		textComprovante.setText(textComprovante.getText() + System.lineSeparator());

	}
	*/
}

