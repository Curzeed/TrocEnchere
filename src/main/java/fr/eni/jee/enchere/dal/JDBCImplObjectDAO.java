package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.jee.enchere.bo.User;
import fr.eni.jee.enchere.dal.ConnectionProvider;

public class JDBCImplObjectDAO {
	private static String SQL_VERIFLOGIN = "SELECT * FROM UTILISATEURS WHERE pseudo=? OR email=? AND mot_de_passe=?;"; 
	private static String SQL_NEW_USER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,0);";
	
	public boolean validerConnexion(String pseudo, String mdp) throws DALException{
		boolean statutCo = false;
		try {
			Connection connection = ConnectionProvider.getConnection();
			
			PreparedStatement pS = connection.prepareStatement(SQL_VERIFLOGIN);
			pS.setString(1, pseudo);
			pS.setString(2, pseudo);
			pS.setString(3, mdp);
			ResultSet rs = pS.executeQuery();
			statutCo = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Le login n'est pas reconnu");
		}
		return statutCo;
	}
	public void addUser(User user) throws DALException{
		
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pS = connection.prepareStatement(SQL_NEW_USER);
			pS.setString(1,user.getPseudo());
			pS.setString(2,user.getNom());
			pS.setString(3,user.getPrenom());
			pS.setString(4,user.getEmail());
			pS.setString(5,user.getTelephone());
			pS.setString(6,user.getRue());
			pS.setString(7,user.getCodePostal());
			pS.setString(8,user.getVille());
			pS.setString(9,user.getMdp());
			pS.setInt(10,user.getCredit());
			pS.executeUpdate();
		
		}catch (SQLException e) {
			if (e.getMessage().contains("utilisateurs_pseudo_uq")) {
				throw new DALException("Le pseudo est déjà utilisé");
			}if (e.getMessage().contains("utilisateurs_email_uq")) {
				throw new DALException("Le mail est déjà utilisé");
			}
			e.printStackTrace();
			throw new DALException("Problème de l'inscription dans la DAL");
		}
	}
}
