package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstudanteDao;

/**
 * Servlet implementation class EstudanteDelete
 */
@WebServlet("/EstudanteDestroy")
public class EstudanteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EstudanteDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recebento o id que o usuario selecionou para excluir e transformando em inteiro 
		int estudanteId = Integer.parseInt(request.getParameter("estudanteId"));
		EstudanteDao.delete(estudanteId);
		
		//Apos excluir, mostrar a lista atualizada chamando o doGet
		EstudanteCreateAndFind estudanteCreateAndFind = new EstudanteCreateAndFind();
		estudanteCreateAndFind.doGet(request, response);
	}


}
