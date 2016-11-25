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
}
