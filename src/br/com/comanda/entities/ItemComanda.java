package br.com.comanda.entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.comanda.persistence.ItemComandaDAO;
import jdk.nashorn.internal.scripts.JO;

public class ItemComanda extends ItemComandaDAO {

	private int codItem;
	private int codProduto;
	private int codComanda;
	
	public ItemComanda(int codProduto, int codComanda){
		this.codProduto = codProduto;
		this.codComanda = codComanda;
	}
	
	public ItemComanda(){
		
	}
	
	public int getCodItem() {
		return codItem;
	}
	
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
	
	public int getCoProduto() {
		return codProduto;
	}
	
	public void setCoProduto(int coProduto) {
		this.codProduto = coProduto;
	}
	
	public int getCodCoamnda() {
		return codComanda;
	}
	
	public void setCodCoamnda(int codComanda) {
		this.codComanda = codComanda;
	}
	
/*	public void excluirItemComanda(JTable tabelaItensComanda){		
		int confirmacao = JOptionPane.showConfirmDialog(null,"Confirmar exclus�o?", "Bar do Bug�o",JOptionPane.YES_NO_OPTION);
		if(confirmacao == JOptionPane.YES_OPTION){									
			codItem = Integer.parseInt((String) tabelaItensComanda.getModel().getValueAt(tabelaItensComanda.getSelectedRow(), 5));
			boolean excluzao = excluirItemComanda(codItem);			
			if(excluzao){
				JOptionPane.showMessageDialog(null, "Item exclu�do", "Bar do Bug�o", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao excluir item", "Bar do Bug�o", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Exclus�o cancelada", "Bar do Bug�o", JOptionPane.INFORMATION_MESSAGE);
		}
	}*/
	
}
