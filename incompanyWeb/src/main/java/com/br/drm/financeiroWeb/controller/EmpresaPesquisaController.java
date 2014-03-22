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

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.drm.financeiroWeb.model.Cidade;
import com.br.drm.financeiroWeb.model.Empresa;
import com.br.drm.financeiroWeb.model.Estado;
import com.br.drm.financeiroWeb.service.EmpresaService;
import com.br.drm.financeiroWeb.service.EstadoService;
import com.br.drm.financeiroWeb.util.AppException;

@ManagedBean(name = "empresaPesquisaController")
@ViewScoped
public class EmpresaPesquisaController {

	@EJB
	private EmpresaService empresaService;
	
	@EJB
	private EstadoService estadoService;

	private Empresa empresa;
	
	private List<Empresa> lista;
	
	@PostConstruct
	public void init() throws AppException {
		empresa = new Empresa();
		empresa.setCidade(new Cidade());
		empresa.getCidade().setEstado(new Estado());
	}
	
	public void find() throws AppException{
		this.lista = empresaService.findByParameters(empresa);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getLista() throws AppException {
		return this.lista;
	}
	
	public void setLista(List<Empresa> lista) {
		this.lista = lista;
	}

	public List<Estado> listaEstados() throws AppException {
		return estadoService.findAll();
	}
	
 }