package br.com.comanda.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.comanda.entities.Produtos;



public class ProdutosDAO extends Conexao{
	private Connection con;
	private Statement statement;


	private DecimalFormat df = new DecimalFormat("0.00");
	
	
	public boolean inserirProduto(Produtos produto){

		return false;
	}
	
	public Produtos findById(Integer idProduto){
		
		Produtos produtos = null;			
		try {
			String sql = "select * from produtos where cod_produto = ?";
			
			con = abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idProduto);
			
			rs = stmt.executeQuery();

			while(rs.next()){
				produtos = new Produtos();
				//produtos.setCategoria(categoria);
				produtos.setCodProdutos(rs.getInt("cod_produto"));
				produtos.setDescricao(rs.getString("descricao"));
				produtos.setObservacoes(rs.getString("observacoes"));
				produtos.setPreco(rs.getFloat("preco"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return produtos;
	}
}
