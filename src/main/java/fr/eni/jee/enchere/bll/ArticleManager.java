package fr.eni.jee.enchere.bll;

import java.sql.Date;
import java.time.LocalDate;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImlpArticleDAO;

public class ArticleManager {
	
	private JDBCImlpArticleDAO ArticleDAO = new JDBCImlpArticleDAO();

	public Article addArticle( String article, String description, LocalDate dateDebut, 
			LocalDate dateFin, int prix, int no_utilisateur, int no_categorie, String etat, String image )throws BLLException{
		Article nouveauArticle;
		
		try {
				nouveauArticle = new Article(article, description, dateDebut, dateFin, prix, no_utilisateur, no_categorie, etat, image);
			ArticleDAO.addArticle(nouveauArticle); 	
			}catch (DALException e) {
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}return nouveauArticle;
		
	}
}
