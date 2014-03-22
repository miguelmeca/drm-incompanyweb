package com.br.drm.financeiroWeb.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.proposta_incompany")
public class PropostaIncompany extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String descricao;
	private Date dataSolicitacao;
	private Date dataEnvioProposta;
	private Date dataPrazoRetorno;
	private String fonteSolicitacao;
	private String historico;
	private String acao;
	private String telefoneContato;
	private String emailContato;
	private String responsavelContato;
	private Cliente responsavel;
	private BigDecimal valor;
	private AreaTema areaTema;
	private Palestrante palestrante;
	private Empresa empresa;
	private Status status;

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "seq_proposta_incompany")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "des_proposta_incompany")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String nome) {
		this.descricao = nome;
	}

	@Column(name = "dtc_data_solicitacao")
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	@Column(name = "dtc_data_envio_proposta")
	public Date getDataEnvioProposta() {
		return dataEnvioProposta;
	}

	public void setDataEnvioProposta(Date dataEnvioProposta) {
		this.dataEnvioProposta = dataEnvioProposta;
	}

	@Column(name = "dtc_prazo_retorno")
	public Date getDataPrazoRetorno() {
		return dataPrazoRetorno;
	}
	
	public void setDataPrazoRetorno(Date dataPrazoRetorno) {
		this.dataPrazoRetorno = dataPrazoRetorno;
	}

	@Column(name = "str_fonte_solicitacao")
	public String getFonteSolicitacao() {
		return fonteSolicitacao;
	}

	public void setFonteSolicitacao(String fonteSolicitacao) {
		this.fonteSolicitacao = fonteSolicitacao;
	}

	@Column(name = "str_historico")
	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Column(name = "str_acao")
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@Column(name = "str_telefone_contato")
	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	@Column(name = "str_email_contato")
	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	@Column(name = "str_responsavel_contato")
	public String getResponsavelContato() {
		return responsavelContato;
	}

	public void setResponsavelContato(String responsavelContato) {
		this.responsavelContato = responsavelContato;
	}

	@ManyToOne
	@JoinColumn(name = "seq_responsavel")
	public Cliente getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Cliente responsavel) {
		this.responsavel = responsavel;
	}

	@Column(name = "num_valor_proposta")
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@ManyToOne
	@JoinColumn(name = "seq_area_tema")
	public AreaTema getAreaTema() {
		return areaTema;
	}

	public void setAreaTema(AreaTema areaTema) {
		this.areaTema = areaTema;
	}

	@ManyToOne
	@JoinColumn(name = "seq_palestrante")
	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	@ManyToOne
	@JoinColumn(name = "seq_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManyToOne
	@JoinColumn(name = "seq_status")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}