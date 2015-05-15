package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import com.mysql.jdbc.Connection;

public class AtualizaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Contato contato = new Contato();
		
		//pegando os params do request
		if(request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			contato.setId(id);
		}
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		//fazendo a versao data
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (Exception e) {
			System.out.println("Erro de conversao da data." + e);
			System.out.println(dataEmTexto);
			return dataEmTexto;
		}
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Salva cnntato
		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		
		if(request.getParameter("id") != null) {
			System.out.println("Atualizando contato...");
			dao.atualiza(contato);
		} else {
			System.out.println("Inserindo contato...");
			dao.adiciona(contato);
		}
		
		return "mvc?logica=ListaContatoLogic";
	}
}
