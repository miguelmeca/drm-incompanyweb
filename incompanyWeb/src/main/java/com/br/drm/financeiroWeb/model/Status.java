package com.br.drm.financeiroWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.status")
public class Status extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private String cor;

	@Id
	@Column(name = "seq_status")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nom_status")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "str_cor")
	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}