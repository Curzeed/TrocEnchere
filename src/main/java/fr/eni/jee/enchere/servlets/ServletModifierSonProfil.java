package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import java.util.regex.Pattern;
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
	private static Pattern pattern;
	private static java.util.regex.Matcher matcher;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectManager om = new ObjectManager();
		User utilisateur = (User) request.getSession().getAttribute("utilisateur");
		String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String rue = request.getParameter("rue");
        String codepostalString = request.getParameter("cp"); 
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        String newMdp = request.getParameter("newmdp");
        String confNewMdp = request.getParameter("confNewMdp");
        
        int cp = Integer.parseInt(codepostalString);
        
        User newUtilisateur = new User(utilisateur.getId(),pseudo, nom, prenom, email, tel, rue, cp, ville, confNewMdp, 100, utilisateur.getAdministrateur());
		
        
        if((isAlphaNumeric(newUtilisateur.getPseudo()) == true && isAlphaNumeric(newUtilisateur.getPrenom())&& isAlphaNumeric(newUtilisateur.getNom()) == true 
        		&& validateEmail(email) == true && isAlphaNumeric(ville) == true &&  utilisateur.getMdp().equals(newMdp) == false 
        		&& newMdp.equals(confNewMdp) == true && mdp.equals(utilisateur.getMdp()) == true)){
        	
        	try {
			om.modifyManager(newUtilisateur);
			request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
				} catch (BLLException e) {
					request.setAttribute("erreur", e);
					e.printStackTrace();
				}
			}if (isAlphaNumeric(newUtilisateur.getPseudo()) == false ) {
				request.setAttribute("erreurpseudo", "Caractères spéciaux dans le champ Pseudo");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if (isAlphaNumeric(newUtilisateur.getPrenom()) == false) {
				request.setAttribute("erreurprenom", "Caractères spéciaux dans le champ Prénom");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if (isAlphaNumeric(newUtilisateur.getNom()) == false ) {
				request.setAttribute("erreurnom", "Caractères spéciaux dans le champ Nom");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if (isAlphaNumeric(newUtilisateur.getVille()) == false) {
				request.setAttribute("erreurville", "Caractères spéciaux dans le champ ville");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if ( utilisateur.getMdp().equals(newMdp) == true) {
				request.setAttribute("erreurnvmdp", "Veuillez saisir un nouveau mot de passe");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if( newMdp.equals(confNewMdp) == false) {
				request.setAttribute("erreurconfmdp", "Veuillez confirmer votre nouveau mot de passe");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}if(mdp.equals(utilisateur.getMdp()) == false) {
				request.setAttribute("erreurmdpactuel", "Veuillez écrire votre mot de passe actuelle");
				request.getRequestDispatcher("/WEB-INF/PageModifierProfil.jsp").forward(request, response);
			}
	}
	private static boolean isAlphaNumeric(String s) {
		return s.matches("^[a-zA-Z0-9 ]*$");
    }

	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public ServletModifierSonProfil() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
	
	private static  boolean validateEmail(String s) {
		matcher = pattern.matcher(s);
		return matcher.matches();
	}
}	
