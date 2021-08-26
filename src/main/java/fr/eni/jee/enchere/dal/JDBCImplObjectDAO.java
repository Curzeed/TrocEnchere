package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.jee.enchere.bo.User;
import fr.eni.jee.enchere.dal.ConnectionProvider;

public class JDBCImplObjectDAO {
	private static String SQL_MODIFY_USER = "UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? WHERE no_utilisateur=?;";
	private static String SQL_VERIFLOGIN = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=? OR email=?;"; 
	private static String SQL_NEW_USER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,0);";
	
	public User validerConnexion(String pseudo, String mdp) throws DALException{
		User user = null;
		try {
			Connection connection = ConnectionProvider.getConnection();
			
			PreparedStatement pS = connection.prepareStatement(SQL_VERIFLOGIN);
			pS.setString(1, pseudo);
			pS.setString(3, pseudo);
			pS.setString(2, mdp);
			ResultSet rs = pS.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("no_utilisateur");
				String pseudorecup = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email =  rs.getString("email");
				String tel = rs.getString("telephone");
				String rue = rs.getString("rue");
				int cp = rs.getInt("code_postal");
				String ville = rs.getString("ville");
				String mdprecup = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				byte admin = rs.getByte("administrateur");
				
				user = new User(id, pseudorecup, nom,prenom, email, tel, rue, cp, ville, mdprecup, credit, admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Le login n'est pas reconnu ! note technique : " + e.getMessage());
		}
		return user;
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
			pS.setInt(7,user.getCodePostal());
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
	public void modifyUser(User utilisateur) throws DALException {
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pS = connection.prepareStatement(SQL_MODIFY_USER);
			pS.setString(1, utilisateur.getPseudo());
			pS.setString(2, utilisateur.getNom());
			pS.setString(3, utilisateur.getPrenom());
			pS.setString(4, utilisateur.getEmail());
			pS.setString(5, utilisateur.getTelephone());
			pS.setString(6, utilisateur.getRue());
			pS.setInt(7, utilisateur.getCodePostal());
			pS.setString(8, utilisateur.getVille());
			pS.setString(9, utilisateur.getMdp());
			pS.setInt(10, utilisateur.getId());
			pS.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("utilisateurs_pseudo_uq")) {
				e.printStackTrace();
				throw new DALException("Le pseudo est déjà utilisé");
			}if(e.getMessage().contains("utilisateurs_email_uq")) {
				e.printStackTrace();
				throw new DALException("L'email est déjà utilisé");
			}
		}
	}
}
