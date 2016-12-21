package br.com.comanda.entities;

public class Pagamento{
	
	private Integer codPagamento;
	private Comanda Comanda;
	private Float valorPagamento=(float) 0;
	private String observacaoPagamento ="";
	
	
	
	public Integer getCodPagamento() {
		return codPagamento;
	}

	public void setCodPagamento(Integer codPagamento) {
		this.codPagamento = codPagamento;
	}

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
