package br.com.comanda.entities;


public class Produto {

	private int codProdutos;
	private Categoria categoria;
	private String descricao;
	private float preco;
	private String observacoes;
	
	public Produto (){
		
	}
	
	public Produto(Categoria categoria, String descricao, float preco, String observacoes){
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
		this.observacoes = observacoes;
	}
	
	public int getCodProdutos() {
		return codProdutos;
	}
	
	public void setCodProdutos(int codProdutos) {
		this.codProdutos = codProdutos;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
