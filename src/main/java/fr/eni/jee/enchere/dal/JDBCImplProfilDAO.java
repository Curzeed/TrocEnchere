package fr.eni.jee.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCImplProfilDAO {
	private static String SQL_DELETE = "DELETE FROM UTILISATEURS WHERE pseudo=?;";
	public void deleteUser(String pseudo) throws DALException, SQLException{
		try {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pS = connection.prepareStatement(SQL_DELETE);
		pS.setString(1, pseudo);
		pS.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new DALException("Erreur dans la requête delete");
		}
		
	}
}
