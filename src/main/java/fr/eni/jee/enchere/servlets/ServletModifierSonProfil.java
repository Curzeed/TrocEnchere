package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bll.ObjectManager;
import fr.eni.jee.enchere.bo.User;

/**
 * Servlet implementation class ServletModifierSonProfil
 */
@WebServlet("/ModifiersonProfil")
public class ServletModifierSonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectManager om = new ObjectManager();
		User utilisateur = (User) request.getSession().getAttribute("utilisateur");
		if(isAlphaNumeric(utilisateur.getPseudo()) == true && isAlphaNumeric(utilisateur.getPrenom())&& isAlphaNumeric(utilisateur.getNom()) == true){
			try {
			om.modifyManager(utilisateur);
		} catch (BLLException e) {
			request.setAttribute("erreur", e);
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
		}
	}
	private static boolean isAlphaNumeric(String s) {
		return s.matches("[A-Za-z0-9]+");
    }

}
