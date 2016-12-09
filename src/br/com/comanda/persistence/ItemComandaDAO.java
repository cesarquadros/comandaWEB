package br.com.comanda.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.comanda.entities.ItemComanda;

public class ItemComandaDAO extends Conexao{


	
	public boolean excluirItemComanda(int codItem){
		try {
			con = abreConexao();
			//stmt = con.prepareStatement();
			
			String sql = "DELETE FROM ITENS_COMANDA WHERE COD_ITEM = '"+codItem+"'";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<ItemComanda> findById(Integer idComanda) throws SQLException {
		ItemComanda itemComanda;
		List<ItemComanda> listaItem = new ArrayList<ItemComanda>();
		try {
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

			con.close();

			//txtValorTotal.setText("R$" + df.format(valorTotal));
		} catch (SQLException e) {
			con.close();
			System.out.println(e);
			e.printStackTrace();
		}
		con.close();
		return listaItem;
	}
	
	public void inserir(ItemComanda itemComanda) throws SQLException{
		
		String sql = "insert itens_comanda(cod_produto, cod_comanda)values(?,?)";
		abreConexao();
		
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, itemComanda.getProdutos().getCodProdutos());
		stmt.setInt(2, itemComanda.getComanda().getCodComanda());
		stmt.executeQuery();
	}
}
