package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Article;

/**
 * Servlet implementation class ServletAccesEnchere
 */
@WebServlet("/DetailArticle")
public class ServletDetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> listeArticle = (List<Article>) request.getSession().getAttribute("encheres");
		
		request.getRequestDispatcher("/WEB-INF/PageArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
