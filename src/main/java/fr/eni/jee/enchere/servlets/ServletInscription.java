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
	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("cp"); 
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		
		if(isAlphaNumeric(pseudo) == true || isAlphaNumeric(email) == true || isAlphaNumeric(prenom)|| isAlphaNumeric(nom) == true || isAlphaNumeric(ville) == true){
			try {
				om.addUser(pseudo, nom, prenom, email, tel, rue, codepostal, ville, mdp);
				HttpSession  session = request.getSession();
				session.setAttribute("pseudo", pseudo);
				request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
				} catch (BLLException e) {
					e.getMessage();
					e.printStackTrace();
				}
		}else if (isAlphaNumeric(pseudo) == false || isAlphaNumeric(email) == false || isAlphaNumeric(prenom)|| isAlphaNumeric(nom) == false || isAlphaNumeric(ville) == false) {
			request.setAttribute("erreur", "Le champ Pseudo contient un caractère non autorisé");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}else {
			request.setAttribute("erreur", "Compte déjà créé");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp");
		}
		
}
	public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

}
