package com.br.drm.financeiroWeb.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.evento")
public class Evento extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String descricao;
	private Date dataCadastro;
	private Date dataFim;
	private Date dataInicio;
	private Date dataUltimaAlteracao;
	private String nome;
	private Long edicao;
	private Long quantidadeParticipantes;
	private BigDecimal valorTreinamento;
	private AreaTema areaTema;
	private Cidade cidade;
	private Status status;
	private TipoEvento tipoEvento;

	@Id
	@Column(name = "seq_evento")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "des_evento")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtc_data_cadastro")
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dtc_data_fim")
	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dtc_data_inicio")
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtc_data_ultima_alteracao")
	public Date getDataUltimaAlteracao() {
		return this.dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	@Column(name = "nom_evento")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "num_edicao")
	public Long getEdicao() {
		return this.edicao;
	}

	public void setEdicao(Long edicao) {
		this.edicao = edicao;
	}

	@Column(name = "num_qtd_participantes")
	public Long getQuantidadeParticipantes() {
		return this.quantidadeParticipantes;
	}

	public void setQuantidadeParticipantes(Long quantidadeParticipantes) {
		this.quantidadeParticipantes = quantidadeParticipantes;
	}

	@Column(name = "num_valor_treinamento")
	public BigDecimal getValorTreinamento() {
		return this.valorTreinamento;
	}

	public void setValorTreinamento(BigDecimal valorTreinamento) {
		this.valorTreinamento = valorTreinamento;
	}

	@ManyToOne
	@JoinColumn(name = "seq_area_tema")
	public AreaTema getAreaTema() {
		return this.areaTema;
	}

	public void setAreaTema(AreaTema areaTema) {
		this.areaTema = areaTema;
	}

	@ManyToOne
	@JoinColumn(name = "seq_cidade")
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@ManyToOne
	@JoinColumn(name = "seq_status")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "seq_tipo_evento")
	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}