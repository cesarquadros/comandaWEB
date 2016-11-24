package br.com.comanda.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComanda
 */
@WebServlet("/ServletComanda")
public class ServletComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletComanda() {
        super();
    }

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
	}

}
