public class colis {
int idcolis,status,poids;
String villearriver,dateajout;
//def du colis 
public colis(int idcolis,String villearriver,String dateajout,int status,int poids) {
	this.idcolis=idcolis;
	this.villearriver=villearriver;
	this.dateajout=dateajout;
	this.status=status;
	this.poids=poids;
}
public int getIdcolis() {
	return idcolis;
}
public void setIdcolis(int idcolis) {
	this.idcolis = idcolis;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getVillearriver() {
	return villearriver;
}
public void setVillearriver(String villearriver) {
	this.villearriver = villearriver;
}
public String getDateajout() {
	return dateajout;
}
public void setDateajout(String dateajout) {
	this.dateajout = dateajout;
}
}
