package fr.eni.jee.enchere.bll;

import fr.eni.jee.enchere.bo.User;
import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImplObjectDAO;

public class ObjectManager {
	
	private JDBCImplObjectDAO ObjectDAO = new JDBCImplObjectDAO();
	
	public boolean valideLogin(String pseudo, String mdp) throws BLLException {
		
		boolean result = false;
		
		try {
			result = ObjectDAO.validerConnexion(pseudo, mdp);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException("Erreur dans la BLL (requête du Login)");
		}return result;
	}
	
	
	public User addUser(String pseudo, String nom, String prenom, String email, String tel, String rue, String codepostal, String ville,
			String motdePasse) throws BLLException{
		User nouveauUser;
		try {
			nouveauUser = new User(pseudo, nom, prenom, email, tel, rue, codepostal, ville, motdePasse, 100); 
			ObjectDAO.addUser(nouveauUser);
		} catch(DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur dans la BLL (requête addUser)");
		}return nouveauUser;
	}
}
