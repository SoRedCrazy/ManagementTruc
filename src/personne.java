public class personne {
	private String nom,prenom,mail;
	//classe qui definie les personnes
public personne(String nom,String prenom,String mail) {
	this.nom=nom;
	this.prenom=prenom;
	this.mail=mail;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
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


}
