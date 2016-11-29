package br.com.comanda.entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.comanda.persistence.ItemComandaDAO;
import jdk.nashorn.internal.scripts.JO;

public class ItemComanda{

	private int codItem;
	private Produtos produtos;
	private Comanda comanda;
	
	public ItemComanda(){
		
	}
	
	public ItemComanda(Produtos produtos, Comanda comanda){
		this.produtos = produtos;
		this.comanda = comanda;
	}
	
	public int getCodItem() {
		return codItem;
	}
	
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	
	
}
