package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bll.ProfilManager;
import fr.eni.jee.enchere.bo.User;

/**
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/ProfilUtilisateur")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession();
		int id = Integer.parseInt(request.getParameter("no_utilisateur"));
		
		try {
			ProfilManager pM = new ProfilManager();
			List<User> listuser = pM.afficherUser(id); // Récupération de la liste user
			request.setAttribute("vendeur", listuser); // Attribrution de la liste Objet User
			request.getRequestDispatcher("/WEB-INF/InfosVendeur.jsp").forward(request, response);
			
		}catch (BLLException e) {
			e.getMessage();
			e.printStackTrace();
			request.setAttribute("erreur","Une erreur est survenue contactez le support avec ce message d'erreur : " + e.getMessage());
		}
	
	}

	
	
	
		

}
