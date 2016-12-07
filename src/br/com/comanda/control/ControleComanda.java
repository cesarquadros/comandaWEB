package br.com.comanda.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.comanda.entities.Comanda;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.util.ConverteData;

@WebServlet("/ServletComanda")
public class ControleComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleComanda() {
        super();
    }

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		// Variavel responsavel por coletar a action trazida pelo formulriorio e
		// executar o
		// metotodo especifico para seu tratamento

		String acao = request.getParameter("acao");
		
		//responsavel por comprar a action que vem do formulario com as opcoes disponiveis, como abrir comanda, fechar comanda etc...
		if (acao != null) {
			
			//se a acao recebida pelo form for abrircomanda, executa o bloco abaixo
			if(acao.equalsIgnoreCase("abrircomanda")){
				
				//pegando os atributos do form
				String nome = request.getParameter("nome");
				String status = "aberto";
				//pegando data atual
				Date data = ConverteData.getDataAtual();
				float valorTotal = 0;
				
				//instanciando o objeto comanda
				Comanda comanda = new Comanda();
				comanda.setNome(nome);
				comanda.setDataInicio(data);
				comanda.setStatus(status);
				comanda.setValorTotal(valorTotal);
				
				ComandaDAO comandaDAO = new ComandaDAO();
				
				boolean inserirComanda = comandaDAO.insert(comanda);
				
			}
		}
	}

}
