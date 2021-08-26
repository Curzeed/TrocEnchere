package fr.eni.jee.enchere.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.jee.enchere.bo.Article;
import fr.eni.jee.enchere.bo.Enchere;
import fr.eni.jee.enchere.dal.DALException;
import fr.eni.jee.enchere.dal.JDBCImplEnchereDAO;

public class EnchereManager {

	public List<Article> selectEncheres() throws BLLException{
		
		List<Article> newlist;
		JDBCImplEnchereDAO enchereDAO = new JDBCImplEnchereDAO();
		
		try {
			newlist = enchereDAO.listeEnchere();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException("Erreur dans la BLL" + e.getMessage());
		}
		return newlist;
	}

	public void newEnchere(Enchere enchere) throws BLLException{
		
		JDBCImplEnchereDAO enchereDAO = new JDBCImplEnchereDAO();
		
		try {
			enchereDAO.insertEnchere(enchere);
		}catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur dans la BLL +" + e.getMessage());
		}
	}

}
