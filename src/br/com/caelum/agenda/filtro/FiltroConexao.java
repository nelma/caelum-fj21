package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

import com.mysql.jdbc.Connection;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		try {
			//abre a conexao
			Connection connection = (Connection) new ConnectionFactory().getConnection();
			
			request.setAttribute("conexao", connection);
			
			//indica que o request deve seguir
			chain.doFilter(request, response);
			
			//fecha conexao
			connection.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
