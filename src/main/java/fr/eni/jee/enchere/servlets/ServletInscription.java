package fr.eni.jee.enchere.servlets;
import java.io.IOException;
import java.util.regex.Pattern;

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
    private static Pattern pattern;
	private static java.util.regex.Matcher matcher;
   
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
        String codepostalString = request.getParameter("cp"); 
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        
        int codepostal = Integer.parseInt(codepostalString);
        if(isAlphaNumeric(pseudo) == true && isAlphaNumeric(prenom)&& isAlphaNumeric(nom) == true && validateEmail(email) == true){
            try {
                om.addUser(pseudo, nom, prenom, email, tel, rue, codepostal, ville, mdp);
                HttpSession  session = request.getSession();
                session.setAttribute("pseudo", pseudo);
                request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
                } catch (BLLException e) {
                    e.getMessage();
                    request.setAttribute("erreur", e);
                }
        }if (isAlphaNumeric(pseudo) == false ) {
			request.setAttribute("erreurpseudo", "Caract�res sp�ciaux dans le champ Pseudo");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}if (isAlphaNumeric(prenom) == false) {
			request.setAttribute("erreurprenom", "Caract�res sp�ciaux dans le champ Pr�nom");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}if (isAlphaNumeric(nom) == false ) {
			request.setAttribute("erreurnom", "Caract�res sp�ciaux dans le champ Nom");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}if (isAlphaNumeric(ville) == false) {
			request.setAttribute("erreurville", "Caract�res sp�ciaux dans le champ ville");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}if (validateEmail(email) == false) {
			request.setAttribute("erreuremail", "Caract�res sp�ciaux dans le champ email");
			request.getRequestDispatcher("/WEB-INF/PageInscription.jsp").forward(request, response);
		}
        }// TODO Faire l'email vérification 
        
    public static boolean isAlphaNumeric(String s) {
        return s.matches("[A-Za-z0-9]+");
    }
    private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public ServletInscription() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
	
	private static  boolean validateEmail(String s) {
		matcher = pattern.matcher(s);
		return matcher.matches();
	}
}