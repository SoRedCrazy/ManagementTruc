import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class chauffeur extends personne {
 private int id;
 private ArrayList<trajet> listtrajet;
public chauffeur(String nom,String prenom,String mail,int id) {
	super(nom,prenom,mail);
	this.id=id;
	this.listtrajet= new ArrayList<trajet>();
	maj();
}
//ajouter un tajet 
public void add(int idtrajet,String villedepart,String villearriver,String datedepart,String datearriver,double poids,int prix,int status) {
	try {
	for(int i=0;i<this.listtrajet.size();i++) {
		if(((trajet) this.listtrajet.get(i)).getIdtrajet()==idtrajet) {
			throw new ColisExisteBase("Impossible se compte existe deja");
		}
		}
	//utilisation fichier tampont
	FileReader reader1 = new FileReader("trajet.txt");
	BufferedReader breader1=new BufferedReader(reader1);
	Scanner in=new Scanner(breader1);
	
	FileWriter writer1=new FileWriter("tampont.txt");
	BufferedWriter bwriter1= new BufferedWriter(writer1);
	PrintWriter tampont=new PrintWriter(bwriter1);	
	
	while(in.hasNextLine()) {
		String line=in.nextLine();
	tampont.println(line);
	}
	
	tampont.println(idtrajet+":"+this.id+":"+villedepart+":"+villearriver+":"+datedepart+":"+datearriver+":"+poids+":"+prix+":"+status);
	tampont.close();
	
	//copie fichier de base
	FileReader reader2 = new FileReader("tampont.txt");
	BufferedReader breader2=new BufferedReader(reader2);
	Scanner in2=new Scanner(breader2);
	
	FileWriter writer2=new FileWriter("trajet.txt");
	BufferedWriter bwriter2= new BufferedWriter(writer2);
	PrintWriter out=new PrintWriter(bwriter2);
	
	while(in2.hasNextLine()) {
		String line=in2.nextLine();
		out.println(line);
	}
	out.close();
	maj();//mise a jour de la list
	
	}
	catch(ColisExisteBase e) {	
		System.out.println("Impossible se compte existe deja");
	} catch (IOException e) {
	}
}
//supprimer un colis 
public void del(int idtrajet) {
	
	try {
		//utilisation fichier tampont
		FileReader reader1 = new FileReader("trajet.txt");
		BufferedReader breader1=new BufferedReader(reader1);
		Scanner in=new Scanner(breader1);
		
		FileWriter writer1=new FileWriter("tampont.txt");
		BufferedWriter bwriter1= new BufferedWriter(writer1);
		PrintWriter tampont=new PrintWriter(bwriter1);	
		
		while(in.hasNextLine()) {
			String line=in.nextLine();
			String[] tab=line.split(":");
			if(idtrajet==Integer.parseInt(tab[0])) {	
			}
			else {
				tampont.println(line);
			}
		}
		tampont.close();
		//copie fichier de base
		FileReader reader2 = new FileReader("tampont.txt");
		BufferedReader breader2=new BufferedReader(reader2);
		Scanner in2=new Scanner(breader2);
		
		FileWriter writer2=new FileWriter("trajet.txt");
		BufferedWriter bwriter2= new BufferedWriter(writer2);
		PrintWriter out=new PrintWriter(bwriter2);
		
		while(in2.hasNextLine()) {
			String line=in2.nextLine();
			out.println(line);
		}
		out.close();
		maj();//mise a jour de la list
}
	catch (FileNotFoundException e) {
	System.out.println("not found fichier");
} 	catch (IOException e) {
}
}
//modifier une colis pour un chauffeur
public void modification(int idtrajet,String villedepart,String villearriver,String datedepart,String datearriver,double poids,int prix,int status) {
	try {
	//utilisation fichier tampont
	FileReader reader1 = new FileReader("trajet.txt");
	BufferedReader breader1=new BufferedReader(reader1);
	Scanner in=new Scanner(breader1);
	
	FileWriter writer1=new FileWriter("tampont.txt");
	BufferedWriter bwriter1= new BufferedWriter(writer1);
	PrintWriter tampont=new PrintWriter(bwriter1);	
	while(in.hasNextLine()) {
		String line=in.nextLine();
		String[] tab=line.split(":");
		if(idtrajet==Integer.parseInt(tab[0])) {
			tampont.println(idtrajet+":"+this.id+":"+villedepart+":"+villearriver+":"+datedepart+":"+datearriver+":"+poids+":"+prix+":"+status);
		}
		else {
			tampont.println(line);
		}
	}
	tampont.close();
	//copie fichier de base
	FileReader reader2 = new FileReader("tampont.txt");
	BufferedReader breader2=new BufferedReader(reader2);
	Scanner in2=new Scanner(breader2);
	
	FileWriter writer2=new FileWriter("trajet.txt");
	BufferedWriter bwriter2= new BufferedWriter(writer2);
	PrintWriter out=new PrintWriter(bwriter2);
	
	while(in2.hasNextLine()) {
		String line=in2.nextLine();
		out.println(line);
	}
	out.close();
	maj();//mise a jour de la list
	}
	catch (FileNotFoundException e) {
		System.out.println("not found fichier");
	} 
	catch (IOException e) {
			
	}
}
//maj de la liste
public void maj() {
	FileReader reader;
	try {
		for(int i=0;i<this.listtrajet.size();i++) {
				this.listtrajet.remove(i);
		}
		reader = new FileReader("trajet.txt");
		BufferedReader reader1=new BufferedReader(reader);
		Scanner in=new Scanner(reader1);
		while(in.hasNextLine()) {
			String[] line=in.nextLine().split(":");
			if(this.id==Integer.parseInt(line[1])) {
			trajet t=new trajet(Integer.parseInt(line[0]),Integer.parseInt(line[1]),line[2],line[3],line[4],line[5],Double.parseDouble(line[6]),Integer.parseInt(line[7]),Integer.parseInt(line[8]));
			this.listtrajet.add(t);
			}

		}
	} catch (FileNotFoundException e) {
	
		System.out.println("fichier not found ");
	}
}
//creation d'un tableau d'affichage
public String[][] tab(){
	String[][] tab=new String[30][9];
	FileReader reader;
	try {
		int n=0;
		reader = new FileReader("trajet.txt");
		BufferedReader reader1=new BufferedReader(reader);
		Scanner in=new Scanner(reader1);
		while(in.hasNextLine()) {
			String[] line=in.nextLine().split(":");
			if(Integer.parseInt(line[1])==this.id) {
				for(int i=0;i<9;i++) {
				tab[n][i]=line[i];	
				}
				n+=1;
			}
			}
		return tab;
	} catch (FileNotFoundException e) {
	}
	return tab;
}
public String getPrenom() {
	return super.getPrenom();	
}
}
