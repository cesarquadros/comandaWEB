package br.com.comanda.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda {

	private Integer codComanda;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private String status;
	private float valorTotal;
	private List<ItemComanda> listItemComanda;
	
	
	
	public Comanda() {
		this.listItemComanda = new ArrayList<ItemComanda>(); 
	}

	public Comanda(String nome, Date data, String status, float valorTotal){
		this.nome = nome;
		this.dataInicio = data;
		this.status = status;
		this.valorTotal = valorTotal;
	}
	
	
	
	public List<ItemComanda> getListItemComanda() {
		return listItemComanda;
	}

	public void setListItemComanda(List<ItemComanda> listItemComanda) {
		this.listItemComanda = listItemComanda;
	}

	public void addItem(ItemComanda item){
		listItemComanda.add(item);
	}
	
	public int getCodComanda() {
		return codComanda;
	}
	
	public void setCodComanda(int codComanda) {
		this.codComanda = codComanda;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public float getValorTotal() {
		for (int i = 0; i < listItemComanda.size(); i++) {
			valorTotal += listItemComanda.get(i).getProdutos().getPreco();
		}
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
