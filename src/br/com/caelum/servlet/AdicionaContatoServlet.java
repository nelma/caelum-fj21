package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		//pegando os params do request
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		//fazendo a versao data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (Exception e) {
			out.println("Erro de conversao da data.");
			return;
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Salva cnntato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//mprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}
