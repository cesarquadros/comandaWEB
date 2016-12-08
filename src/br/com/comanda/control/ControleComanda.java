package br.com.comanda.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.comanda.entities.Categoria;
import br.com.comanda.entities.Comanda;
import br.com.comanda.entities.ItemComanda;
import br.com.comanda.entities.Produto;
import br.com.comanda.persistence.CategoriaDAO;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.ItemComandaDAO;
import br.com.comanda.persistence.ProdutosDAO;
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

	protected void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		// Variavel responsavel por coletar a action trazida pelo formulriorio e
		// executar o
		// metotodo especifico para seu tratamento

		String acao = request.getParameter("acao");

		// responsavel por comprar a action que vem do formulario com as opcoes
		// disponiveis, como abrir comanda, fechar comanda etc...
		if (acao != null) {

			// se a acao recebida pelo form for abrircomanda, executa o bloco
			// abaixo
			if (acao.equalsIgnoreCase("abrircomanda")) {

				try {
					// pegando os atributos do form
					String nome = request.getParameter("nome");
					String status = "aberto";
					// pegando data atual
					Date data = ConverteData.getDataAtual();
					float valorTotal = 0;

					// instanciando o objeto comanda
					Comanda comanda = new Comanda();
					comanda.setNome(nome);
					comanda.setDataInicio(data);
					comanda.setStatus(status);
					comanda.setValorTotal(valorTotal);

					ComandaDAO comandaDAO = new ComandaDAO();

					request.setAttribute("mensagem", "Comanda aberta");

					comandaDAO.insert(comanda);
				} catch (SQLException e) {
					String erro = e.getMessage();
					request.setAttribute("mensagem", "OPS! Ocorreu um erro: " + erro);
				} finally {
					request.getRequestDispatcher("produtos.jsp").forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("cadastrarproduto")) {

				try {
					Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
					String descricao = request.getParameter("descricao");
					Float preco = Float.valueOf(request.getParameter("preco").replaceAll(",", "."));
					String observacoes = request.getParameter("observacoes");

					CategoriaDAO categoriaDAO = new CategoriaDAO();
					Categoria categoria = new Categoria();

					categoria = categoriaDAO.findById(idCategoria);
					Produto produto = new Produto();
					produto.setCategoria(categoria);
					produto.setDescricao(descricao);
					produto.setPreco(preco);
					produto.setObservacoes(observacoes);

					ProdutosDAO produtosDAO = new ProdutosDAO();
					produtosDAO.insert(produto);

					request.setAttribute("mensagem", "Produto cadastrado");
				} catch (SQLException e) {
					String erro = e.getMessage();
					request.setAttribute("mensagem2", "OPS! Ocorreu um erro: " + erro);
				} finally {
					request.getRequestDispatcher("produtos.jsp").forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("detalhescomanda")) {				

				try {
					Integer idComanda = Integer.parseInt(request.getParameter("id"));

					ItemComandaDAO itemComandaDAO = new ItemComandaDAO();

					List<ItemComanda> lista = itemComandaDAO.findById(idComanda);
					
					request.setAttribute("listaItens", lista);
					request.setAttribute("id", idComanda);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					request.getRequestDispatcher("detalhecomanda.jsp").forward(request, response);
				}

			} else if(acao.equalsIgnoreCase("adicionaritem")){
				
				String acao2 = request.getParameter("action=2");
				Integer idComanda = Integer.parseInt(request.getParameter("id"));
								
				if(acao2.equalsIgnoreCase("1") || !acao2.equals(null)){
					request.setAttribute("id", idComanda);
					request.getRequestDispatcher("incluirprodutos.jsp").forward(request, response);
				}else{
					Integer codProduto = Integer.parseInt(request.getParameter("codProduto"));
				}
				
			}
		}
	}

}
