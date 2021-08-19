package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.jee.enchere.bo.Article;

public class JDBCImlpArticleDAO {
	private static String SQL_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image ) VALUES (?,?,?,?,?,?,?,?,'EC',?)";

	public void addArticle(Article article) throws DALException{
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement pS = connection.prepareStatement(SQL_NEW_ARTICLE);
		pS.setString(1, article.getArticle());
		pS.setString(2, article.getDescription());
		pS.setString(3, article.getDateDebut());
		pS.setString(4, article.getDateFin());
		pS.setInt(5, article.getPrix());
		pS.setInt(6, article.getPrix_vente());
		pS.setInt(7, article.getIdVendeur());
		pS.setString(8, article.getCategorie());
		pS.setString(9, article.getImage());
		pS.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException ("Erreur dans la création d'un article"+ e.getMessage());
		}

		
	}

}
