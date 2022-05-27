package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstudanteDao;
import model.Estudante;

@WebServlet("/EstudanteUpdate")
public class EstudanteFindUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EstudanteFindUpdate() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int estudanteId = Integer.parseInt(request.getParameter("estudanteId"));
		Estudante estudante = EstudanteDao.findByPk(estudanteId);
		request.setAttribute("estudante", estudante);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Estudante estudante = new Estudante();
		estudante.setId(Integer.parseInt(request.getParameter("id")));
		estudante.setNome(request.getParameter("nome"));		
		estudante.setCurso(request.getParameter("curso"));
		estudante.setCpf(request.getParameter("cpf"));
		estudante.setImagem(request.getParameter("imagem"));
		estudante.setSituacao(request.getParameter("situacao"));
		EstudanteDao.update(estudante);
		
		EstudanteCreateAndFind estudanteCreateAndFind = new EstudanteCreateAndFind();
		estudanteCreateAndFind.doGet(request, response);
	}

}
