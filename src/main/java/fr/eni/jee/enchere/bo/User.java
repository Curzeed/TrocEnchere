package fr.eni.jee.enchere.bo;

public class User {

	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String mdp;
	private int credit;
	private byte administrateur;
	
	public User(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			int codePostal, String ville, String mdp, int credit) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
	}
	
	
	public User(String pseudo, String nom, String prenom, String email, String telephone, String rue, int codePostal,
			String ville, String mdp, int credit) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
	}


	public User(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			int codePostal, String ville, String mdp, int credit, byte administrateur) {
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.administrateur = administrateur;
	}


	public byte getAdministrateur() {
		return administrateur;
	}


	public void setAdministrateur(byte administrateur) {
		this.administrateur = administrateur;
	}


	public User(String pseudo, String mdp) {
		super();
		this.pseudo = pseudo;
		this.mdp = mdp;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}

	
}
