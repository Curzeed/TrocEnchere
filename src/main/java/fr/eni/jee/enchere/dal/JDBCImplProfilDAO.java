package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.enchere.bo.User;

public class JDBCImplProfilDAO {
	private static String SQL_DELETE = "DELETE FROM UTILISATEURS WHERE pseudo=?;";
	private static String SQL_AFFICHER_PROFIL= "SELECT *  FROM UTILISATEURS WHERE no_utilisateur=? ;";
	
		public void deleteUser(String pseudo) throws DALException, SQLException{
		try {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pS = connection.prepareStatement(SQL_DELETE);
		pS.setString(1, pseudo);
		pS.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new DALException("Erreur dans la requ�te delete");
		}
		
		
	}
		public List<User> afficherUser(int no_utilisateur) throws DALException, SQLException{
			
			try {
				List<User> newuser = new ArrayList<User>();
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pS = connection.prepareStatement(SQL_AFFICHER_PROFIL);
				pS.setInt(1, no_utilisateur);	
				ResultSet rs = pS.executeQuery();
				while(rs.next()) {
					User user = new User(no_utilisateur, rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getInt("code_postal"), rs.getString("ville"), rs.getInt("credit") , rs.getByte("administrateur"));
					newuser.add(user);
				}return newuser;
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DALException("Erreur dans la requete afficher profil");
			}
		}
}
