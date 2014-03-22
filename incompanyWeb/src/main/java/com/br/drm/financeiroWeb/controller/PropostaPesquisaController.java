/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.br.drm.financeiroWeb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.drm.financeiroWeb.model.AreaTema;
import com.br.drm.financeiroWeb.model.Cidade;
import com.br.drm.financeiroWeb.model.Cliente;
import com.br.drm.financeiroWeb.model.Empresa;
import com.br.drm.financeiroWeb.model.Estado;
import com.br.drm.financeiroWeb.model.Palestrante;
import com.br.drm.financeiroWeb.model.PropostaIncompany;
import com.br.drm.financeiroWeb.model.Status;
import com.br.drm.financeiroWeb.service.EstadoService;
import com.br.drm.financeiroWeb.service.PropostaIncompanyService;
import com.br.drm.financeiroWeb.service.StatusService;
import com.br.drm.financeiroWeb.util.AppException;

@ManagedBean(name = "propostaPesquisaController")
@ViewScoped
public class PropostaPesquisaController {

	@EJB
	private PropostaIncompanyService propostaIncompanyService;

	@EJB
	private StatusService statusService;
	
	@EJB
	private EstadoService estadoService;

	private List<PropostaIncompany> lista;
	
	private PropostaIncompany propostaIncompany;

	@PostConstruct
	public void init() throws AppException {
		lista = new ArrayList<PropostaIncompany>();
		
		propostaIncompany = new PropostaIncompany();
		propostaIncompany.setEmpresa(new Empresa());
		propostaIncompany.getEmpresa().setCidade(new Cidade());
		propostaIncompany.getEmpresa().getCidade().setEstado(new Estado());
		propostaIncompany.setStatus(new Status());
		propostaIncompany.setResponsavel(new Cliente());
		propostaIncompany.setPalestrante(new Palestrante());
		propostaIncompany.setStatus(new Status());
		propostaIncompany.setAreaTema(new AreaTema());
	}

	public void find() throws AppException {

		lista = propostaIncompanyService.findByParameters(propostaIncompany);
	}

	public List<PropostaIncompany> getLista() {
		return lista;
	}

	public void setLista(List<PropostaIncompany> lista) {
		this.lista = lista;
	}

	public PropostaIncompany getPropostaIncompany() {
		return propostaIncompany;
	}

	public void setPropostaIncompany(PropostaIncompany propostaIncompany) {
		this.propostaIncompany = propostaIncompany;
	}

	public List<Estado> listaEstados() throws AppException {
		return estadoService.findAll();
	}
	
	public List<Status> listaStatus() throws AppException{
		return statusService.findAll();
	}
 }