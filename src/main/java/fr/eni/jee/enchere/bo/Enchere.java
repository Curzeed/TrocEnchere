package fr.eni.jee.enchere.bo;

import java.time.LocalDateTime;

public class Enchere {

	private int id_utilisateur;
	private int id_article;
	private LocalDateTime date_enchere;
	private int montant_enchere;
	
	public Enchere(int id_utilisateur, int id_article, LocalDateTime date_enchere, int montant_enchere) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.id_article = id_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	
	
}
