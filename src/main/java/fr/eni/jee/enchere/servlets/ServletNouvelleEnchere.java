package fr.eni.jee.enchere.servlets;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.jee.enchere.bll.ArticleManager;
import fr.eni.jee.enchere.bll.BLLException;
import fr.eni.jee.enchere.bo.Categorie;
import fr.eni.jee.enchere.bo.User;

@WebServlet("/venteEnchere")
@MultipartConfig 
public class ServletNouvelleEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIRECTORY = "uploads";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager am = new ArticleManager();
		
		String appPath = request.getServletContext().getRealPath("");
		
		Part part = request.getPart("pictureFile");
		
		String fileName = saveFile(appPath, part);
		
		User utilisateur = (User) request.getSession().getAttribute("utilisateur");
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int categorie = Integer.parseInt(request.getParameter("categories"));
		int prix = Integer.parseInt(request.getParameter("prix"));
		LocalDateTime dateDebut = LocalDateTime.parse(request.getParameter("dateDebut"));
		LocalDateTime dateFin = LocalDateTime.parse(request.getParameter("dateFin"));
		String etatVente = "EC";	
		
		System.out.println(categorie);
		try {
			am.addArticle(article, description, dateDebut, dateFin, prix, utilisateur.getId(),categorie, etatVente, fileName);
		}catch (BLLException e) {
			request.setAttribute("erreur", e);
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager am = new ArticleManager();
		try {
			List<Categorie> listeCategorie = am.selectCategorie();
			request.setAttribute("listcategory", listeCategorie);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp").forward(request, response);
	}
	public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
	private String saveFile(String appPath, Part part) throws IOException { 
        appPath = appPath.replace('\\', '/');
        // The directory to save uploaded file
        String fullSavePath = null; 
        if (appPath.endsWith("/")) { 
            fullSavePath = appPath + SAVE_DIRECTORY; 
        } else { 
            fullSavePath = appPath + "/" + SAVE_DIRECTORY; 
        } 
        // Creates the save directory if it does not exists 
        File fileSaveDir = new File(fullSavePath); 
        if (!fileSaveDir.exists()) { 
           fileSaveDir.mkdir(); 
        }  
        String filePath=null; 
        String fileName = extractFileName(part); 
        System.out.println(fileName); 
        String[] fn = fileName.split("(\\.)"); 
        fileName = fn[0]; 
        String ext = fn[(fn.length-1)]; 
        if(!ext.isEmpty()) { 
        	//generate a unique file name 
        	UUID uuid = UUID.randomUUID(); 
        	fileName = fileName + "_" + uuid.toString() + "." + ext ; 
        	if (fileName != null && fileName.length() > 0) { 
        		filePath = fullSavePath + File.separator + fileName; 
        		System.out.println("Write attachment to file: " + filePath); 
        		// Write to file 
        		part.write(filePath); 
        	} 
        }return fileName; 
} 
/** 
 * extraire le nom du fichier provenant du client 
 * @param part 
 * @return 
 */ 

    private String extractFileName(Part part) { 
        String contentDisp = part.getHeader("content-disposition"); 
        String[] items = contentDisp.split(";"); 
        for (String s : items) { 
            if (s.trim().startsWith("filename")) { 
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1); 
                clientFileName = clientFileName.replace("\\", "/"); 
                int i = clientFileName.lastIndexOf('/'); 
                return clientFileName.substring(i + 1); 
            } 
        }return null; 

    }
}
