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
	
	private static String SQL_SELECT = "SELECT u.no_utilisateur, u.pseudo,u.nom, u.prenom, u.email, u.telephone, u.code_postal, u.rue, u.ville, a.image, a.nom_article, e.montant_enchere, a.date_fin_enchere FROM ARTICLES_VENDUS AS a LEFT OUTER JOIN ENCHERES AS e ON a.no_article = e.no_article INNER JOIN UTILISATEURS AS u ON a.no_utilisateur = u.no_utilisateur WHERE 1 = 1 ; ";
	

	public List<Article> listeEnchere () throws DALException{
	
		List<Article> newlist = new ArrayList<Article>();
		
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pS = connection.prepareStatement(SQL_SELECT);
			ResultSet rs = pS.executeQuery();
			while(rs.next()) {
				Article newart = new Article(rs.getString("nom_article"),rs.getTimestamp("date_fin_enchere").toLocalDateTime(), rs.getString("image"), rs.getInt("montant_enchere"), rs.getInt("no_utilisateur"));
				newlist.add(newart);
			}	
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur dans la DAL" + e.getMessage());
		}
		
		return newlist;
	}
}
