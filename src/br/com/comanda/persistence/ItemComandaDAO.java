package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.ItemComanda;

public class ItemComandaDAO extends Conexao{

	
	public void inserir(ItemComanda itemComanda) throws SQLException{
		
		String sql = "insert itens_comanda(cod_produto, cod_comanda)values(?,?)";
		
		abreConexao();		
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, itemComanda.getProdutos().getCodProdutos());
		stmt.setInt(2, itemComanda.getComanda().getCodComanda());
		stmt.execute();
		
		stmt.close();
		con.close();
	}
	
	public List<ItemComanda> findById(Integer idComanda) throws SQLException {
		ItemComanda itemComanda;
		List<ItemComanda> listaItem = new ArrayList<ItemComanda>();

			String sql = "select * from ITENS_COMANDA where cod_comanda=?";
			
			abreConexao();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idComanda);
			rs = stmt.executeQuery();
			
			ComandaDAO comanda = new ComandaDAO();
			ProdutosDAO produtosDAO = new ProdutosDAO();
			while(rs.next()){
				itemComanda = new ItemComanda();
				itemComanda.setCodItem(rs.getInt("cod_item"));
				System.out.println(rs.getInt("cod_produto"));
				itemComanda.setProdutos(produtosDAO.findById(rs.getInt("cod_produto")));
				itemComanda.setComanda(comanda.findById(rs.getInt("cod_comanda")));
				listaItem.add(itemComanda);
			}

			stmt.close();
			con.close();
			
		return listaItem;
	}

	public void delete(Integer codItem) throws SQLException{
		
		String sql = "delete from ITENS_COMANDA where COD_ITEM = ?";
		abreConexao();
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, codItem);
		stmt.execute();
		
		stmt.close();
		con.close();
	}	
}
