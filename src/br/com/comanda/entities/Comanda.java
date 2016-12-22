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
	private float valorTotal =0;
	private float valorPago=0;
	private float valorAPagar=0;
	private List<ItemComanda> listItemComanda;
	private List<Pagamento> listPagamento;

	public Comanda() {
		this.listItemComanda = new ArrayList<ItemComanda>();
		this.listPagamento = new ArrayList<Pagamento>();
	}

	public Integer getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Integer codComanda) {
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
		valorTotal = 0;
		for(int i = 0; i < listItemComanda.size(); i++){
			valorTotal += listItemComanda.get(i).getProdutos().getPreco();
		}		
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public float getValorPago() {
		valorPago = 0;
		for(int i=0; i < listPagamento.size(); i++){
			valorPago += listPagamento.get(i).getValorPagamento();
		}
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public float getValorAPagar() {
		
		this.valorAPagar = getValorTotal() - getValorPago();		
		return valorAPagar;
	}

	public void setValorAPagar(float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public List<ItemComanda> getListItemComanda() {
		return listItemComanda;
	}

	public void setListItemComanda(List<ItemComanda> listItemComanda) {
		this.listItemComanda = listItemComanda;

	}

	public List<Pagamento> getListPagamento() {
		return listPagamento;
	}

	public void setListPagamento(List<Pagamento> listPagamento) {
		this.listPagamento = listPagamento;

	}

}
