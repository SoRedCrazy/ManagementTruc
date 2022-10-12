import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class interface_admins {
	admins admin;
	private String nom,prenom,mails;
	JLabel nb_colis,nb_cree,nb_sollicite,nb_accepte,nb_cours,nb_livree;
	ButtonGroup	groupe;
	JRadioButton global, chauffeur1,chauffeur2,chauffeur3,chauffeur4,chauffeur5;
	JButton dispatcheur;
	JFrame cadre;
	public interface_admins(String mail){
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
				}
			}
		} catch (FileNotFoundException e) {
		}

		admin=new admins(nom,prenom,mails);
		// tout les employer en bouton radio
		groupe	=	new	ButtonGroup()	;
		global	=	new	JRadioButton	("Global",	true)	;
		groupe.add(global)	;
		global.addActionListener(new global());
		chauffeur1	=	new	JRadioButton	("brian")	;
		groupe.add(chauffeur1)	;
		chauffeur1.addActionListener(new chauffeur1());
		chauffeur2	=	new	JRadioButton	("pierre")	;
		groupe.add(chauffeur2)	;
		chauffeur2.addActionListener(new chauffeur2());
		chauffeur3	=	new	JRadioButton	("herver")	;
		groupe.add(chauffeur3)	;
		chauffeur3.addActionListener(new chauffeur3());
		chauffeur4	=	new	JRadioButton	("abdel")	;
		groupe.add(chauffeur4)	;
		chauffeur4.addActionListener(new chauffeur4());
		chauffeur5	=	new	JRadioButton	("patrique")	;
		groupe.add(chauffeur5)	;
		chauffeur5.addActionListener(new chauffeur5());
		
		cadre	=	new	JFrame();
		cadre.setTitle ("GestionJuju/admins");
		cadre.setSize (1200,400)	;
		JPanel fen =new JPanel();
		fen.setLayout(new GridLayout(3,6));
		//1er ligne 
		fen.add(global);
		fen.add(chauffeur1);
		fen.add(chauffeur2);
		fen.add(chauffeur3);
		fen.add(chauffeur4);
		fen.add(chauffeur5);
		admin.statsglobal();
		//2eme ligne 
		fen.add(nb_colis=new JLabel("Nombre de colis :"+admin.getNb_colis()));
		fen.add(nb_cree=new JLabel("Nombre de colis cree :"+admin.getNb_cree()));
		fen.add(nb_sollicite=new JLabel("Nombre de colis sollicité:"+admin.getNb_sollicite()));
		fen.add(nb_accepte=new JLabel("Nombre de colis accepté:"+admin.getNb_accepte()));
		fen.add(nb_cours=new JLabel("Nombre de colis en livraison:"+admin.getNb_cours()));
		fen.add(nb_livree=new JLabel("Nombre de colis livrée :"+admin.getNb_livree()));
		//3eme ligne 
		fen.add(new JLabel(""));
		fen.add(new JLabel(""));
		fen.add(new JLabel(""));
		fen.add(new JLabel(""));
		fen.add(new JLabel(""));
		fen.add(dispatcheur=new JButton("interface Dispatcheur"));
		dispatcheur.addActionListener(new intdispatcheur());
		
		cadre.getContentPane().add(fen);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadre.setVisible(true);           

	}
	 //action listener
	class global implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			admin.statsglobal(); 
			nb_colis.setText("Nombre de colis :"+admin.getNb_colis());
			nb_cree.setText("Nombre de colis cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de colis sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de colis accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de colis en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de colis livrée :"+admin.getNb_livree());
		}
	}
	class chauffeur1 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			admin.statschauffeur(1);
			nb_colis.setText("Nombre de trajet :"+admin.getNb_colis());
			nb_cree.setText("Nombre de trajet cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de trajet sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de trajet accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de trajet en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de trajet livrée :"+admin.getNb_livree());
		}
	}
	class chauffeur2 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			admin.statschauffeur(2);
			nb_colis.setText("Nombre de trajet :"+admin.getNb_colis());
			nb_cree.setText("Nombre de trajet cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de trajet sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de trajet accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de trajet en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de trajet livrée :"+admin.getNb_livree());
		}
	}
	class chauffeur3 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			admin.statschauffeur(3);
			nb_colis.setText("Nombre de trajet :"+admin.getNb_colis());
			nb_cree.setText("Nombre de trajet cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de trajet sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de trajet accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de trajet en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de trajet livrée :"+admin.getNb_livree());
		}
	}
	class chauffeur4 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			admin.statschauffeur(4);
			nb_colis.setText("Nombre de trajet :"+admin.getNb_colis());
			nb_cree.setText("Nombre de trajet cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de trajet sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de trajet accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de trajet en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de trajet livrée :"+admin.getNb_livree());
		}
	}
	class chauffeur5 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			admin.statschauffeur(5);
			nb_colis.setText("Nombre de trajet :"+admin.getNb_colis());
			nb_cree.setText("Nombre de trajet cree :"+admin.getNb_cree());
			nb_sollicite.setText("Nombre de trajet sollicité:"+admin.getNb_sollicite());
			nb_accepte.setText("Nombre de trajet accepté:"+admin.getNb_accepte());
			nb_cours.setText("Nombre de trajet en livraison:"+admin.getNb_cours());
			nb_livree.setText("Nombre de trajet livrée :"+admin.getNb_livree());
		}
	}
	class intdispatcheur implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			interface_dispatcheur d=new interface_dispatcheur("admin1@gmail.com");
		}
	}
}
