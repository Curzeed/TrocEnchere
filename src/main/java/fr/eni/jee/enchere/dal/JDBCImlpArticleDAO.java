package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Categorie;

public class JDBCImlpArticleDAO {
	private static String SQL_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image ) VALUES (?,?,?,?,?,?,?,'EC',?)";
	private static String SQL_CATEGORIES = "SELECT * FROM CATEGORIES";
	public Article addArticle(Article article) throws DALException{
		Article newArticle = null;
		try {
			Connection connection = ConnectionProvider.getConnection();

		PreparedStatement pS = connection.prepareStatement(SQL_NEW_ARTICLE);
		pS.setDate(1, java.sql.Date.valueOf(article.getDateDebut()));
		pS.setString(1, article.getArticle());
		pS.setString(2, article.getDescription());
		pS.setDate(3,java.sql.Date.valueOf(article.getDateDebut()));
		pS.setDate(4, java.sql.Date.valueOf(article.getDateFin()));
		pS.setInt(5, article.getPrix());
		pS.setInt(6, article.getIdVendeur());
		pS.setInt(7, article.getCategorie());
		pS.setString(8, article.getImage());
		ResultSet rs = pS.executeQuery();
		if (rs.next()) {
			newArticle = new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut").toLocalDate(), rs.getDate("date_fin").toLocalDate(), rs.getInt("prix"),
			rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getString("etat"), rs.getString("image"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException ("Erreur dans la crÃ©ation d'un article"+ e.getMessage());
		}return newArticle;

		// String CONDITION_SQL = "WHERE"
	}
	
	 public List<Categorie> list() throws SQLException, DALException {
	        List<Categorie> listCategory = new ArrayList<>();
	         
	        try (Connection connection = ConnectionProvider.getConnection()) {
	            PreparedStatement pS  = connection.prepareStatement(SQL_CATEGORIES);
	            ResultSet result = pS.executeQuery();
	            while (result.next()) {
	                int id = result.getInt("no_categorie");
	                String name = result.getString("libelle");
	                Categorie category = new Categorie(id, name);
	                     
	                listCategory.add(category);
	            }          
	             
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new DALException("Erreur dans la récupération de la catégorie" + e.getMessage());
	        }      
	         
	        return listCategory;
	 }
}
