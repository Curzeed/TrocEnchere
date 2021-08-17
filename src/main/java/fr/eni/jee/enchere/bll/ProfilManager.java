package fr.eni.jee.enchere.bll;

import java.sql.SQLException;

import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImplProfilDAO;

public class ProfilManager {
	
	private JDBCImplProfilDAO ObjectDAO = new JDBCImplProfilDAO();
	public void deleteUser(String pseudo) {
		try {
			ObjectDAO.deleteUser(pseudo);
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}
	}

}
