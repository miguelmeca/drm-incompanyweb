package com.br.drm.financeiroWeb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.cliente")
public class Cliente extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private Date dataNascimento;
	private String nome;
	private Cidade cidade;
	private Departamento departamento;
	private Empresa empresa;
	private Status status;
	private Boolean clienteEspecial;
	private Boolean multiplicador;
	private Boolean receberEmail;
	private Boolean receberMalaDireta;
	private String bairro;
	private String celular;
	private String cep;
	private String complemento;
	private String cpf;
	private String emailComercial;
	private String emailPessoal;
	private String endereco;
	private String fax;
	private String historico;
	private String motivoStatus;
	private String observacao;
	private String ramal;
	private String sexo;
	private String telefoneComercial;
	private String telefonePessoal;
	private Cargo cargo;

	@Id
	@Column(name = "seq_cliente")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dtc_data_nascimento")
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "nom_cliente")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	@JoinColumn(name = "seq_departamento")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@ManyToOne
	@JoinColumn(name = "seq_empresa")
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManyToOne
	@JoinColumn(name = "seq_status")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "stn_cliente_especial")
	public Boolean getClienteEspecial() {
		return this.clienteEspecial;
	}

	public void setClienteEspecial(Boolean clienteEspecial) {
		this.clienteEspecial = clienteEspecial;
	}

	@Column(name = "stn_multiplicador")
	public Boolean getMultiplicador() {
		return this.multiplicador;
	}

	public void setMultiplicador(Boolean multiplicador) {
		this.multiplicador = multiplicador;
	}

	@Column(name = "stn_receber_email")
	public Boolean getReceberEmail() {
		return this.receberEmail;
	}

	public void setReceberEmail(Boolean receberEmail) {
		this.receberEmail = receberEmail;
	}

	@Column(name = "stn_receber_mala_direta")
	public Boolean getReceberMalaDireta() {
		return this.receberMalaDireta;
	}

	public void setReceberMalaDireta(Boolean receberMalaDireta) {
		this.receberMalaDireta = receberMalaDireta;
	}

	@Lob
	@Column(name = "str_bairro")
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "str_celular")
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Lob
	@Column(name = "str_cep")
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Lob
	@Column(name = "str_complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "str_cpf")
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "str_email_comercial")
	public String getEmailComercial() {
		return this.emailComercial;
	}

	public void setEmailComercial(String emailComercial) {
		this.emailComercial = emailComercial;
	}

	@Column(name = "str_email_pessoal")
	public String getEmailPessoal() {
		return this.emailPessoal;
	}

	public void setEmailPessoal(String emailPessoal) {
		this.emailPessoal = emailPessoal;
	}

	@Lob
	@Column(name = "str_endereco")
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "str_fax")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "str_historico")
	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Column(name = "str_motivo_status")
	public String getMotivoStatus() {
		return this.motivoStatus;
	}

	public void setMotivoStatus(String motivoStatus) {
		this.motivoStatus = motivoStatus;
	}

	@Column(name = "str_observacao")
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "str_ramal")
	public String getRamal() {
		return this.ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	@Column(name = "str_sexo")
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "str_telefone_comercial")
	public String getTelefoneComercial() {
		return this.telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	@Column(name = "str_telefone_pessoal")
	public String getTelefonePessoal() {
		return this.telefonePessoal;
	}

	public void setTelefonePessoal(String telefonePessoal) {
		this.telefonePessoal = telefonePessoal;
	}

	@ManyToOne
	@JoinColumn(name = "seq_cargo")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}