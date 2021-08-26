package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Categorie;
import fr.eni.jee.enchere.bo.Enchere;
import fr.eni.jee.enchere.bo.User;

public class JDBCImlpArticleDAO {
	private static String SQL_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image ) VALUES (?,?,?,?,?,?,?,'EC',?)";
	private static String SQL_CATEGORIES = "SELECT * FROM CATEGORIES";
	private static String SQL_DETAIL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON u.no_utilisateur  = a.no_utilisateur	LEFT JOIN ENCHERES as e ON e.no_article  = a.no_article INNER JOIN CATEGORIES AS c ON a.no_categorie = c.no_categorie WHERE a.no_article=?";
	
	
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
	 
	 public List<Article> detailArticle(int no_article) throws DALException {
		 List<Article> listeArticle = new ArrayList<Article>();
		 try {
			 
			 Connection connection = ConnectionProvider.getConnection();
			 PreparedStatement pS = connection.prepareStatement(SQL_DETAIL_ARTICLE);
			 pS.setInt(1, no_article);
			 ResultSet rS = pS.executeQuery();
			 while(rS.next()) {
				User user = new User(rS.getInt("no_utilisateur"), rS.getString("pseudo"), rS.getString("nom"), rS.getString("prenom"), rS.getString("prenom"), rS.getString("email"), rS.getString("telephone"), rS.getInt("code_postal"), rS.getString("rue"), rS.getString("ville"), rS.getInt("credit"), rS.getByte("administrateur"));
				Integer montantEnchere = rS.getInt("montant_enchere");
				Categorie categorie = new Categorie(rS.getInt("no_categorie"), rS.getString("libelle"));
				Article article = new Article(rS.getInt("no_article"), rS.getString("nom_article"),rS.getTimestamp("date_fin_enchere").toLocalDateTime(), rS.getString("image"), rS.getInt("montant_enchere"), rS.getInt("no_utilisateur"),user, categorie);
					if (montantEnchere != null) {
						Enchere enchere = new Enchere(rS.getInt("no_utilisateur"),rS.getInt("no_article"),Optional.ofNullable(rS.getTimestamp("date_enchere")).map(dateEnchere -> dateEnchere.toLocalDateTime()).orElse(null), rS.getInt("montant_enchere"));
						article.setEnchere(enchere);
					}
					listeArticle.add(article);
			 }
		 }catch (SQLException e ) {
			 e.printStackTrace();
			 throw new DALException("Erreur dans la DAL + Erreur dans l'affichage du détail article"+ e.getMessage());
		 }return listeArticle;
	 }
}
