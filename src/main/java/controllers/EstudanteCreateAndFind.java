package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.EstudanteDao;

import model.Estudante;

@WebServlet("/CreateAndFind")
public class EstudanteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EstudanteCreateAndFind() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Estudante> estudantes = EstudanteDao.find(pesquisa);
		request.setAttribute("estudantes", estudantes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
		requestDispatcher.forward(request, response);

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Instanciando um estudante novo com os dados da tela
		Estudante estudante = new Estudante();
		estudante.setNome(request.getParameter("nome"));		
		estudante.setCurso(request.getParameter("curso"));
		estudante.setCpf(request.getParameter("cpf"));
		estudante.setImagem(request.getParameter("imagem"));
		estudante.setSituacao(request.getParameter("situacao"));


		EstudanteDao.create(estudante);
		// enviando os dadaos para o PreparedStatment do DAO

		// Sempre que cadastrar um cliente, quero chamar o metodo doGet
		EstudanteCreateAndFind estudanteCreateAndFind = new EstudanteCreateAndFind();
		estudanteCreateAndFind.doGet(request, response);

	}
	



}
