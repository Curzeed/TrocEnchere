package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.enchere.bll.ObjectManager;
import fr.eni.jee.enchere.bll.ProfilManager;
import fr.eni.jee.enchere.bo.User;

/**
 * Servlet implementation class ServletSupprimer
 */
@WebServlet("/Supprimer")
public class ServletSupprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfilManager pm = new ProfilManager();
		
		User user = (User) request.getSession().getAttribute("utilisateur");
		pm.deleteUser(user.getId());
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
