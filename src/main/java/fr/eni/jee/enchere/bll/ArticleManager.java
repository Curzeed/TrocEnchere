package fr.eni.jee.enchere.bll;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImlpArticleDAO;

public class ArticleManager {
	
	private JDBCImlpArticleDAO ArticleDAO = new JDBCImlpArticleDAO();

	public Article addArticle( String article, String description, String dateDebut, 
			String dateFin, int prix, int idVendeur, String categorie, String etat_vente, String image )throws BLLException{
		Article nouveauArticle;
		
		try {
			nouveauArticle = new Article ( article, description, dateDebut, dateFin, prix,
					 idVendeur, categorie, etat_vente, image); 
				
			ArticleDAO.addArticle(nouveauArticle); 	
			}catch (DALException e) {
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}return nouveauArticle;
		
	}
}
