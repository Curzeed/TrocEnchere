package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bll.ObjectManager;


@WebServlet("/Inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectManager om = new ObjectManager();
		
		request.getRequestDispatcher("/WEB-INF/PageLogin.jsp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("cp"); 
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
	 
		try {
			om.addUser(nom,prenom, pseudo, email, tel, rue, codepostal, ville, mdp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("pseudo", pseudo);
		request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
	}

}
