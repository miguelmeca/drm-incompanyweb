package com.br.drm.financeiroWeb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.drm.financeiroWeb.model.Usuario;

@WebFilter(filterName = "SecurityFilter", urlPatterns = { "*.jsf" })
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		Usuario usuario = (Usuario) ((HttpServletRequest) servletRequest).getSession().getAttribute("usuario");

		if (usuario == null && !((HttpServletRequest) servletRequest).getRequestURI().endsWith("login.jsf")) {
			String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
			((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/login.jsf");
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
