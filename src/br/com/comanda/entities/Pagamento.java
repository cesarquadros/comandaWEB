package br.com.comanda.entities;


import br.com.comanda.persistence.ComandaDAO;

public class Pagamento{
	private Comanda Comanda;
	private Float valorPagamento=(float) 0;
	private String observacaoPagamento ="";
	
	
	
	public Pagamento() {
	}

	public Comanda getComanda() {
		return Comanda;
	}
	public void setComanda(Comanda comanda) {
		Comanda = comanda;
	}
	public Float getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(Float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public String getObservacaoPagamento() {
		return observacaoPagamento;
	}
	public void setObservacaoPagamento(String observacaoPagamento) {
		this.observacaoPagamento = observacaoPagamento;
	}
	
	
	
}
