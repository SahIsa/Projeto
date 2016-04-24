package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import to.AlunoTO;
import to.ListaDeAlunos;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterAluno.do")

public class ManterAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pCpf = request.getParameter("cpf");
		String pNome = request.getParameter("nome");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pRg = request.getParameter("rg");
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Aluno aluno = new Aluno(pNome, pEmail, pCpf, pRg, pTelefone, id);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			aluno.criar();
			ArrayList<AlunoTO> lista = new ArrayList<>();
			lista.add(aluno.getTO());
			ListaDeAlunos lda = new ListaDeAlunos();
			lda.setAlunos(lista);
			request.setAttribute("lista", lda);
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Excluir")) {
			aluno.excluir();
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Alterar")) {
			aluno.atualizar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");
		} else if (pAcao.equals("Visualizar")) {
			aluno.carregar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");
		} else if (pAcao.equals("Editar")) {
			aluno.carregar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("AlterarAluno.jsp");
		}

		view.forward(request, response);

	}
}
