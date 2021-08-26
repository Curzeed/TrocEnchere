package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Categorie;

public class JDBCImlpArticleDAO {
	private static String SQL_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image ) VALUES (?,?,?,?,?,?,?,'EC',?)";
	private static String SQL_CATEGORIES = "SELECT * FROM CATEGORIES";
	
	
	public void addArticle(Article article) throws DALException{
		try {
			Connection connection = ConnectionProvider.getConnection();

		PreparedStatement pS = connection.prepareStatement(SQL_NEW_ARTICLE,PreparedStatement.RETURN_GENERATED_KEYS);
		pS.setString(1, article.getArticle());
		pS.setString(2, article.getDescription());
		pS.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDateDebut()));
		pS.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDateFin()));
		pS.setInt(5, article.getPrix());
		pS.setInt(6, article.getIdVendeur());
		pS.setInt(7, article.getCategorie());
		pS.setString(8, article.getImage());
		pS.executeUpdate();
		ResultSet rs = pS.getGeneratedKeys();
		if (rs.next()) {
			article.setIdArticle(rs.getInt(0));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException ("Erreur dans la création d'un article"+ e.getMessage());
		}
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
