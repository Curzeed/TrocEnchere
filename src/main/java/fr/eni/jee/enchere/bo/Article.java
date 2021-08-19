package fr.eni.jee.enchere.bo;

public class Article {
	
	private int idArticle;
	private String article;
	private String description;
	private String dateDebut;
	private String dateFin;
	private int prix;
	private int prix_vente;
	private int idVendeur;
	private String categorie;
	private String etat = "CR";
	private String image;
	
	
	public Article(int idArticle, String article, String description, String dateDebut, String dateFin, int prix,
			int prix_vente, int idVendeur, String categorie, String etat, String image) {
		super();
		this.idArticle = idArticle;
		this.article = article;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.prix_vente = prix_vente;
		this.idVendeur = idVendeur;
		this.categorie = categorie;
		this.etat = etat;
		this.image = image;
	}


	public Article(String article, String description, String dateDebut, String dateFin, int prix, int prix_vente,
			int idVendeur, String categorie, String etat, String image) {
		super();
		this.article = article;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.prix_vente = prix_vente;
		this.idVendeur = idVendeur;
		this.categorie = categorie;
		this.etat = etat;
		this.image = image;
	}

	public Article(String article, String description, String dateDebut, String dateFin, int prix, int idVendeur,
			String categorie, String etat, String image) {
		super();
		this.article = article;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.idVendeur = idVendeur;
		this.categorie = categorie;
		this.etat = etat;
		this.image = image;
	}


	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}


	public String getArticle() {
		return article;
	}


	public void setArticle(String article) {
		this.article = article;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getPrix_vente() {
		return prix_vente;
	}


	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}


	public int getIdVendeur() {
		return idVendeur;
	}


	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
