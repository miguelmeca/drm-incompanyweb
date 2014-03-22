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

import com.br.drm.financeiroWeb.model.AreaTema;
import com.br.drm.financeiroWeb.service.AreaTemaService;
import com.br.drm.financeiroWeb.util.AppException;

@ManagedBean(name = "areaTemaPesquisaController")
@ViewScoped
public class AreaTemaPesquisaController {

	@EJB
	private AreaTemaService areaTemaService;
	
	private AreaTema areaTema;
	
	private List<AreaTema> lista;
	
	@PostConstruct
	public void init() throws AppException {
		areaTema = new AreaTema();
	}
	
	public void find() throws AppException{
		this.lista = areaTemaService.findByParameters(areaTema);
	}

	public AreaTema getAreaTema() {
		return areaTema;
	}

	public void setAreaTema(AreaTema areaTema) {
		this.areaTema = areaTema;
	}

	public List<AreaTema> getLista() throws AppException {
		return this.lista;
	}
	
	public void setLista(List<AreaTema> lista) {
		this.lista = lista;
	}

 }