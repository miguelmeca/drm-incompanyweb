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

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.br.drm.financeiroWeb.model.Usuario;
import com.br.drm.financeiroWeb.service.UsuarioService;
import com.br.drm.financeiroWeb.util.AppException;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController {

	@EJB
	private UsuarioService usuarioService;

	@Inject
	private FacesContext facesContext;

	private Usuario usuario;

	@PostConstruct
	public void init() throws AppException {
		usuario = new Usuario();
	}

	public String login() throws AppException {

		usuario = usuarioService.login(usuario);

		if (usuario != null) {

			((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("usuario", usuario);

			return "index?faces-redirect=true";
		}

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Usuário ou senha inválidos."));

		return "login";
	}

	public String logout() throws AppException {
		
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("usuario", null);

		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}