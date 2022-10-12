
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
import javax.swing.JTextField;

	public class interface_dispatcheur {
		private String nom,prenom,mails;
		private int idchauffeur;
		private JTextField files;
		private JButton charger,dispatche,actualiser;
		private JTable tableau ;
		private JLabel message;
		private JFrame cadre;
		private JPanel fen2, fen1;
		private dispatcheur dispat;
		private String[] entetes = {"id colis", "ville d'arriver","date d'ajout","status","poids"};
		public interface_dispatcheur(String mail){
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
						mails=line[0];
						idchauffeur=Integer.parseInt(line[5]);
					}
				}
			} catch (FileNotFoundException e) {
			}

			dispat=new dispatcheur(nom,prenom,mails,idchauffeur);
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
			message= new JLabel("Bienvenue dans l'interface : "+dispat.getPrenom());
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 0;
			fen1.add(message,c);
			//text info
			message= new JLabel("entrer la localiter du fichier:");
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 1;
			fen1.add(message,c);
			
			//text field
			files=new JTextField();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 2;
			fen1.add (files,c);
			
			//boutton charger
			charger=new JButton("charger");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 3;
			fen1.add (charger,c);
			charger.addActionListener(new intercharger());
			
			//boutton dispatche
			dispatche=new JButton("dispatche");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(10,0,0,0);
			c.ipady = 40;  
			c.gridx = 0;
			c.gridy = 4;
			fen1.add(dispatche,c);
			dispatche.addActionListener(new interdispatche());
			
			
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
			tableau = new JTable(dispat.tab(), entetes);
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
		class intercharger implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				dispat.remplir(files.getText());
				interface_dispatcheur n=new interface_dispatcheur(mails);
				cadre.dispose();
			}
		}
		class interdispatche implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				dispat.dispatche();
				interface_dispatcheur n=new interface_dispatcheur(mails);
				cadre.dispose();
				 
			}
		}
		class interactualiser implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				interface_dispatcheur n=new interface_dispatcheur(mails);
				cadre.dispose();
			}
		}
		public void actionPerformed(ActionEvent arg0) {
			
		}

}

