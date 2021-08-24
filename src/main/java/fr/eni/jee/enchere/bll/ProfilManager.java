package fr.eni.jee.enchere.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.jee.enchere.bo.User;
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
	private JDBCImplProfilDAO ObjectDAO1 = new JDBCImplProfilDAO();
	
	
	public List<User> afficherUser(int no_utilisateur) {
		List<User> newuser = null;
		
		try {
			newuser = ObjectDAO1.afficherUser(no_utilisateur);
			
		}catch(DALException | SQLException e) {
			e.printStackTrace();
		}
		return newuser;
	}
}
