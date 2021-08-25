package fr.eni.jee.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
	
	
	public List<User> afficherUser(int no_utilisateur) throws BLLException {
		List<User> newuser = new ArrayList<User>();
		try {
			newuser = ObjectDAO.afficherUser(no_utilisateur);
			
		}catch(DALException | SQLException e) {
			e.printStackTrace();
			throw new BLLException("Erreur dans le ProfilManager + " + e.getMessage());
		}
		return newuser;
	}
}
