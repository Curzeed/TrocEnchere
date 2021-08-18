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

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectManager om = new ObjectManager();
		String pseudorecup = request.getParameter("pseudo");
		String mdp = request.getParameter("motdepasse");
		String erreur = "Pseudo ou mot de passe incorrect";
		try {
			if(om.valideLogin(pseudorecup, mdp)== true) {
				 HttpSession session = request.getSession();
				 session.setAttribute("pseudo", pseudorecup);
				 request.getRequestDispatcher("/WEB-INF/ListeEnchere.jsp").forward(request, response);
			}else {
				 request.setAttribute("erreur",erreur);
				 request.getRequestDispatcher("/WEB-INF/PageLogin.jsp").forward(request, response);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/PageLogin.jsp").forward(req, resp);
	}
	

}
