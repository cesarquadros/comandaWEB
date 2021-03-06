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
import br.com.comanda.entities.Pagamento;
import br.com.comanda.entities.Produto;
import br.com.comanda.persistence.CategoriaDAO;
import br.com.comanda.persistence.ComandaDAO;
import br.com.comanda.persistence.ItemComandaDAO;
import br.com.comanda.persistence.PagamentoDAO;
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
					String status = "ABERTO";
					// pegando data atual
					Date data = ConverteData.getDataAtual();

					// instanciando o objeto comanda
					Comanda comanda = new Comanda();
					comanda.setNome(nome);
					comanda.setDataInicio(data);
					comanda.setStatus(status);

					ComandaDAO comandaDAO = new ComandaDAO();

					request.setAttribute("mensagem", "Comanda aberta");

					comandaDAO.insert(comanda);
				} catch (SQLException e) {
					String erro = e.getMessage();
					request.setAttribute("mensagem", "OPS! Ocorreu um erro: " + erro);
				} finally {
					request.getRequestDispatcher("comandas.jsp").forward(request, response);
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
					ComandaDAO comandaDAO = new ComandaDAO();
					PagamentoDAO pagamentoDAO = new PagamentoDAO();
					ItemComandaDAO itemComandaDAO = new ItemComandaDAO();

					Comanda comanda = comandaDAO.findById(idComanda);
					List<Pagamento> listPagamentos = pagamentoDAO.findByComanda(idComanda);
					List<ItemComanda> listItemComanda = itemComandaDAO.findById(idComanda);

					comanda.setListPagamento(listPagamentos);
					comanda.setListItemComanda(listItemComanda);

					request.setAttribute("id", idComanda);
					request.setAttribute("comanda", comanda);
				} catch (SQLException e) {

				} finally {
					request.getRequestDispatcher("detalhecomanda.jsp").forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("adicionaritem")) {

				Integer idComanda = Integer.parseInt(request.getParameter("id"));
				Integer qtd = Integer.parseInt(request.getParameter("qtd"));
				Integer codProduto = Integer.parseInt(request.getParameter("produto"));
				Integer teste = Integer.parseInt(request.getParameter("teste"));
				String pagina = "";

				try {

					ItemComanda itemComanda = new ItemComanda();

					ComandaDAO comandaDAO = new ComandaDAO();
					ProdutosDAO produtosDAO = new ProdutosDAO();
					ItemComandaDAO itemComandaDAO = new ItemComandaDAO();

					Comanda comanda = comandaDAO.findById(idComanda);
					Produto produto = produtosDAO.findById(codProduto);

					itemComanda.setComanda(comanda);
					itemComanda.setProdutos(produto);

					for (int i = 0; i < qtd; i++) {

						itemComandaDAO.inserir(itemComanda);
					}

					if (teste > 1) {
						request.setAttribute("mensagem", "Produto adicionado a comanda " + idComanda);
						request.setAttribute("id", idComanda);
						pagina = "incluirprodutos.jsp";
					} else {

						PagamentoDAO pagamentoDAO = new PagamentoDAO();
						List<Pagamento> listPagamentos = pagamentoDAO.findByComanda(idComanda);
						List<ItemComanda> listItemComanda = itemComandaDAO.findById(idComanda);

						comanda.setListPagamento(listPagamentos);
						comanda.setListItemComanda(listItemComanda);

						request.setAttribute("comanda", comanda);

						request.setAttribute("id", idComanda);
						pagina = "detalhecomanda.jsp";
					}

				} catch (SQLException e) {
					request.setAttribute("mensagem", "OPS! Ocorreu um erro");
					request.setAttribute("id", idComanda);
				} finally {
					request.getRequestDispatcher(pagina).forward(request, response);
				}

			} else if (acao.equalsIgnoreCase("paginaitens")) {

				Integer idComanda = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id", idComanda);
				request.getRequestDispatcher("incluirprodutos.jsp").forward(request, response);

			} else if (acao.equalsIgnoreCase("efetuarpagamento")) {

				try {
					Integer idComanda = Integer.parseInt(request.getParameter("id"));
					Float valor = Float.valueOf(request.getParameter("valor").replaceAll(",", "."));
					String observacoes = request.getParameter("obeservacao");
					
					ComandaDAO comandaDAO = new ComandaDAO();
					Comanda comanda = comandaDAO.findById(idComanda);
					Pagamento pagamento = new Pagamento();
					ItemComandaDAO itemComandaDAO = new ItemComandaDAO();
					PagamentoDAO pagamentoDAO = new PagamentoDAO();
					List<Pagamento> listPagamentos = pagamentoDAO.findByComanda(idComanda);
					List<ItemComanda> listItemComanda = itemComandaDAO.findById(idComanda);
					comanda.setListPagamento(listPagamentos);
					comanda.setListItemComanda(listItemComanda);
					
					
					if(comanda.getValorAPagar() >= valor){						
						pagamento.setComanda(comandaDAO.findById(idComanda));
						pagamento.setValorPagamento(valor);
						pagamento.setObservacaoPagamento(observacoes);					
						pagamentoDAO.efetuarPagamento(pagamento);
						
						request.setAttribute("mensagem", "Pagamento efetuado");
						request.setAttribute("teste", "1");
						listPagamentos = pagamentoDAO.findByComanda(idComanda);
						listItemComanda = itemComandaDAO.findById(idComanda);
						comanda.setListPagamento(listPagamentos);
						comanda.setListItemComanda(listItemComanda);
						
					} else {
						request.setAttribute("mensagem", "Valor � maior que o total da comanda");
						request.setAttribute("teste", "0");
					}
					
					request.setAttribute("comanda", comanda);
					request.setAttribute("id", idComanda);

				} catch (Exception e) {
					request.setAttribute("mensagem", e);					
					
				} finally {
					request.getRequestDispatcher("detalhecomanda.jsp").forward(request, response);
				}
			} else if (acao.equalsIgnoreCase("removeritem")) {

				try {
					Integer idItem = Integer.parseInt(request.getParameter("idItem"));
					Integer idComanda = Integer.parseInt(request.getParameter("id"));
					ComandaDAO comandaDAO = new ComandaDAO();
					ItemComandaDAO itemComandaDAO = new ItemComandaDAO();
					itemComandaDAO.delete(idItem);
					PagamentoDAO pagamentoDAO = new PagamentoDAO();
					Comanda comanda = comandaDAO.findById(idComanda);
					List<Pagamento> listPagamentos = pagamentoDAO.findByComanda(idComanda);
					List<ItemComanda> listItemComanda = itemComandaDAO.findById(idComanda);

					comanda.setListPagamento(listPagamentos);
					comanda.setListItemComanda(listItemComanda);
					request.setAttribute("comanda", comanda);
					request.setAttribute("id", idComanda);
					
				} catch (SQLException e) {
					request.setAttribute("mensagem", "OPS! Ocorreu um erro");
					
					
				} finally {
					request.getRequestDispatcher("detalhecomanda.jsp").forward(request, response);
				}
			}
		}
	}
}
