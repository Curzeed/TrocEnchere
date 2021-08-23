package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.jee.enchere.bo.Article;

public class JDBCImlpArticleDAO {
	private static String SQL_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image ) VALUES (?,?,?,?,?,?,?,'EC',?)";

	public Article addArticle(Article article) throws DALException{
		Article newArticle;
		try {
			Connection connection = ConnectionProvider.getConnection();

		PreparedStatement pS = connection.prepareStatement(SQL_NEW_ARTICLE);
		pS.setDate(1, java.sql.Date.valueOf(article.getDateDebut()));
		pS.setString(1, article.getArticle());
		pS.setString(2, article.getDescription());
		pS.setDate(3,java.sql.Date.valueOf(article.getDateDebut()));
		pS.setDate(4, java.sql.Date.valueOf(article.getDateFin());
		pS.setInt(5, article.getPrix());
		pS.setInt(6, article.getIdVendeur());
		pS.setInt(7, article.getCategorie());
		pS.setString(8, article.getImage());
		ResultSet rs = pS.executeQuery();
		if (rs.next()) {
			rs.getInt("no_article"), String article, String description, LocalDate dateDebut, LocalDate dateFin, int prix,
					int prix_vente, int idVendeur, int categorie, String etat, String image)
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException ("Erreur dans la création d'un article"+ e.getMessage());
		}

		// String CONDITION_SQL = "WHERE"
	}

}
