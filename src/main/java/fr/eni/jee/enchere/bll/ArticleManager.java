package fr.eni.jee.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Categorie;
import fr.eni.jee.enchere.bo.Enchere;
import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImlpArticleDAO;

public class ArticleManager {
	
	private JDBCImlpArticleDAO ArticleDAO = new JDBCImlpArticleDAO();

	public Article addArticle( String article, String description, LocalDateTime dateDebut, 
			LocalDateTime dateFin, int prix, int no_utilisateur, int no_categorie, String etat, String image )throws BLLException{
			Article nouveauArticle;
		
		try {
				nouveauArticle = new Article(article, description, dateDebut, dateFin, prix, no_utilisateur, no_categorie, etat, image);
			ArticleDAO.addArticle(nouveauArticle); 	
			}catch (DALException e) {
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}return nouveauArticle;
		
	}	
	public List<Categorie> selectCategorie() throws BLLException {
		List<Categorie> categorieList = null;
		
		try {
			categorieList = ArticleDAO.list();
		} catch (SQLException | DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException("Erreur BLL + Erreur dans la s�l�ction des cat�gories ");
		}
		return categorieList;
	}
	public List<Article> detailArticle(int no_article) throws BLLException {
		List<Article> detailArticle = null;
		
		try {
			detailArticle = ArticleDAO.detailArticle(no_article);
		}catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur dans la bll + Erreur dans l'affichage des articles");
		}return detailArticle;
	}
}
