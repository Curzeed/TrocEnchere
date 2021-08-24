package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Enchere;
import fr.eni.jee.enchere.bo.User;

public class JDBCImplEnchereDAO {
	
	private static String SQL_SELECT = "SELECT * FROM ARTICLES_VENDUS AS a LEFT OUTER JOIN ENCHERES AS e ON a.no_article = e.no_article INNER JOIN UTILISATEURS AS u ON a.no_utilisateur = u.no_utilisateur WHERE 1 = 1 ; ";
	

	public List<Article> listeEnchere () throws DALException{
	
		List<Article> newlist = new ArrayList<Article>();
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pS = connection.prepareStatement(SQL_SELECT);
			ResultSet rs = pS.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getInt("code_postal"), rs.getString("rue"), rs.getString("ville"), rs.getInt("credit"), rs.getByte("administrateur"));
				Integer montantEnchere = rs.getInt("montant_enchere");
				montantEnchere = rs.getInt("montant_enchere");
				Article newart = new Article(rs.getString("nom_article"),rs.getTimestamp("date_fin_enchere").toLocalDateTime(), rs.getString("image"), rs.getInt("montant_enchere"), rs.getInt("no_utilisateur"),user);
			if (montantEnchere == null) {
					Enchere enchere = new Enchere(rs.getInt("id_utilisateur"), rs.getInt("id_article"),rs.getTimestamp("date_enchere").toLocalDateTime(), rs.getInt("montant_enchere"));
				  newart.setEnchere(enchere);
				}
				newlist.add(newart);
			}	
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur dans la DAL" + e.getMessage());
		}
		
		return newlist;
	}
}
