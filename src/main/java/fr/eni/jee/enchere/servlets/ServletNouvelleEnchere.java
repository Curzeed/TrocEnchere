package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.jee.enchere.bll.ArticleManager;
import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Categorie;
import fr.eni.jee.enchere.bo.User;

@WebServlet("/venteEnchere")
@MultipartConfig 
public class ServletNouvelleEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager am = new ArticleManager();
		
		User utilisateur = (User) request.getSession().getAttribute("utilisateur");
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int categorie = Integer.parseInt(request.getParameter("categories"));
		String image = request.getParameter("img");
		int prix = Integer.parseInt(request.getParameter("prix"));
		LocalDateTime dateDebut = LocalDateTime.parse(request.getParameter("dateDebut"));
		LocalDateTime dateFin = LocalDateTime.parse(request.getParameter("dateFin"));
		String etatVente = "EC";	
		
		System.out.println(categorie);
		try {
			am.addArticle(article, description, dateDebut, dateFin, prix, utilisateur.getId(),categorie, etatVente, image);
		}catch (BLLException e) {
			request.setAttribute("erreur", e);
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager am = new ArticleManager();
		try {
			List<Categorie> listeCategorie = am.selectCategorie();
			request.setAttribute("listcategory", listeCategorie);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp").forward(request, response);

	}
	public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
}
