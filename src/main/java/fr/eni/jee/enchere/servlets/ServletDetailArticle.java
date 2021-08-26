package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.enchere.bll.ArticleManager;
import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Article;

/**
 * Servlet implementation class ServletAccesEnchere
 */
@WebServlet("/DetailArticle")
public class ServletDetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int no_article= Integer.parseInt(request.getParameter("no_article"));
		List<Article> listeDetailArticle = new ArrayList<Article>();
		ArticleManager aM = new ArticleManager();
		
		try {
			listeDetailArticle = aM.detailArticle(no_article);
		} catch (BLLException e) {
			request.setAttribute("erreur",e.getMessage()+"Erreur dans l'affichage d'un article");
			e.printStackTrace();
		}
		request.setAttribute("detailArticle", listeDetailArticle);
		request.getRequestDispatcher("/WEB-INF/PageArticle.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
