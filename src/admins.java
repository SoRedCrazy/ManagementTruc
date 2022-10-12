import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class admins extends personne {
	private int nb_colis,nb_cree,nb_sollicite,nb_accepte,nb_cours,nb_livree;

	public admins(String nom, String prenom, String mail) {
		super(nom, prenom, mail);
		this.nb_colis=0;
		this.nb_cree=0;
		this.nb_sollicite=0;
		this.nb_accepte=0;
		this.nb_cours=0;
		this.nb_livree=0;
	}
	
	public int getNb_colis() {
		return nb_colis;
	}

	public void setNb_colis(int nb_colis) {
		this.nb_colis = nb_colis;
	}

	public int getNb_cree() {
		return nb_cree;
	}

	public void setNb_cree(int nb_cree) {
		this.nb_cree = nb_cree;
	}

	public int getNb_sollicite() {
		return nb_sollicite;
	}

	public void setNb_sollicite(int nb_sollicite) {
		this.nb_sollicite = nb_sollicite;
	}

	public int getNb_accepte() {
		return nb_accepte;
	}

	public void setNb_accepte(int nb_accepte) {
		this.nb_accepte = nb_accepte;
	}

	public int getNb_cours() {
		return nb_cours;
	}

	public void setNb_cours(int nb_cours) {
		this.nb_cours = nb_cours;
	}

	public int getNb_livree() {
		return nb_livree;
	}

	public void setNb_livree(int nb_livree) {
		this.nb_livree = nb_livree;
	}
	//stats chauffeur trajet
	public void statschauffeur(int id) {
		reset();
		FileReader reader1;
		try {
			reader1 = new FileReader("trajet.txt");
			BufferedReader breader1=new BufferedReader(reader1);
			Scanner in=new Scanner(breader1);
			while(in.hasNextLine()){
				
				String[] line=in.nextLine().split(":");
				if(id==Integer.parseInt(line[1])) {
					this.nb_colis+=1;
					if(line[8].equals("0")) {
						this.nb_cree+=1;
					}
					else {
						if(line[8].equals("1")) {
							this.nb_sollicite+=1;
						}
						else {
							if(line[8].equals("2")) {
								this.nb_accepte+=1;
							}
							else {
								if(line[8].equals("3")) {
									this.nb_cours+=1;
								}
								else {
									if(line[8].equals("4")) {
										this.nb_livree+=1;
									}
								}
							}	
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}

	//stats global tout les colis
	public void statsglobal() {
		reset();
		FileReader reader1;
		try {
			reader1 = new FileReader("colis.txt");
			BufferedReader breader1=new BufferedReader(reader1);
			Scanner in=new Scanner(breader1);
			while(in.hasNextLine()){
				this.nb_colis+=1;
				String[] line=in.nextLine().split(":");
					if(line[3].equals("0")) {
						this.nb_cree+=1;
					}
					else {
						if(line[3].equals("1")) {
							this.nb_sollicite+=1;
						}
						else {
							if(line[3].equals("2")) {
								this.nb_accepte+=1;
							}
							else {
								if(line[3].equals("3")) {
									this.nb_cours+=1;
								}
								else {
									if(line[3].equals("4")) {
										this.nb_livree+=1;
									}
								}
							}	
						}
					}
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}

	//remis a zero des variable
	public void reset() {
		this.nb_colis=0;
		this.nb_cree=0;
		this.nb_sollicite=0;
		this.nb_accepte=0;
		this.nb_cours=0;
		this.nb_livree=0;
	}
	

}
