package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.Categoria;

public class CategoriaDAO extends Conexao {

	public List<Categoria> listAll() {
		List<Categoria> listCategoria = new ArrayList<Categoria>();
		Categoria categoria = null;
		try {
			con = abreConexao();


			String sql = "SELECT * FROM CATEGORIAS";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setCodCategoria(rs.getInt("cod_categoria"));
				categoria.setCategoria(rs.getString("categoria"));
				listCategoria.add(categoria);
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
		return listCategoria;
	}
	
	public Categoria findById(Integer idCategoria){
		
		Categoria categoria = null;
		String sql = "select * from categorias where cod_categoria=?";
		
		try {
			con = abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idCategoria);
						
			rs = stmt.executeQuery();
			
			while(rs.next()){
				categoria = new Categoria();
				categoria.setCodCategoria(rs.getInt("cod_categoria"));
				categoria.setCategoria(rs.getString("categoria"));
				
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
		return categoria;
	}

}
