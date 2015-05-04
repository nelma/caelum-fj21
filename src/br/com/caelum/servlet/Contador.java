package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {

	private int contador = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		contador++;
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Contador Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Contador agora �: "+ contador +"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
