package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.jee.enchere.dal.ConnectionProvider;

public class JDBCImplObjectDAO {
	private static String SQL_VERIFLOGIN = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?;"; 

	public boolean validerConnexion(String pseudo, String mdp) throws DALException{
		boolean statutCo = false;
		try {
			Connection connection = ConnectionProvider.getConnection();
			
			PreparedStatement pS = connection.prepareStatement(SQL_VERIFLOGIN);
			pS.setString(1, pseudo);
			pS.setString(2, mdp);
			ResultSet rs = pS.executeQuery();
			statutCo = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Le login n'est pas reconnu");
		}
		return statutCo;
	}
}
