package fr.eni.jee.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bll.ObjectManager;
import fr.eni.jee.enchere.bo.User;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectManager om = new ObjectManager();
		User user = null;
		String pseudorecup = request.getParameter("pseudo");
		String mdp = request.getParameter("motdepasse");
		String erreur = "Pseudo ou mot de passe incorrect";
		String souvenir = request.getParameter("souvenir");
		String name = request.getParameter("pseudo");
		String password = request.getParameter("motdepasse");
		try {
			user = om.valideLogin(pseudorecup, mdp);
		} catch (BLLException e1) {
			request.setAttribute("erreur", e1);
			e1.printStackTrace();
		}
		
		try {
			if(user != null ) {
				 HttpSession session = request.getSession();
				 session.setAttribute("utilisateur", user); 
				 if(souvenir!=null) {
					 	Cookie ck = new Cookie("pseudo",name);
						ck.setMaxAge(-1);
						response.addCookie(ck);
						/*
						Cookie ck2 = new Cookie("motdepasse",password);
						ck2.setMaxAge(27224*257257*654);
						response.addCookie(ck2);
						*/	
					 }
				 request.getRequestDispatcher("/ListeEnchere").forward(request, response);
			}else {
				 request.setAttribute("erreur",erreur);
				 request.getRequestDispatcher("/WEB-INF/PageLogin.jsp").forward(request, response);
			}
		} catch (ServletException | IOException e) {
			request.setAttribute("erreur",e);
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/PageLogin.jsp").forward(request, response);
		}
		
		
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/PageLogin.jsp").forward(req, resp);
		
	}

}