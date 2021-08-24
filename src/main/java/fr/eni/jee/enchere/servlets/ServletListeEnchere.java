package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.enchere.bll.ArticleManager;
import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bll.EnchereManager;
import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Categorie;
import fr.eni.jee.enchere.bo.Enchere;


@WebServlet("/ListeEnchere")
public class ServletListeEnchere extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArticleManager am = new ArticleManager();
	EnchereManager em = new EnchereManager();
	try {
		List<Categorie> listeCategorie = am.selectCategorie();
		request.setAttribute("listcategory", listeCategorie);
		List<Article> listePrint = em.selectEncheres();
		HttpSession session = request.getSession();
		session.setAttribute("encheres", listePrint);
		request.getRequestDispatcher("/WEB-INF/ListeEnchere.jsp").forward(request, response);
		} catch (BLLException e1) {
		e1.printStackTrace();
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}


}
