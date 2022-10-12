
public class trajet {
int idtrajet,idchauffeur,prix,status;
double poids;
String villedepart,villearriver,datedepart,datearriver;
//definition d'un trajet
public trajet(int idtrajet,int idchauffeur,String villedepart,String villearriver,String datedepart,String datearriver,double poids,int prix,int status) {
	this.idtrajet=idtrajet;
	this.idchauffeur=idchauffeur;
	this.villedepart=villedepart;
	this.villearriver=villearriver;
	this.datedepart=datedepart;
	this.datearriver=datearriver;
	this.poids=poids;
	this.prix=prix;
	this.status=status;
}
public int getIdtrajet() {
	return idtrajet;
}
public void setIdtrajet(int idtrajet) {
	this.idtrajet = idtrajet;
}
public int getIdchauffeur() {
	return idchauffeur;
}
public void setIdchauffeur(int idchauffeur) {
	this.idchauffeur = idchauffeur;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public double getPoids() {
	return poids;
}
public void setPoids(double poids) {
	this.poids = poids;
}
public String getVilledepart() {
	return villedepart;
}
public void setVilledepart(String villedepart) {
	this.villedepart = villedepart;
}
public String getVillearriver() {
	return villearriver;
}
public void setVillearriver(String villearriver) {
	this.villearriver = villearriver;
}
public String getDatedepart() {
	return datedepart;
}
public void setDatedepart(String datedepart) {
	this.datedepart = datedepart;
}
public String getDatearriver() {
	return datearriver;
}
public void setDatearriver(String datearriver) {
	this.datearriver = datearriver;
}
}
