import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dispatcheur extends personne {
	 private int id;
	 private ArrayList<colis> listcolis;
	public dispatcheur(String nom,String prenom,String mail,int id) {
		super(nom,prenom,mail);
		this.id=id;
		this.listcolis= new ArrayList<colis>();
		
	}
	
	//remplir la liste 
	public void remplir(String file) {
		try {
			FileReader reader3 = new FileReader(file);
			BufferedReader breader1=new BufferedReader(reader3);
			Scanner in3=new Scanner(breader1);

			FileWriter writer3=new FileWriter("colis.txt");
			BufferedWriter bwriter3= new BufferedWriter(writer3);
			PrintWriter out2=new PrintWriter(bwriter3);
			while(in3.hasNextLine()) {
				out2.println(in3.nextLine());	
			}
			out2.close();
			
			for(int i=0;i<this.listcolis.size();i++) {
					this.listcolis.remove(i);
			}
			FileReader reader = new FileReader("colis.txt");
			BufferedReader breader=new BufferedReader(reader);
			Scanner in=new Scanner(breader);
			while(in.hasNextLine()) {
				String[] line=in.nextLine().split(":");
				colis c=new colis(Integer.parseInt(line[0]),line[1],line[2],Integer.parseInt(line[3]),Integer.parseInt(line[4]));
				this.listcolis.add(c);

			}
		} catch (FileNotFoundException e) {
		
			System.out.println("fichier not found ");
		} catch (IOException e) {

		}

	}
	
	//dispatche le colis 
	public void dispatche() {
		FileReader reader,reader2,reader3;
		try {
			reader = new FileReader("colis.txt");
			BufferedReader reader1=new BufferedReader(reader);
			Scanner in=new Scanner(reader1);

			FileWriter writer2=new FileWriter("tampont.txt");
			BufferedWriter bwriter2= new BufferedWriter(writer2);
			PrintWriter out=new PrintWriter(bwriter2);
			while(in.hasNextLine()) {
				int n=0;
				String ligne=in.nextLine();
				String[] line=ligne.split(":");
				reader2 = new FileReader("trajet.txt");
				BufferedReader breader2=new BufferedReader(reader2);
				Scanner in2=new Scanner(breader2);
				while(in2.hasNextLine()) {
					String[] line2=in2.nextLine().split(":");
					if(line[1].equals(line2[3])) {
						if(Integer.parseInt(line[4])<=Integer.parseInt(line2[7])) {
							n+=1;
							out.println(line[0]+":"+line[1]+":"+line[2]+":"+line2[8]+":"+line[4]);
							break;
						}
					}
				}
				if(n==0) {
					out.println(ligne);	
				}
				
  
			}
			out.close();
			
			reader3 = new FileReader("tampont.txt");
			BufferedReader breader=new BufferedReader(reader3);
			Scanner in3=new Scanner(breader);

			FileWriter writer3=new FileWriter("colis.txt");
			BufferedWriter bwriter3= new BufferedWriter(writer3);
			PrintWriter out2=new PrintWriter(bwriter3);
			while(in3.hasNextLine()) {
				out2.println(in3.nextLine());	
			}
			out2.close();
			
		} catch (FileNotFoundException e) {
		
			System.out.println("fichier not found ");
		} catch (IOException e) {

		}

	}
	
	public String[][] tab(){
		String[][] tab=new String[30][5];
		FileReader reader;
		try {
			int n=0;
			reader = new FileReader("colis.txt");
			BufferedReader reader1=new BufferedReader(reader);
			Scanner in=new Scanner(reader1);
			while(in.hasNextLine()) {
				String[] line=in.nextLine().split(":");
					for(int i=0;i<5;i++) {
					tab[n][i]=line[i];	
					}
					n+=1;
				}
			return tab;
		} catch (FileNotFoundException e) {
		}
		return tab;
	}
	

}
