package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import to.CursoTO;
import to.ListaDeCursos;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCurso.do")

public class ManterCursoController extends HttpServlet {
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
		String pIdCurso = request.getParameter("idCurso");
		String pNomeCurso = request.getParameter("nomeCurso");
		String pDataIniCurso = request.getParameter("dataIniCurso");
		String pDataFimCurso = request.getParameter("dataFimCurso");
		String pValorCurso = request.getParameter("valorCurso");
		String pNumVagasCurso = request.getParameter("numVagasCurso");
		int idCurso = -1;
		try {
			idCurso = Integer.parseInt(pIdCurso);
		} catch (NumberFormatException e) {

		}

		Curso curso = new Curso(idCurso, pNomeCurso, pDataIniCurso, pDataFimCurso, pValorCurso, pNumVagasCurso);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			curso.criar();
			ArrayList<CursoTO> lista = new ArrayList<>();
			lista.add(curso.getTO());
			ListaDeCursos lda = new ListaDeCursos();
			lda.setCursos(lista);
			request.setAttribute("lista", lda);
			view = request.getRequestDispatcher("ListarCursos.jsp");
		} else if (pAcao.equals("Excluir")) {
			curso.excluir();
			view = request.getRequestDispatcher("ListarCursos.jsp");
		} else if (pAcao.equals("Alterar")) {
			curso.atualizar();
			request.setAttribute("curso", curso.getTO());
			view = request.getRequestDispatcher("VisualizarCurso.jsp");
		} else if (pAcao.equals("Visualizar")) {
			curso.carregar();
			request.setAttribute("curso", curso.getTO());
			view = request.getRequestDispatcher("VisualizarCurso.jsp");
		} else if (pAcao.equals("Editar")) {
			curso.carregar();
			request.setAttribute("curso", curso.getTO());
			view = request.getRequestDispatcher("AlterarCurso.jsp");
		}

		view.forward(request, response);

	}
}
