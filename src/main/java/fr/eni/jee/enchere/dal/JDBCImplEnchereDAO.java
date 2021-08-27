package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Enchere;
import fr.eni.jee.enchere.bo.User;

public class JDBCImplEnchereDAO {

	private static String SQL_SELECT = "SELECT * FROM ARTICLES_VENDUS AS a LEFT OUTER JOIN ENCHERES AS e ON a.no_article = e.no_article INNER JOIN UTILISATEURS AS u ON a.no_utilisateur = u.no_utilisateur; ";
	private static String SQL_INSERT_ENCHERE = "insert into ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) values(?,?,?,?)";
	private static String SQL_UPDATE_ENCHERE = "update ENCHERES set montant_enchere=?, no_utilisateur=?, date_enchere=? where no_article=?";

	
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
				Article newart = new Article(rs.getInt("no_article"), rs.getString("nom_article"),rs.getTimestamp("date_fin_enchere").toLocalDateTime(), rs.getString("image"), rs.getInt("montant_enchere"), rs.getInt("no_utilisateur"),user);
				if (montantEnchere != null) {
					Enchere enchere = new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"),Optional.ofNullable(rs.getTimestamp("date_enchere")).map(dateEnchere -> dateEnchere.toLocalDateTime()).orElse(null), rs.getInt("montant_enchere"));
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

	public void insertEnchere(Enchere enchere) throws DALException{
		try {
			
			Connection connection = ConnectionProvider.getConnection();

		PreparedStatement pS = connection.prepareStatement(SQL_UPDATE_ENCHERE);
		pS.setInt(1, enchere.getMontant_enchere());
		pS.setInt(2, enchere.getId_utilisateur());
		pS.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
		pS.setInt(4, enchere.getId_article());
		int rowCount = pS.executeUpdate();
		if (rowCount == 0) {
			pS = connection.prepareStatement(SQL_INSERT_ENCHERE);
			pS.setInt(1, enchere.getId_utilisateur());
			pS.setInt(2, enchere.getId_article());
			pS.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
			pS.setInt(4, enchere.getMontant_enchere());
			pS.executeUpdate();
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException ("Erreur dans la création d'un article"+ e.getMessage());
		}
	}
}
