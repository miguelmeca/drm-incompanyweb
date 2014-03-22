package com.br.drm.financeiroWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.departamento")
public class Departamento extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;

	@Id
	@Column(name = "seq_departamento")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nom_departamento")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}