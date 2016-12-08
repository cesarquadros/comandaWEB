package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comanda.entities.Produto;

public class ProdutosDAO extends Conexao {

	public void insert(Produto produto) throws SQLException {
		
		String sql = "insert PRODUTOS(cod_categoria, descricao, preco, observacoes)values (?,?,?,?)";
		
		con = abreConexao();
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, produto.getCategoria().getCodCategoria());
		stmt.setString(2, produto.getDescricao());
		stmt.setFloat(3, produto.getPreco());
		stmt.setString(4, produto.getObservacoes());
		
		stmt.execute();
		
	}

	public Produto findById(Integer idProduto) {

		Produto produtos = null;
		CategoriaDAO categoria = new CategoriaDAO();

		try {
			String sql = "select * from produtos where cod_produto = ?";

			con = abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idProduto);

			rs = stmt.executeQuery();

			while (rs.next()) {
				produtos = new Produto();
				produtos.setCategoria(categoria.findById(rs.getInt("cod_categoria")));
				produtos.setCodProdutos(rs.getInt("cod_produto"));
				produtos.setDescricao(rs.getString("descricao"));
				produtos.setObservacoes(rs.getString("observacoes"));
				produtos.setPreco(rs.getFloat("preco"));
			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return produtos;
	}

	public List<Produto> listAll() {
		
		List<Produto> listProdutos = new ArrayList<Produto>();
		
		try {			
			Produto produtos = null;	
			CategoriaDAO categoria = new CategoriaDAO();
			
			String sql = "select * from produtos";
			con = abreConexao();
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				produtos = new Produto();
				produtos.setCategoria(categoria.findById(rs.getInt("cod_categoria")));
				produtos.setCodProdutos(rs.getInt("cod_produto"));
				produtos.setDescricao(rs.getString("descricao"));
				produtos.setObservacoes(rs.getString("observacoes"));
				produtos.setPreco(rs.getFloat("preco"));
				listProdutos.add(produtos);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProdutos;
	}
}
