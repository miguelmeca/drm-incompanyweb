package com.br.drm.financeiroWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.estado")
public class Estado extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private Long numeroIbge;
	private String sigla;

	@Id
	@Column(name = "seq_estado")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nom_estado")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "num_ibge")
	public Long getNumeroIbge() {
		return this.numeroIbge;
	}

	public void setNumeroIbge(Long numeroIbge) {
		this.numeroIbge = numeroIbge;
	}

	@Column(name = "sig_estado")
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}