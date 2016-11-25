package br.com.comanda.entities;

import java.util.Date;

public class Comanda {

	private Integer codComanda;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private String status;
	private float valorTotal;
	
	
	
	public Comanda() {

	}

	public Comanda(String nome, Date data, String status, float valorTotal){
		this.nome = nome;
		this.dataInicio = data;
		this.status = status;
		this.valorTotal = valorTotal;
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
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
