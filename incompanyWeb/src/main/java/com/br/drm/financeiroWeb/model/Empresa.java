package com.br.drm.financeiroWeb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.drm.financeiroWeb.util.AppEntity;

@Entity
@Table(name = "conexxoes.empresa")
public class Empresa extends AppEntity {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private String nomeRazaoSocial;
	private Long numQtdFuncionarios;
	private AreaAtuacao areaAtuacao;
	private Cidade cidade;
	private RamoAtividade ramoAtividade;
	private String bairro;
	private String cep;
	private String cnpj;
	private String complemento;
	private String email;
	private String endereco;
	private String fax;
	private String telefone1;
	private String telefone2;
	private Status status;
	private List<Cliente> clientes;

	@Id
	@Column(name = "seq_empresa")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nom_empresa")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "nom_razao_social")
	public String getNomeRazaoSocial() {
		return this.nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	@Column(name = "num_qtd_funcionarios")
	public Long getNumQtdFuncionarios() {
		return this.numQtdFuncionarios;
	}

	public void setNumQtdFuncionarios(Long numQtdFuncionarios) {
		this.numQtdFuncionarios = numQtdFuncionarios;
	}

	@ManyToOne
	@JoinColumn(name = "seq_area_atuacao")
	public AreaAtuacao getAreaAtuacao() {
		return this.areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
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
	@JoinColumn(name = "seq_ramo_atividade")
	public RamoAtividade getRamoAtividade() {
		return this.ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	@Lob
	@Column(name = "str_bairro")
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Lob
	@Column(name = "str_cep")
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "str_cnpj")
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Lob
	@Column(name = "str_complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "str_email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Column(name = "str_telefone1")
	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	@Column(name = "str_telefone2")
	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	// bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "seq_status")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "empresa")
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}