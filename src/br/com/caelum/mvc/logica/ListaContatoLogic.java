package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(connection).getLista();
		request.setAttribute("contatos", contatos);
		
		return "WEB-INF/jsp/lista-contatos.jsp";
	}
}
