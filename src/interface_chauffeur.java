import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

	public class interface_chauffeur {
		private String nom,prenom,mail;
		private int idchauffeur;
		private JButton Modifier,ajouter,supprimer,actualiser;
		private JTable tableau ;
	    private String mails;
		private JLabel message;
		private JFrame cadre;
		private JPanel fen2, fen1,fen3;
		private String[] entetes = {"id trajet", "id chauffeur", "ville de depart", "ville d'arriver", "date de depart","date d'arriver","poids","prix","status"};
		public interface_chauffeur(String mail){
			FileReader reader;
			try {
				reader = new FileReader("login.txt");
				BufferedReader reader1=new BufferedReader(reader);
				Scanner in=new Scanner(reader1);
				while(in.hasNextLine()) {
					String[] line=in.nextLine().split(":");
					if(mail.equals(line[0])) {
						nom=line[4];
						prenom=line[3];
						mail=line[0];
						idchauffeur=Integer.parseInt(line[5]);
					}
				}
			} catch (FileNotFoundException e) {
			}

			chauffeur chauffeur1=new chauffeur(nom,prenom,mail,idchauffeur);
			mails=mail; //permet de recuperer le mail dans les sous class
			cadre	=	new	JFrame();
			cadre.setTitle ("GestionJuju/chaffeur");
			cadre.setSize (1500,1100)	;
			fen1 =new JPanel();
			fen2 =new JPanel();
			JPanel bigfen =new JPanel();
			bigfen.setLayout(new GridLayout(1,2));
			fen1.setLayout(new GridBagLayout());
			fen2.setLayout(new GridLayout(2,1));
			GridBagConstraints c = new GridBagConstraints();
			
			//Text
			message= new JLabel("Bienvenue dans l'interface : "+chauffeur1.getPrenom());
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 1;
			fen1.add(message,c);
			
			//boutton modifier
			Modifier=new JButton("modifier");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 2;
			fen1.add (Modifier,c);
			Modifier.addActionListener(new intermodifier());
			
			//boutton ajouter
			ajouter=new JButton("ajouter");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 3;
			fen1.add(ajouter,c);
			ajouter.addActionListener(new interajouter());
			
			//boutton del
			supprimer=new JButton("supprimer");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.gridwidth = 0;
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 4;
			fen1.add(supprimer,c);
			supprimer.addActionListener(new intersupprimer());
			
			//boutton actualiser
			actualiser=new JButton("actualiser");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.gridwidth = 0;
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 5;
			fen1.add(actualiser,c);
			actualiser.addActionListener(new interactualiser());
			
			//tableau
			tableau = new JTable(chauffeur1.tab(), entetes);
			fen2.add(tableau.getTableHeader());
			fen2.add(tableau);
			
			//ajoute au panel principal 
			bigfen.add(fen1);
			bigfen.add(fen2);
			
			//ajoute au frame et mis en place
			cadre.getContentPane().add(bigfen);
			cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cadre.setVisible(true);           

		}
		//action listener
		class interajouter implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				ajouter n=new ajouter(nom,prenom,mail,idchauffeur);
			}
		}
		class intersupprimer implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				 supprimer n=new supprimer(nom,prenom,mail,idchauffeur);
			}
		}
		class intermodifier implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				 modifier n=new modifier(nom,prenom,mail,idchauffeur);
			}
		}
		class interactualiser implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				interface_chauffeur n=new interface_chauffeur(mails);
				cadre.dispose();
			}
		}
		public void actionPerformed(ActionEvent arg0) {
			
		}

}
