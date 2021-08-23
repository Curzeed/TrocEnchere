package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.enchere.bll.ArticleManager;
import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Categorie;


@WebServlet("/ListeEnchere")
public class ServletListeEnchere extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ArticleManager am = new ArticleManager();
	try {
		List<Categorie> listeCategorie = am.selectCategorie();
		request.setAttribute("category", listeCategorie);
		request.getSession();
	} catch (BLLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	request.getRequestDispatcher("/WEB-INF/ListeEnchere.jsp").forward(request, response);
	
	}


}
