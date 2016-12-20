package br.com.comanda.entities;

public class Comprovante {

	private Produto produto;
	private Integer quantidade;
	private Float valorTotal;
	
	public Comprovante(){
	}	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
}
